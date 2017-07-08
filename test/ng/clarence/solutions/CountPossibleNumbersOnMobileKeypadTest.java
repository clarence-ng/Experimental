package ng.clarence.solutions;

import org.junit.Test;

import static junit.framework.TestCase.assertEquals;

public class CountPossibleNumbersOnMobileKeypadTest {

    @Test
    public void test() {
        assertEquals(10, CountPossibleNumbersOnMobileKeypad.solve(1));
        assertEquals(36, CountPossibleNumbersOnMobileKeypad.solve(2));
        assertEquals(138, CountPossibleNumbersOnMobileKeypad.solve(3));
        assertEquals(532, CountPossibleNumbersOnMobileKeypad.solve(4));
        assertEquals(2062, CountPossibleNumbersOnMobileKeypad.solve(5));
    }
}
