package arrays_and_strings;

public class MatrixZeroer {
    public static int[][] zeroMatrix(int[][] matrix) {
        markRowsAndColumnsForZeroing(matrix);
        zeroRowsAndColumns(matrix);
        return matrix;
    }
    private static void markRowsAndColumnsForZeroing(int[][] matrix) {
        for(int row = 0; row < matrix.length; row++) {
            for(int col = 0; col < matrix[row].length; col++) {
                if(matrix[row][col] == 0) {
                    matrix[0][col] = 0;
                    matrix[row][0] = 0;
                }
            }
        }
    }
    private static void zeroRowsAndColumns(int[][] matrix) {

        boolean rowZeroed = false;
        boolean colZeroed = false;

        for(int num : matrix[0]) {
           if(num == 0){ rowZeroed = true; }
        }
        for(int row = 0; row < matrix.length; row++) {
            if(matrix[row][0] == 0) {
                colZeroed = true;
            }
        }

        for(int row = 1; row < matrix.length; row++) {
            if(matrix[row][0] == 0) {
                nullifyRow(matrix,row);
            }
        }
        for(int col = 1; col < matrix[0].length; col++) {
            if(matrix[0][col] == 0) {
                nullifyColumn(matrix,col);
            }
        }
        if(rowZeroed) { nullifyRow(matrix,0); }
        if(colZeroed) { nullifyColumn(matrix,0); }
    }
    private static void nullifyRow(int[][] matrix, int row) {
        for(int i = 1; i < matrix[row].length; i++) {
            matrix[row][i] = 0;
        }
    }
    private static void nullifyColumn(int[][] matrix, int col) {
        for(int i = 1; i < matrix.length; i++) {
            matrix[i][col] = 0;
        }
    }
}
