package arrays_and_strings;

import org.junit.Test;
import static org.junit.Assert.*;

public class PalindromePermutationCheckerTest {
    @Test
    public void shouldReturnTrueForPalindromes() {
        assertTrue(PalindromePermutationChecker.checkIfPalindrome("taco cat"));
    }

    @Test
    public void shouldReturnFalseForNonPalindromes() {
        assertFalse(PalindromePermutationChecker.checkIfPalindrome("taco car"));
    }
}
