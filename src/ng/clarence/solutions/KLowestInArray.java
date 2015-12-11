package ng.clarence.solutions;

public class KLowestInArray {

    public static int KLowestInArray(int[] array, int k) {
        return helper(array, 0, array.length, k);
    }

    private static int helper(int[] array, int start, int end, int k) {
        int i = partition(array, start, end);
        int iFromStart = i - start;
        if (iFromStart == k) {
            return findLargest(array, start, k + 1);
        } else if (i > k) {
            return helper(array, i + 1, end, k - i - 1);
        } else {
            return helper(array, start, i, k);
        }
    }

    private static int findLargest(int[] array, int start, int k) {
        int largest = Integer.MIN_VALUE;
        for (int i = start; i < k; i++) {
            if (array[i] > largest) largest = array[i];
        }
        return largest;
    }

    static int partition(int[] array, int start, int end) {
        int p = array[end];
        int l = start;
        int r = end - 1;
        while (true) {
            while (l < array.length && array[l] < p) {
                l++;
            }
            while (r >= 0 && array[r] > p) {
                r--;
            }
            if (l <= r) {
                swap(array, l, r);
            } else {
                break;
            }
        }
        swap(array, l, end);
        return l;
    }

    private static void swap(int[] array, int start, int end) {
        int tmp = array[end];
        array[end] = array[start];
        array[start] = tmp;
    }

}
