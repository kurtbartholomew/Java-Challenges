package arrays_and_strings;

import org.junit.Test;
import static org.junit.Assert.*;

public class OneEditAwayTest {

    @Test
    public void shouldReturnTrueIfOneEditAway() {
        assertTrue(OneEditAway.isOneEditAway("cat","crat"));
    }

    @Test
    public void shouldReturnFalseIfMoreThanOneEditAway() {
        assertFalse(OneEditAway.isOneEditAway("cat","cattt"));
    }
}
