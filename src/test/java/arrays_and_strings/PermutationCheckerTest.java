package arrays_and_strings;

import org.junit.Test;
import static org.junit.Assert.*;

public class PermutationCheckerTest {

    @Test
    public void shouldReturnFalseIfDifferentLength() {
        assertFalse(PermutationChecker.isFirstPermutationOfSecond("tacoman", "mantacoo"));
    }

    @Test
    public void shouldReturnTrueForAnagram() {
        assertTrue(PermutationChecker.isFirstPermutationOfSecond("tacoman", "mantaco"));
    }

    @Test
    public void shouldReturnFalseIfNotAnagram() {
        assertFalse(PermutationChecker.isFirstPermutationOfSecond("stuff", "things"));
    }
}
