package ng.clarence.sorting;

import java.util.Arrays;
import java.util.logging.Level;
import java.util.logging.Logger;

public class QuickSort {
    public static void sort(int [] values) {
        internalSort(values, 0, values.length - 1);
    }

    private static void internalSort(int [] values, int start, int end) {
        Logger.getGlobal().log(Level.FINEST,
                String.format("internalSort %d %d %s", start, end, Arrays.toString(values)));
        if (end - start < 1) {
            return;
        } else if (end - start == 1) {
            if (values[start] > values[end]) {
                swap(values, start, end);
            }
            return;
        }

        int pivotValue = values[start];
        int leftIndex = start + 1;
        int rightIndex = end;
        while (leftIndex < rightIndex) {
            while (leftIndex <= end && values[leftIndex] < pivotValue) {
                leftIndex++;
            }
            while (rightIndex > start && values[rightIndex] >= pivotValue) {
                rightIndex--;
            }
            if (leftIndex < rightIndex) {
                swap(values, leftIndex, rightIndex);
            } else {
                swap(values, start, leftIndex - 1);
                break;
            }
        }
        internalSort(values, start, leftIndex - 2);
        internalSort(values, leftIndex, end);
    }

    private static void swap(int[] values, int start, int end) {
        if (start == end) {
            return;
        }
        int temp = values[start];
        values[start] = values[end];
        values[end] = temp;
    }
}
