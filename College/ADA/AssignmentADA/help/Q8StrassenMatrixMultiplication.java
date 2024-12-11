package AssignmentADA.help;

public class Q8StrassenMatrixMultiplication {
    public static int[][] strassenMultiply(int[][] A, int[][] B) {
        int n = A.length;
        
        // Base case: 1x1 matrix
        if (n == 1) {
            int[][] C = new int[1][1];
            C[0][0] = A[0][0] * B[0][0];
            return C;
        }
        
        // Pad matrices if n is not a power of 2
        int originalN = n;
        if (n % 2 != 0) {
            // Find next power of 2
            int newSize = nextPowerOfTwo(n);
            A = padMatrix(A, newSize);
            B = padMatrix(B, newSize);
            n = newSize;
        }
        
        // Split matrices into quadrants
        int[][] A11 = new int[n/2][n/2];
        int[][] A12 = new int[n/2][n/2];
        int[][] A21 = new int[n/2][n/2];
        int[][] A22 = new int[n/2][n/2];
        int[][] B11 = new int[n/2][n/2];
        int[][] B12 = new int[n/2][n/2];
        int[][] B21 = new int[n/2][n/2];
        int[][] B22 = new int[n/2][n/2];
        
        splitMatrix(A, A11, A12, A21, A22);
        splitMatrix(B, B11, B12, B21, B22);
        
        // Calculate the 7 products recursively using Strassen's formulas
        int[][] P1 = strassenMultiply(addMatrices(A11, A22), addMatrices(B11, B22));
        int[][] P2 = strassenMultiply(addMatrices(A21, A22), B11);
        int[][] P3 = strassenMultiply(A11, subtractMatrices(B12, B22));
        int[][] P4 = strassenMultiply(A22, subtractMatrices(B21, B11));
        int[][] P5 = strassenMultiply(addMatrices(A11, A12), B22);
        int[][] P6 = strassenMultiply(subtractMatrices(A21, A11), addMatrices(B11, B12));
        int[][] P7 = strassenMultiply(subtractMatrices(A12, A22), addMatrices(B21, B22));
        
        // Calculate the quadrants of the result
        int[][] C11 = subtractMatrices(addMatrices(addMatrices(P1, P4), P7), P5);
        int[][] C12 = addMatrices(P3, P5);
        int[][] C21 = addMatrices(P2, P4);
        int[][] C22 = subtractMatrices(addMatrices(addMatrices(P1, P3), P6), P2);
        
        // Combine the quadrants into the result matrix
        int[][] C = combineMatrices(C11, C12, C21, C22);
        
        // If we padded the matrices, we need to remove the padding
        if (originalN != n) {
            C = unpadMatrix(C, originalN);
        }
        
        return C;
    }
    
    // Helper method for conventional matrix multiplication (for verification)
    public static int[][] conventionalMultiply(int[][] A, int[][] B) {
        int n = A.length;
        int[][] C = new int[n][n];
        
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                C[i][j] = 0;
                for (int k = 0; k < n; k++) {
                    C[i][j] += A[i][k] * B[k][j];
                }
            }
        }
        return C;
    }
    
    private static int nextPowerOfTwo(int n) {
        int power = 1;
        while (power < n) {
            power *= 2;
        }
        return power;
    }
    
    private static int[][] padMatrix(int[][] matrix, int newSize) {
        int[][] newMatrix = new int[newSize][newSize];
        int n = matrix.length;
        
        for (int i = 0; i < newSize; i++) {
            for (int j = 0; j < newSize; j++) {
                if (i < n && j < n) {
                    newMatrix[i][j] = matrix[i][j];
                } else {
                    newMatrix[i][j] = 0;
                }
            }
        }
        return newMatrix;
    }
    
    private static int[][] unpadMatrix(int[][] matrix, int originalSize) {
        int[][] result = new int[originalSize][originalSize];
        for (int i = 0; i < originalSize; i++) {
            for (int j = 0; j < originalSize; j++) {
                result[i][j] = matrix[i][j];
            }
        }
        return result;
    }
    
    private static void splitMatrix(int[][] P, int[][] C11, int[][] C12, int[][] C21, int[][] C22) {
        int n = P.length/2;
        
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                C11[i][j] = P[i][j];
                C12[i][j] = P[i][j + n];
                C21[i][j] = P[i + n][j];
                C22[i][j] = P[i + n][j + n];
            }
        }
    }
    
    private static int[][] combineMatrices(int[][] C11, int[][] C12, int[][] C21, int[][] C22) {
        int n = C11.length;
        int[][] C = new int[2*n][2*n];
        
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                C[i][j] = C11[i][j];
                C[i][j + n] = C12[i][j];
                C[i + n][j] = C21[i][j];
                C[i + n][j + n] = C22[i][j];
            }
        }
        return C;
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
    
    private static void printMatrix(int[][] matrix) {
        for (int[] row : matrix) {
            for (int num : row) {
                System.out.print(num + " ");
            }
            System.out.println();
        }
    }
    
    public static void main(String[] args) {
        // Test matrices
        int[][] A = {
            {1, 2, 3, 4},
            {5, 6, 7, 8},
            {9, 10, 11, 12},
            {13, 14, 15, 16}
        };
        
        int[][] B = {
            {17, 18, 19, 20},
            {21, 22, 23, 24},
            {25, 26, 27, 28},
            {29, 30, 31, 32}
        };
        
        System.out.println("Matrix A:");
        printMatrix(A);
        
        System.out.println("\nMatrix B:");
        printMatrix(B);
        
        System.out.println("\nStrassen's Matrix Multiplication Result:");
        int[][] strassenResult = strassenMultiply(A, B);
        printMatrix(strassenResult);
        
        System.out.println("\nConventional Matrix Multiplication Result:");
        int[][] conventionalResult = conventionalMultiply(A, B);
        printMatrix(conventionalResult);
        
        // Verify the results are the same
        boolean isEqual = true;
        for (int i = 0; i < A.length; i++) {
            for (int j = 0; j < A.length; j++) {
                if (strassenResult[i][j] != conventionalResult[i][j]) {
                    isEqual = false;
                    break;
                }
            }
        }
        
        System.out.println("\nResults match: " + isEqual);
    }
}