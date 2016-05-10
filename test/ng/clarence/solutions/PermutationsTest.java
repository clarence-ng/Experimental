package ng.clarence.solutions;

import ng.clarence.collections.Permutations;
import ng.clarence.utils.LoggerUtils;
import org.junit.Test;

import java.util.LinkedList;
import java.util.logging.Level;
import java.util.logging.Logger;

import static junit.framework.TestCase.assertTrue;
import static ng.clarence.collections.Permutations.permuteCharactersOfString;

public class PermutationsTest {

    @Test
    public void sanity() {
        LinkedList<String> solution = new LinkedList<>();
        permuteCharactersOfString("", "abc", solution);
        assertTrue(solution.contains("abc"));
        assertTrue(solution.contains("acb"));
        assertTrue(solution.contains("bac"));
        assertTrue(solution.contains("bca"));
        assertTrue(solution.contains("cab"));
        assertTrue(solution.contains("cba"));
    }

    @Test
    public void printIntegerPermutations() {
        LoggerUtils.configureLoggerForStdOut(Logger.getGlobal(), Level.FINEST);
        Permutations.printIntegerPermutations(5);
        Permutations.printPermutationAtNumber(5, 118);
    }
}
