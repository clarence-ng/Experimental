package ng.clarence.solutions;

public class LongestIncreasingSubsequence {

    public static int solution(int[] input) {
        int[] lis = new int[input.length];
        for (int i = 0; i < input.length; i++) {
            int maxForI = 0;
            for (int j = 0; j < i; j++) {
                if (input[j] <= input[i]) {
                    if (maxForI < lis[j] + 1) {
                        maxForI = lis[j] + 1;
                    }
                } else {
                    if (maxForI <= lis[j]) {
                        maxForI = lis[j];
                    }
                }
            }
            lis[i] = maxForI;
        }
        return lis[input.length - 1];
    }
}
