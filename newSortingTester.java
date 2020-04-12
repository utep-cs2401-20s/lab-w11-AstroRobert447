import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

class newSortingTester{
    @Test
    public void test1() {
        int [] array = {7,8,6,10,4,2,9,5,3,1};//Here are the given array, I put this as a default (1-10 integers)
        int [] result = {1,2,3,4,5,6,7,8,9,10};//And here will show what the result expected on the array on top
        newSorting.newSorting(array, 5);
        assertArrayEquals(result, array);
    }

 
    @Test
    public void test2() {
        int [] array = {20,10};//Want to test a array with 2 integer.
        int [] result = {10,20};
        newSorting.newSorting(array, 5);
        assertArrayEquals(result, array);
    }
    
    @Test
    public void test3() {
        int [] array = {1,2,3};//Test to find out what would happen if the array are already in the right order.
        int [] result = {1,2,3};
        newSorting.newSorting(array, 2);
        assertArrayEquals(result, array);
    }
    
    @Test
    public void test4() {
        int [] array = {-2,20,1,10,-7};//Starting using the negative number to check if we get the error,even after the first one was already tested as different order.
        int [] result = {-7,-2,1,10,20};
        newSorting.newSorting(array, 2);
        assertArrayEquals(result, array);
    }


    @Test
    public void test5() {
        int [] array = {-2,15,0,2,-9,18};//First array that is going to test with a 0 integer, since its not a negative or a positive number.
        int [] result = {-9,-2,0,2,15,18};
        newSorting.newSorting(array, 6);
        assertArrayEquals(result, array);
    }

    
}
