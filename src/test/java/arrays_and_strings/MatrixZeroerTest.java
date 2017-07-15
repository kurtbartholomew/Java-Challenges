package arrays_and_strings;

import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

public class MatrixZeroerTest {

    private int[][] matrix;
    private int[][] targetMatrix;

    @Before
    public void allocateMatrix() {
        this.matrix = new int[][]{
                {0,3,7,4,2},
                {3,2,4,0,8},
                {6,9,5,2,1},
                {2,8,8,0,2},
                {7,5,3,2,1}
        };
        this.targetMatrix = new int[][]{
                {0,0,0,0,0},
                {0,0,0,0,0},
                {0,9,5,0,1},
                {0,0,0,0,0},
                {0,5,3,0,1}
        };
    }

    @Test
    public void shouldReturnSameMatrix() {
        assertTrue(MatrixZeroer.zeroMatrix(matrix) == matrix);
    }

    @Test
    public void shouldReturnProperlyZeroedMatrix() {
        assertArrayEquals(MatrixZeroer.zeroMatrix(matrix),targetMatrix);
    }

}
