class newSorting {
    public static void newSorting(int[] Array, int s) {
        if (Array.length < s) {
            newSorting arr = new newSorting();
            arr.quickSort(Array);
        } else {
            int[] shortGroup = new int[(Array.length + 1) / 2];
            int[] greatestGroup = new int[Array.length - shortGroup.length];
            for (int i = 0; i < Array.length; i++) {
                if (i < shortGroup.length) {
                    shortGroup[i] = Array[i];
                } else {
                    greatestGroup[i - shortGroup.length] = Array[i];
                }
            }
            newSorting(shortGroup, s);
            newSorting(greatestGroup, s);
            mergeSortedHalves(Array, shortGroup, greatestGroup);
        }
    }


    public static int totalquickSort(int Array[], int shortGroup, int greatestGroup) {
        int pivot = Array[greatestGroup];

        int leftPointer = shortGroup-1;
        for (int rightPointer = shortGroup; rightPointer < greatestGroup; rightPointer++) {
            if (Array[rightPointer] < pivot) {
                leftPointer++;
                int temp = Array[leftPointer];
                Array[leftPointer] = Array[rightPointer];
                Array[rightPointer] = temp;
            }
        }
        int temp = Array[leftPointer+1];
        Array[leftPointer+1] = Array[greatestGroup];
        Array[greatestGroup] = temp;
        leftPointer = leftPointer+1;
        return leftPointer;
    }

    public static int[] mergeSortedHalves(int[]Array, int[]shortGroup, int[]greatestGroup){
        int leftLength = shortGroup.length;
        int rightLength = greatestGroup.length;
        int count =0;
        int countLeft =0;
        int countRight =0;
        while(countLeft < leftLength && countRight < rightLength) {	
            if (shortGroup[countLeft] < greatestGroup[countRight]) {
                Array[count++] = shortGroup[countLeft++];
            } 
            else {
                Array[count++] = greatestGroup[countRight++];
            }
        }
        while (countLeft < leftLength) {
            Array[count++] = shortGroup[countLeft++];
        }
        while (countRight < rightLength) {
            Array[count++] = greatestGroup[countRight++];
        }
        return Array;
    }

    public static void quickSort(int[]Array){
        quickSort(Array, 0, Array.length-1);
    }

    public static void quickSort(int[] Array, int shortGroup, int greatestGroup) {
        if (shortGroup < greatestGroup) {
            int index = totalquickSort(Array, shortGroup, greatestGroup);
            quickSort(Array, shortGroup, index - 1);
            quickSort(Array, index + 1, greatestGroup);
        }
    }
}