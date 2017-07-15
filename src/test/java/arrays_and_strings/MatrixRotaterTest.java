package arrays_and_strings;

import org.junit.Before;
import org.junit.Test;

import java.util.Arrays;

import static org.junit.Assert.*;

public class MatrixRotaterTest {

    private int[][] matrix;
    private int[][] targetMatrix;

    @Before
    public void allocateMatrix() {
        this.matrix = new int[][]{
            {0,1,2,3,4},
            {5,6,7,8,9},
            {10,11,12,13,14},
            {15,16,17,18,19},
            {20,21,22,23,24}
        };
        this.targetMatrix = new int[][]{
            {20,15,10,5,0},
            {21,16,11,6,1},
            {22,17,12,7,2},
            {23,18,13,8,3},
            {24,19,14,9,4},
        };
    }

    @Test
    public void shouldReturnSameMatrix() {
        assertTrue(MatrixRotater.rotateMatrixClockwise(matrix) == matrix);
    }

    @Test
    public void shouldReturnRotatedMatrix() {
        assertArrayEquals(targetMatrix,MatrixRotater.rotateMatrixClockwise(matrix));
    }

}
