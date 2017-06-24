package ng.clarence.solutions;

import org.junit.Assert;
import org.junit.Test;

public class ZeroOneKnapsackTest {
    @Test
    public void test() {
        int[] values = {0, 2, 7, 5};
        int[] weights = {1, 1, 2, 3};
        Assert.assertEquals(ZeroOneKnapsack.solve(values, weights, 2), 7);
    }
}
