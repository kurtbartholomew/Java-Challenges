package trees_and_graphs;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class MinimalBSTBuilderTest {

    private int[] sortedOddLengthArray;
    private int[] sortedEvenLengthArray;

    private static boolean validateBST(MinimalBSTBuilder.Node head) {
        return validateBSTHelper(head, Integer.MIN_VALUE, Integer.MAX_VALUE);
    }

    private static boolean validateBSTHelper(MinimalBSTBuilder.Node current, int min, int max) {
        if(current == null) { return true; }
        if(current.data <= min || current.data >= max) { return false; }
        return validateBSTHelper(current.left, min, current.data)
                && validateBSTHelper(current.right, current.data, max);
    }

    @Before
    public void setUp() {
        sortedOddLengthArray = new int[]{1,2,3,4,5,6,7,8,9};
        sortedEvenLengthArray = new int[]{1,2,3,4,5,6,7,8,9,10};
    }

    @Test
    public void shouldReturnAValidBSTFromOddLengthArray() {
        assertTrue(validateBST(MinimalBSTBuilder.buildBST(sortedOddLengthArray)));
    }

    @Test
    public void shouldReturnAValidBSTFromEvenLengthArray() {
        assertTrue(validateBST(MinimalBSTBuilder.buildBST(sortedEvenLengthArray)));
    }
}