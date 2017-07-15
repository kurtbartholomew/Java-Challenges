package arrays_and_strings;

import org.junit.Test;
import static org.junit.Assert.*;

public class UrlifierTest {

    @Test
    public void shouldReturnSameStringIfNoSpaces() {
        assertEquals("fancy", Urlifier.toURL("fancy", 5));
    }

    @Test
    public void shouldReturnUrlifiedString() {
        assertEquals("the%man%was%cool", Urlifier.toURL("the man was cool", 16));
    }
}
