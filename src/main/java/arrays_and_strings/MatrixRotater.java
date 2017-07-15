package arrays_and_strings;

public class MatrixRotater {
    public static int[][] rotateMatrixClockwise(int[][] matrix) {
        transposeMatrix(matrix);
        reverseMatrix(matrix);
        return matrix;
    }
    private static void transposeMatrix(int[][] matrix) {
       for(int i = 0; i < matrix.length; i++) {
           for(int j = i+1; j < matrix[i].length; j++) {
               swap(matrix,i,j,j,i);
           }
       }
    }
    private static void reverseMatrix(int[][] matrix) {
        for(int i = 0; i < matrix.length; i++) {
            int mid = matrix[i].length / 2;
            for(int j = matrix[i].length-1; j > mid; j--) {
                swap(matrix,i,j,i,matrix[i].length-1-j);
            }
        }
    }
    private static void swap(int[][] matrix, int a, int b, int c, int d) {
        int temp = matrix[a][b];
        matrix[a][b] = matrix[c][d];
        matrix[c][d] = temp;
    }
}
