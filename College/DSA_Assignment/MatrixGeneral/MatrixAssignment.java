package MatrixGeneral;
// Implement Matrix using 2D array with the following methods:
// 1. void read() - insert elements in the matrix.
// 2. void print() - print the matrix.
// 3. Matrix add(Matrix B) - matrix addition. original matrix should not change.
// 4. Matrix mul(Matrix B) - matrix multiplication. original matrix should not change.
// 5. int det() - determinant of the matrix. original matrix should not change.
// 6. Matrix inverse() - inverse of the matrix. original matrix should not change.

import java.util.Scanner;

public class MatrixAssignment {
    double[][] mat;
    int row;
    int col;

    MatrixAssignment(int m, int n) {
        row = m;
        col = n;
        mat = new double[row][col];
    }
    
    public void read(Scanner sc) {
        System.out.println("Enter the matrix:");
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                mat[i][j] = sc.nextDouble();
            }
        }
    }
    
    public void print() {
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++)
                System.out.print(mat[i][j] + "\t");

            System.out.println();
        }
    }
    

    //* @return Object matrix containing sum of two matrix */ 
    MatrixAssignment addMatrix(MatrixAssignment matObj2) {
        if (row != matObj2.row && col != matObj2.col) {
            System.out.println("Matrix dimensions are not compatible for addition");
            return null;
        }

        MatrixAssignment matObj3 = new MatrixAssignment(row, col);

        for (int i = 0; i < row; i++)
            for (int j = 0; j < col; j++)
                matObj3.mat[i][j] = mat[i][j] + matObj2.mat[i][j];

        return matObj3;
    }
    
    //* @return Object matrix containing product of two matrix */ 
    MatrixAssignment mulMatrix(MatrixAssignment matObj2) {
        if (col != matObj2.row) {
            System.out.println("Matrix dimensions are not compatible for multiplication");
            return null;
        }

        MatrixAssignment matObj3 = new MatrixAssignment(row, matObj2.col);

        for (int i = 0; i < row; i++) {
            for (int j = 0; j < matObj2.col; j++) {
                matObj3.mat[i][j] = 0;
                for (int k = 0; k < col; k++) {
                    matObj3.mat[i][j] += mat[i][k] * matObj2.mat[k][j];
                }
            }
        }

        return matObj3;
    }
    

    double findDeterminant() {
        if (row != col) {
            System.out.println("Enter a square Matrix to calculate determinant");
            return Double.MIN_VALUE;
        }
    
        // Create a duplicate matrix
        double[][] dupMat = new double[row][col];
        for (int i = 0; i < row; i++) {
            System.arraycopy(mat[i], 0, dupMat[i], 0, col);
        }
    
        // Convert the duplicate matrix into upper triangular form
        for (int k = 0; k < row - 1; k++) {
            double y = dupMat[k][k];
            if (y == 0)
                continue;
    
            for (int i = k + 1; i < row; i++) {
                double x = dupMat[i][k];
    
                for (int j = 0; j < col; j++) {
                    dupMat[i][j] -= (x / y * dupMat[k][j]);
                }
            }
        }
    
        // Calculate the product of diagonal elements
        double det = 1.0;
        for (int i = 0; i < row; i++) {
            det *= dupMat[i][i];
        }
    
        return det;
    }
    

    double[][] inverse() throws Exception {
        if (findDeterminant() == 0 || findDeterminant() == Double.MIN_VALUE) {
            throw new Exception("Inverse of the given matrix doesn't exist");
        }
         // Create a duplicate matrix
         double[][] dupMat = new double[row][col];
         for (int i = 0; i < row; i++) {
             System.arraycopy(mat[i], 0, dupMat[i], 0, col);
        }
        double[][] inverseMat = new double[row][col];
        for (int i = 0; i < row; i++) {
            inverseMat[i][i] = 0;
        }
        
        // forward method
        for (int k = 0; k < row - 1; k++) {
            double y = dupMat[k][k];
            for (int i = k + 1; i < row; i++) {
                double x = dupMat[i][k];

                for (int j = 0; j < col; j++) {
                    dupMat[i][j] -= (x / y * dupMat[k][j]);
                    inverseMat[i][j] -= (x / y * inverseMat[k][j]);
                }
            }
        }

        // backward method
        for (int k = row - 1; k > 0; k--) {
            double y = dupMat[k][k];

            for (int i = k - 1; i >= 0; i--) {
                double x = dupMat[i][k];
                for (int j = row - 1; j >= 0; j--) {
                    dupMat[i][j] -= (x / y * dupMat[k][j]);
                    inverseMat[i][j] -= (x / y * inverseMat[k][j]);
                }
            }
        }

        for (int i = 0; i < row; i++) {
            inverseMat[i][i] /= dupMat[i][i];
        }

        return inverseMat;
    }
    
}


//     public class MatrixAssignment {
//     int[][] mat;
//     int m;
//     int n;


//     //* Constructor for user input */ 
//     MatrixAssignment() {
//         try (Scanner sc = new Scanner(System.in)) {
//             System.out.println("Enter the dimension of the matrix:");
//             m = sc.nextInt();
//             n = sc.nextInt();
//             mat = new int[m][n];
//         }
        
//     }
    
//     //* Constructor for method calls */ 
//     MatrixAssignment(int x, int y) {
//         m = x;
//         n = y;
//         mat = new int[m][n];
//     }
    
//     //* Populate random values in the matrix */ 
//     void populate()
//     {
//         try (Scanner s = new Scanner(System.in)) {
//             int max; int min;
//             //? Ensure that the upper bound is greater than or equal to the lower bound
//             System.out.println("Enter the lower and upper bound:");
//             min = s.nextInt();
//             max = s.nextInt();
            
//             Random random = new Random();
//             for (int i = 0; i < m; i++) 
//             for (int j = 0; j < n; j++)
//             //? Generate random values in the specified range
//             mat[i][j] = random.nextInt(max-min) + min;
//         }
        
//     }
    
//     //* @return Object matrix containing sum of two matrix */ 
//     MatrixAssignment addMatrix(MatrixAssignment matObj2) {
//         if (m != matObj2.m && n!= matObj2.n) {
//             System.out.println("Matrix dimensions are not compatible for addition");
//             return null;
//         }

//         MatrixAssignment matObj3 = new MatrixAssignment(m,n);

//         for (int i = 0; i < m; i++) 
//             for (int j = 0; j < n; j++) 
//                 matObj3.mat[i][j] = mat[i][j] + matObj2.mat[i][j];
           
//         return matObj3;
//     }

//     //* @return Object matrix containing difference of two matrix */ 
//     MatrixAssignment subMatrix(MatrixAssignment matObj2) {
//          if (m != matObj2.m && n!= matObj2.n) {
//              System.out.println("Matrix dimensions are not compatible for subtraction");
//              return null;
//         }

//         MatrixAssignment matObj3 = new MatrixAssignment(m,n);

//         for (int i = 0; i < m; i++) 
//             for (int j = 0; j < n; j++) 
//                 matObj3.mat[i][j] = mat[i][j] - matObj2.mat[i][j];

//         return matObj3;
//     }
    
//     //* @return Object matrix containing product of two matrix */ 
//     MatrixAssignment mulMatrix(MatrixAssignment matObj2) {
//         if (n != matObj2.m) {
//             System.out.println("Matrix dimensions are not compatible for multiplication");
//             return null;
//         }
    
//         MatrixAssignment matObj3 = new MatrixAssignment(m, matObj2.n);
    
//         for (int i = 0; i < m; i++) {
//             for (int j = 0; j < matObj2.n; j++) {
//                 matObj3.mat[i][j] = 0;
//                 for (int k = 0; k < n; k++) {
//                     matObj3.mat[i][j] += mat[i][k] * matObj2.mat[k][j];
//                 }
//             }
//         }
    
//         return matObj3;
//     }
    
//     //* @return determinant of the the current object matrix */
//     int matDeterminant() {
//         if (m != n){
//             System.out.println("Enter a square matrix to find determinant. Returning random value.");
//             return Integer.MIN_VALUE;
//         }
//         return findDeterminant(mat);

//     }
    
//     //* @return determinant of the matrix using recursion (Laplace expansion along the first row)*/ 
//     int findDeterminant(int[][] matrix) {
//         int matDimension = matrix.length;
//         int determinant = 0;
//         //? Base case: If the matrix is 1x1, return the single element as the determinant
//         if (matDimension == 1)
//             return matrix[0][0];
//         //? Base case: If the matrix is 2x2, calculate the determinant using the formula
//         else if (matDimension == 2)
//             return (matrix[0][0] * matrix[1][1]) - (matrix[0][1] * matrix[1][0]);
    
//         //? Initialize a sign variable to alternate between positive and negative signs
//         int sign = 1;
//         //? Loop through each element in the first row of the matrix
//         for (int i = 0; i < matDimension; i++) {
//             //? Create a minor matrix by removing the current row and column
//             int[][] minor = new int[matDimension - 1][matDimension - 1];
    
//             //? Populate the minor matrix by excluding the current row and column
//             for (int j = 1; j < matDimension; j++) 
//                 for (int k = 0, l = 0; k < matDimension; k++) 
//                     if (k != i) {
//                         minor[j - 1][l++] = matrix[j][k];
//                     }

//             //? Recursively calculate the determinant of the minor matrix and accumulate it
//             determinant += sign * matrix[0][i] * findDeterminant(minor);
    
//             //? Flip the sign for the next iteration (to alternate between positive and negative)
//             sign *= -1;
//         }
    
//         // Return the final determinant of the original matrix
//         return determinant;
//     }
    
//     void toUpperDiagonal(int[][] matrix) {
//         int m = matrix[0].length;
//         int n = matrix.length;
//         for (int k = 0; k < m-1; k++) {
//             int y = matrix[k][k];

//             for (int i = k + 1; i < m; i++) {
//                 int x = matrix[i][k];

//                 for (int j = 0; j < n; j++) {
//                     matrix[i][j] -= (x / y * matrix[k][j]);
//                 }
//             }
//         }
//     }
    
//     void toLowerDiagonal(int[][] matrix) {
//         int m = matrix[0].length;
//         int n = matrix.length;

//         for (int i = 1; i < n; i++) {
//             int x = matrix[i][i];
//             for (int j = i - 1; j >= 0; j--) {
//                 int y = matrix[j][i];
                
//                 for (int k = 0; k < m; k++) {
//                     matrix[k][j] -= (x / y * matrix[k][i]);
//                 }
//             }
//         }

//     }

//     int findDeterminant() {
//         MatrixAssignment upperDiagonal = new MatrixAssignment(m, n);
        
//         int[]
//         for (int i = 0; i < m; i++) {
//             for (int j = 0; j < n; j++)
//                 upperDiagonal.mat[i][j] = mat[i][j];
//         }
        
//         int m = matrix[0].length;
//         int n = matrix.length;
//         for (int k = 0; k < m-1; k++) {
//             int y = matrix[k][k];

//             for (int i = k + 1; i < m; i++) {
//                 int x = matrix[i][k];

//                 for (int j = 0; j < n; j++) {
//                     matrix[i][j] -= (x / y * matrix[k][j]);
//                 }
//             }
//         }
//         int determinant = 1;
//         for (int i = 0; i < m; i++)
//             determinant *= upperDiagonal.mat[i][i];

//         return determinant;
//     }

//     //* @Override the toString method for better performance using StringBuilder */ 
//     public String toString()
//     {
//        StringBuilder matSb=new StringBuilder();
//         for (int i = 0; i < m; i++) {
//             for (int j = 0; j < n; j++) 
//                 matSb.append(mat[i][j] + " ");
            
//             matSb.append("\n");
//         }
//         return matSb.toString();
//     }
    
// }