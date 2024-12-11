import java.util.Random;
import java.util.*;

public class Strassen {
    

    static int[][] generateRandomMatrix(int n) {
        Random rand = new Random();
        int[][] matrix = new int[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                matrix[i][j] = rand.nextInt(100);  
            }
        }
        return matrix;
    }

    static int[][] addMatrices(int[][] A, int[][] B) {
        int n = A.length;
        int[][] C = new int[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                C[i][j] = A[i][j] + B[i][j];
            }
        }
        return C;
    }

    static int[][] subtractMatrices(int[][] A, int[][] B) {
        int n = A.length;
        int[][] C = new int[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                C[i][j] = A[i][j] - B[i][j];
            }
        }
        return C;
    }

    static void printMatrix(int[][] matrix) {
        int n = matrix.length;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                System.out.print(matrix[i][j] + " ");
            }
            System.out.println();
        }
    }

    static void divideMatrix(int[][] M, int[][] M11, int[][] M12, int[][] M21, int[][] M22) {
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
    static void combineMatrix(int[][] M, int[][] M11, int[][] M12, int[][] M21, int[][] M22) {
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
    
    public static int[][] strassenMultiply(int[][] A, int[][] B) {
        int n = A.length;
        int[][] C = new int[n][n];
        
        if (n == 1) {
            C[0][0] = A[0][0] * B[0][0];
        } 
        else {
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

    public static void main(String[] args) {
        int n;
        Scanner sc= new Scanner(System.in);
        System.out.println("Enter the order of matrix: ");
        n=sc.nextInt();

        int[][]mat1= new int[n][n];
        mat1= generateRandomMatrix(n);
        System.out.println("Matrix1 is: ");
        printMatrix(mat1);

        int[][]mat2= new int[n][n];
        mat2= generateRandomMatrix(n);
        System.out.println();
        printMatrix(mat2);

        System.out.println("\n\nPrining the multiplication: ");
        printMatrix(strassenMultiply(mat1, mat2));

    }
}
