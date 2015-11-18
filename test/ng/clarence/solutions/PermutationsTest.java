package ng.clarence.solutions;

import org.junit.Test;

import java.util.LinkedList;

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
}
