package ng.clarence.collections;

public class BinarySearch {

    // find the smallest index that is larger than or equal to target.
    static int findSmallestIndexGreaterThanOrEqualTo(int[] values, int target) {
        if (values.length == 0) return -1;
        int start = 0;
        int end = values.length - 1;

        while (end - start > 1) {
            int mid = (end + start) / 2;
            int midValue = values[mid];
            if (midValue < target) {
                start = mid;
            } else {
                end = mid;
            }
        }
        if (values[start] >= target) { return start; }
        return end;
    }

    // find the largest index that is smaller than or equals to target.
    static int findLargestIndexSmallerThanOrEqualTo(int[] values, int target) {
        if (values.length == 0) return -1;
        int start = 0;
        int end = values.length - 1;

        while (end - start > 1) {
            int mid = (end + start) / 2;
            int midValue = values[mid];
            if (midValue <= target) {
                start = mid;
            } else {
                end = mid;
            }
        }
        if (values[end] <= target) { return end; }
        return start;
    }

    public static int numOfValuesInRangeInclusive(int[] values, int start, int end) {
        if (values.length == 0) return 0;
        if (end < values[0] || start > values[values.length -1]) return 0;

        int startIndex = findSmallestIndexGreaterThanOrEqualTo(values, start);
        int endIndex = findLargestIndexSmallerThanOrEqualTo(values, end);
        return endIndex - startIndex + 1;
    }
}
