package ng.clarence.sorting;

import ng.clarence.utils.LoggerUtils;
import org.junit.Test;

import java.util.Arrays;
import java.util.logging.Level;
import java.util.logging.Logger;

import static org.junit.Assert.fail;

public class QuickSortTest {
    @Test
    public void test() {
        LoggerUtils.configureLoggerForStdOut(Logger.getGlobal(), Level.FINEST);

        int[] input = { 0, 1, 2, 3, 4, 5};
        QuickSort.sort(input);
        verifySorted(input);

        input = new int[] { 5, 1, 2, 7, 4, 3};
        QuickSort.sort(input);
        verifySorted(input);

        input = new int[] { 7, 6, 5, 3, 1, 2};
        QuickSort.sort(input);
        verifySorted(input);
    }

    private void verifySorted(int[] input) {
        if (input.length == 0) {
            return;
        }
        int current = input[0];
        for (int i = 1; i < input.length; i++) {
            if (current > input[i]) {
                System.out.println("failed input" + Arrays.toString(input));
                fail();
            }
            current = input[i];
        }
    }
}
