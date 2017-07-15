package arrays_and_strings;

import org.junit.Test;
import static org.junit.Assert.*;

public class BasicStringCompressorTest {
    @Test
    public void shouldReturnOriginalString() {
        assertEquals(BasicStringCompressor.compressString("abcdefg"),"abcdefg");
    }

    @Test
    public void shouldReturnCompressedString() {
        assertEquals(BasicStringCompressor.compressString("aaaabbbccdeeeefg"),"a4b3c2d1e4f1g1");
    }
}
