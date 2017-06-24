package ng.clarence.solutions;

public class ZeroOneKnapsack {
    public static int solve(int[] values, int[] weights, int targetWeight) {
        int[][] sol = new int[targetWeight + 1][values.length];
        for (int i = 1; i <= targetWeight; i++) {
            for (int k = 0; k < values.length; k++) {
                if (k == 0 || i == 0) {
                    sol[i][k] = 0;
                    continue;
                }
                int solToUse = i - weights[k];
                if (solToUse < 0) {
                    sol[i][k] = sol[i][k - 1];
                    continue;
                }
                int newValue = Math.max(
                    values[k] + sol[i - weights[k]][k - 1],
                    sol[i][k - 1]);
                sol[i][k] = newValue;
            }
        }
        return sol[targetWeight][values.length - 1];
    }
}
