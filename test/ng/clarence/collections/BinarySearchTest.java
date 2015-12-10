package ng.clarence.collections;

import org.junit.Test;

import static junit.framework.TestCase.assertEquals;

public class BinarySearchTest {

    @Test
    public void findSmallestIndexGreaterThanOrEqualTo() {
        int[] input = new int[] { 1, 2, 2, 2, 5, 7 };
        assertEquals(1, BinarySearch.findSmallestIndexGreaterThanOrEqualTo(input, 2));
        assertEquals(4, BinarySearch.findSmallestIndexGreaterThanOrEqualTo(input, 4));
        assertEquals(0, BinarySearch.findSmallestIndexGreaterThanOrEqualTo(input, -5));
        assertEquals(5, BinarySearch.findSmallestIndexGreaterThanOrEqualTo(input, 10));
    }

    @Test
    public void findLargestIndexSmallerThanOrEqualTo() {
        int[] input = new int[] { 1, 2, 2, 2, 5, 7 };
        assertEquals(3, BinarySearch.findLargestIndexSmallerThanOrEqualTo(input, 4));
        assertEquals(0, BinarySearch.findLargestIndexSmallerThanOrEqualTo(input, -5));
        assertEquals(4, BinarySearch.findLargestIndexSmallerThanOrEqualTo(input, 6));
    }

    @Test
    public void numOfValuesInRangeInclusive() {
        int[] input = new int[] { 1, 2, 2, 2, 5, 7 };
        assertEquals(3, BinarySearch.numOfValuesInRangeInclusive(input, 2, 2));
        assertEquals(1, BinarySearch.numOfValuesInRangeInclusive(input, 5, 5));
        assertEquals(1, BinarySearch.numOfValuesInRangeInclusive(input, 5, 6));
        assertEquals(2, BinarySearch.numOfValuesInRangeInclusive(input, 5, 7));

        assertEquals(1, BinarySearch.numOfValuesInRangeInclusive(input, -1, 1));
        assertEquals(1, BinarySearch.numOfValuesInRangeInclusive(input, 1, 1));

        assertEquals(1, BinarySearch.numOfValuesInRangeInclusive(input, 7, 7));
        assertEquals(1, BinarySearch.numOfValuesInRangeInclusive(input, 7, 10));

        assertEquals(6, BinarySearch.numOfValuesInRangeInclusive(input, 0, 10));

        assertEquals(0, BinarySearch.numOfValuesInRangeInclusive(input, 6, 6));
    }
}
