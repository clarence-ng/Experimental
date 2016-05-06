package ng.clarence.solutions;

import org.junit.Test;

public class KLowestInArrayTest {

    @Test
    public void partitionTest() {
        int[] array = new int[] {7, 9, 2, 4, 6, 5, 8, 3};
        System.out.println(KLowestInArray.partition(array, 0, array.length - 1));
        for (int i = 0; i < array.length; i++) {
            System.out.print(array[i]);
        }
    }
}
