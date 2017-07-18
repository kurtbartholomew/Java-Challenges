package arrays_and_strings;

import org.junit.Test;
import static org.junit.Assert.*;

public class StringRotationCheckerTest {

    @Test
    public void shouldReturnTrueIfRotatedString() {
        assertTrue(StringRotationChecker.isRotatedString("waterbottle","lewaterbott"));
    }

    @Test
    public void shouldReturnFalseIfNotRotatedString() {
        assertFalse(StringRotationChecker.isRotatedString("tacocat","raisins"));
    }
}
