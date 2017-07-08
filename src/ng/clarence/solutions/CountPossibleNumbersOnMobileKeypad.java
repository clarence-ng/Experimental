package ng.clarence.solutions;

import java.util.Arrays;
import java.util.List;
import java.util.stream.IntStream;

/*
 * Given the mobile numeric keypad. You can only press buttons that are up, left, right or down to
 * the current button. You are not allowed to press bottom row corner buttons (i.e. * and # ). Given
 * a number N, find out the number of possible numbers of given length.
 */
public class CountPossibleNumbersOnMobileKeypad {

    private static final int N = 10;
    private static final List<Integer>[] adjacentKeys = new List[N];
    static {
        adjacentKeys[0] = Arrays.asList(0, 1, 3);
        adjacentKeys[1] = Arrays.asList(0, 1, 2, 4);
        adjacentKeys[2] = Arrays.asList(1, 2, 5);
        adjacentKeys[3] = Arrays.asList(0, 3, 4, 6);
        adjacentKeys[4] = Arrays.asList(1, 3, 4, 5, 7);
        adjacentKeys[5] = Arrays.asList(2, 4, 5, 8);
        adjacentKeys[6] = Arrays.asList(3, 6, 7);
        adjacentKeys[7] = Arrays.asList(4, 6, 7, 8, 9);
        adjacentKeys[8] = Arrays.asList(5, 7, 8);
        adjacentKeys[9] = Arrays.asList(7, 9);
    }

    public static int solve(int length) {
        if (length <= 0) throw new IllegalArgumentException();
        int[] previousSolution = new int[N];
        int[] currentSolution = new int[N];
        Arrays.fill(currentSolution, 1);
        for (int n = 1; n < length; n++) {
            int[] tmp = previousSolution;
            previousSolution = currentSolution;
            currentSolution = tmp;
            Arrays.fill(currentSolution, 0);
            for (int key = 0; key < N; key++) {
                for (int adj : adjacentKeys[key]) {
                    currentSolution[key] += previousSolution[adj];
                }
            }
        }
        return IntStream.of(currentSolution).sum();
    }
}
