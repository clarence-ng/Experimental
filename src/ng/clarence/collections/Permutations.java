package ng.clarence.collections;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Permutations {

    public static void permuteCharactersOfString(String prefix, String s, LinkedList<String> answer) {
        if (s.length() == 0) {
            answer.add(prefix.toString());
        }
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            permuteCharactersOfString(prefix + c, s.substring(0, i) + s.substring(i + 1, s.length()), answer);
        }
    }

    public static void printPermutationAtNumber(int size, int number) {
        int[] input = new int[size];
        for (int i = 0; i < input.length; i++) {
            input[i] = i;
        }
        printIntegerPermutationsInternal(new int[0], input, Solution.printPermutationAtNumber(number));
    }

    public static void printIntegerPermutations(int size) {
        int[] input = new int[size];
        for (int i = 0; i < input.length; i++) {
            input[i] = i;
        }
        Solution solution = Solution.printAll();
        printIntegerPermutationsInternal(new int[0], input, solution);
        Logger.getGlobal().log(Level.FINEST, Integer.toString(solution.permutationsSeen));
    }

    private static void printIntegerPermutationsInternal(int[] fixed, int[] remaining, Solution solution) {
        if (remaining.length == 0) {
            solution.permutationsSeen++;
            if (solution.printStrategy == PrintStrategy.All) {
                Logger.getGlobal().log(Level.FINEST, Arrays.toString(fixed));
            } else if (solution.printStrategy == PrintStrategy.PermutationAtNumber) {
                if (solution.permutationsSeen == solution.permutationToPrint) {
                    Logger.getGlobal().log(Level.FINEST, Arrays.toString(fixed));
                }
            }
            return;
        }
        for (int i = 0; i < remaining.length; i++) {
            int[] fixedCopy= Arrays.copyOf(fixed, fixed.length + 1);
            fixedCopy[fixedCopy.length - 1] = remaining[i];
            int remainingCopyIndex = 0;
            int[] remainingCopy = new int[remaining.length - 1];
            for (int k = 0; k < remaining.length; k++) {
                if (k != i) {
                    remainingCopy[remainingCopyIndex++] = remaining[k];
                }
            }
            printIntegerPermutationsInternal(fixedCopy, remainingCopy, solution);
        }
    }

    enum PrintStrategy {
        All,
        PermutationAtNumber
    }

    static class Solution {
        private final PrintStrategy printStrategy;
        private final int permutationToPrint;
        private int permutationsSeen;

        static Solution printAll() {
            return new Solution(PrintStrategy.All, -1);
        }

        static Solution printPermutationAtNumber(int number) {
            return new Solution(PrintStrategy.PermutationAtNumber, number);
        }

        private Solution(PrintStrategy printStrategy, int permutationToPrint) {
            this.printStrategy = printStrategy;
            this.permutationToPrint = permutationToPrint;
        }
    }

}
