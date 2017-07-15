package arrays_and_strings;

import org.junit.Test;
import static org.junit.Assert.*;

public class UniqueCharacterCheckerTest {
    @Test
    public void shouldReturnTrueForStringWithUniqueCharacters() {
        assertTrue(UniqueCharacterChecker.isUnique("orange"));
    }

    @Test
    public void shouldReturnFalseForStringWithDuplicateCharacters() {
        assertFalse(UniqueCharacterChecker.isUnique("stuff"));
    }
}
