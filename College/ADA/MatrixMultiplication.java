
import java.util.Random;

public class MatrixMultiplication {

    // Direct method for matrix multiplication
    public static int[][] directMultiply(int[][] A, int[][] B) {
        int n = A.length;
        int[][] C = new int[n][n];
        
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                for (int k = 0; k < n; k++) {
                    C[i][j] += A[i][k] * B[k][j];
                }
            }
        }
        
        return C;
    }

    // Divide and Conquer method for matrix multiplication
    public static int[][] divideAndConquerMultiply(int[][] A, int[][] B) {
        int n = A.length;
        int[][] C = new int[n][n];
        
        if (n == 1) {
            C[0][0] = A[0][0] * B[0][0];
        } else {
            int[][] A11 = new int[n/2][n/2];
            int[][] A12 = new int[n/2][n/2];
            int[][] A21 = new int[n/2][n/2];
            int[][] A22 = new int[n/2][n/2];
            int[][] B11 = new int[n/2][n/2];
            int[][] B12 = new int[n/2][n/2];
            int[][] B21 = new int[n/2][n/2];
            int[][] B22 = new int[n/2][n/2];
            
            // Divide matrices into submatrices
            divideMatrix(A, A11, A12, A21, A22);
            divideMatrix(B, B11, B12, B21, B22);
            
            // Recursive calls for submatrix multiplications
            int[][] C11 = addMatrices(divideAndConquerMultiply(A11, B11), divideAndConquerMultiply(A12, B21));
            int[][] C12 = addMatrices(divideAndConquerMultiply(A11, B12), divideAndConquerMultiply(A12, B22));
            int[][] C21 = addMatrices(divideAndConquerMultiply(A21, B11), divideAndConquerMultiply(A22, B21));
            int[][] C22 = addMatrices(divideAndConquerMultiply(A21, B12), divideAndConquerMultiply(A22, B22));
            
            // Combine submatrices into result matrix
            combineMatrix(C, C11, C12, C21, C22);
        }
        
        return C;
    }

    // Strassen's algorithm for matrix multiplication
    public static int[][] strassenMultiply(int[][] A, int[][] B) {
        int n = A.length;
        int[][] C = new int[n][n];
        
        if (n == 1) {
            C[0][0] = A[0][0] * B[0][0];
        } else {
            int[][] A11 = new int[n/2][n/2];
            int[][] A12 = new int[n/2][n/2];
            int[][] A21 = new int[n/2][n/2];
            int[][] A22 = new int[n/2][n/2];
            int[][] B11 = new int[n/2][n/2];
            int[][] B12 = new int[n/2][n/2];
            int[][] B21 = new int[n/2][n/2];
            int[][] B22 = new int[n/2][n/2];
            
            // Divide matrices into submatrices
            divideMatrix(A, A11, A12, A21, A22);
            divideMatrix(B, B11, B12, B21, B22);
            
            // Compute 7 products using Strassen's formulas
            int[][] P1 = strassenMultiply(addMatrices(A11, A22), addMatrices(B11, B22));
            int[][] P2 = strassenMultiply(addMatrices(A21, A22), B11);
            int[][] P3 = strassenMultiply(A11, subtractMatrices(B12, B22));
            int[][] P4 = strassenMultiply(A22, subtractMatrices(B21, B11));
            int[][] P5 = strassenMultiply(addMatrices(A11, A12), B22);
            int[][] P6 = strassenMultiply(subtractMatrices(A21, A11), addMatrices(B11, B12));
            int[][] P7 = strassenMultiply(subtractMatrices(A12, A22), addMatrices(B21, B22));
            
            // Compute submatrices of C
            int[][] C11 = addMatrices(subtractMatrices(addMatrices(P1, P4), P5), P7);
            int[][] C12 = addMatrices(P3, P5);
            int[][] C21 = addMatrices(P2, P4);
            int[][] C22 = addMatrices(subtractMatrices(addMatrices(P1, P3), P2), P6);
            
            // Combine submatrices into result matrix
            combineMatrix(C, C11, C12, C21, C22);
        }
        
        return C;
    }

    // Helper method to divide a matrix into four submatrices
    private static void divideMatrix(int[][] M, int[][] M11, int[][] M12, int[][] M21, int[][] M22) {
        int n = M.length / 2;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                M11[i][j] = M[i][j];
                M12[i][j] = M[i][j + n];
                M21[i][j] = M[i + n][j];
                M22[i][j] = M[i + n][j + n];
            }
        }
    }

    // Helper method to combine four submatrices into a single matrix
    private static void combineMatrix(int[][] M, int[][] M11, int[][] M12, int[][] M21, int[][] M22) {
        int n = M11.length;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                M[i][j] = M11[i][j];
                M[i][j + n] = M12[i][j];
                M[i + n][j] = M21[i][j];
                M[i + n][j + n] = M22[i][j];
            }
        }
    }
    
    private static int[][] addMatrices(int[][] A, int[][] B) {
        int n = A.length;
        int[][] C = new int[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                C[i][j] = A[i][j] + B[i][j];
            }
        }
        return C;
    }

    private static int[][] subtractMatrices(int[][] A, int[][] B) {
        int n = A.length;
        int[][] C = new int[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                C[i][j] = A[i][j] - B[i][j];
            }
        }
        return C;
    }

    public static void printMatrix(int[][] matrix) {
        int n = matrix.length;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                System.out.print(matrix[i][j] + " ");
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        int[] sizes = {5, 6, 7, 8, 9};
        Random rand = new Random();

        for (int k : sizes) {
            int n = (int) Math.pow(2, k);
            System.out.println("Matrix size: " + n + "x" + n);

            int[][] A = generateRandomMatrix(n);
            int[][] B = generateRandomMatrix(n);

            long startTime = System.nanoTime();
            int[][] C1 = MatrixMultiplication.directMultiply(A, B);
            long endTime = System.nanoTime();
            long directTime = endTime - startTime;
            System.out.println("Direct method time: " + directTime / 1e6 + " ms");

            startTime = System.nanoTime();
            int[][] C2 = MatrixMultiplication.divideAndConquerMultiply(A, B);
            endTime = System.nanoTime();
            long divideConquerTime = endTime - startTime;
            System.out.println("Divide and Conquer method time: " + divideConquerTime / 1e6 + " ms");

            startTime = System.nanoTime();
            int[][] C3 = MatrixMultiplication.strassenMultiply(A, B);
            endTime = System.nanoTime();
            long strassenTime = endTime - startTime;
            System.out.println("Strassen's method time: " + strassenTime / 1e6 + " ms");
            if (areMatricesEqual(C1, C2) && areMatricesEqual(C1, C3)) {
                System.out.println("All methods produced the same result.");
            } else {
                System.out.println("Warning: Results differ between methods!");
            }

            System.out.println();
        }
    }

    private static int[][] generateRandomMatrix(int n) {
        Random rand = new Random();
        int[][] matrix = new int[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                matrix[i][j] = rand.nextInt(100);  
            }
        }
        return matrix;
    }

    private static boolean areMatricesEqual(int[][] A, int[][] B) {
        if (A.length != B.length || A[0].length != B[0].length) {
            return false;
        }
        for (int i = 0; i < A.length; i++) {
            for (int j = 0; j < A[0].length; j++) {
                if (A[i][j] != B[i][j]) {
                    return false;
                }
            }
        }
        return true;
    }
}
