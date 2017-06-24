package ng.clarence.solutions;

import org.junit.Test;
import static org.junit.Assert.assertEquals;

public class LongestIncreasingSubsequenceTest {

    @Test
    public void sanity() {
        int[] input = new int[] { -22, 0, 10, -20, -15, -10, -5, 4, 2, 8 , 99, 22, 33};
        assertEquals(9, LongestIncreasingSubSequence.solution(input));
    }
}
