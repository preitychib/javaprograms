//* Define a class Matrix which stores set of values in a two dimensional array. The dimension of the matrix is passed through contructors, and necessary memory allocation is done. The class contains a method, called populate(int range), which randomly generates numbers betwee I-range and store it as matrix values. Create a function to add, subtract, multiply two matrix. Also write a recursive function to find the determinant of a matirx. Also add required method in the class so that values of the Matrix can be printed using System.out.println() method. Also write a test program to test the above class.matrix class */ 

import java.util.Random;
import java.util.Scanner;

public class Matrix {
    int[][] mat;
    int m;
    int n;


    //* Constructor for user input */ 
    Matrix() {
        try (Scanner sc = new Scanner(System.in)) {
            System.out.println("Enter the dimension of the matrix:");
            m = sc.nextInt();
            n = sc.nextInt();
        }
        mat = new int[m][n];
        
    }
    
    //* Constructor for method calls */ 
    Matrix(int x, int y) {
        m = x;
        n = y;
        mat = new int[m][n];
    }
    
    //* Populate random values in the matrix */ 
    void populate()
    {
        try (Scanner s = new Scanner(System.in)) {
            int max; int min;
      //? Ensure that the upper bound is greater than or equal to the lower bound
            System.out.println("Enter the lower and upper bound:");
            min = s.nextInt();
            max = s.nextInt();
            
            Random random = new Random();
            for (int i = 0; i < m; i++) 
            for (int j = 0; j < n; j++)
            //? Generate random values in the specified range
            mat[i][j] = random.nextInt(max-min) + min;
        }
        
    }
    
    //* @return Object matrix containing sum of two matrix */ 
    Matrix addMatrix(Matrix matObj2) {
        if (m != matObj2.m && n!= matObj2.n) {
            System.out.println("Matrix dimensions are not compatible for addition");
            return null;
        }

        Matrix matObj3 = new Matrix(m,n);

        for (int i = 0; i < m; i++) 
            for (int j = 0; j < n; j++) 
                matObj3.mat[i][j] = mat[i][j] + matObj2.mat[i][j];
           
        return matObj3;
    }

    //* @return Object matrix containing difference of two matrix */ 
    Matrix subMatrix(Matrix matObj2) {
         if (m != matObj2.m && n!= matObj2.n) {
             System.out.println("Matrix dimensions are not compatible for subtraction");
             return null;
        }

        Matrix matObj3 = new Matrix(m,n);

        for (int i = 0; i < m; i++) 
            for (int j = 0; j < n; j++) 
                matObj3.mat[i][j] = mat[i][j] - matObj2.mat[i][j];

        return matObj3;
    }
    
    //* @return Object matrix containing product of two matrix */ 
    Matrix mulMatrix(Matrix matObj2) {
        if (n != matObj2.m) {
            System.out.println("Matrix dimensions are not compatible for multiplication");
            return null;
        }
    
        Matrix matObj3 = new Matrix(m, matObj2.n);
    
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < matObj2.n; j++) {
                matObj3.mat[i][j] = 0;
                for (int k = 0; k < n; k++) {
                    matObj3.mat[i][j] += mat[i][k] * matObj2.mat[k][j];
                }
            }
        }
    
        return matObj3;
    }
    
    //* @return determinant of the the current object matrix */
    int matDeterminant() {
        if (m != n){
            System.out.println("Enter a square matrix to find determinant. Returning random value.");
            return -99999;
        }
        return findDeterminant(mat);

    }
    
    //* @return determinant of the matrix using recursion (Laplace expansion along the first row)*/ 
    int findDeterminant(int[][] matrix) {
        int matDimension = matrix.length;
        int determinant = 0;
        //? Base case: If the matrix is 1x1, return the single element as the determinant
        if (matDimension == 1)
            return matrix[0][0];
        //? Base case: If the matrix is 2x2, calculate the determinant using the formula
        else if (matDimension == 2)
            return (matrix[0][0] * matrix[1][1]) - (matrix[0][1] * matrix[1][0]);
    
        //? Initialize a sign variable to alternate between positive and negative signs
        int sign = 1;
        //? Loop through each element in the first row of the matrix
        for (int i = 0; i < matDimension; i++) {
            //? Create a minor matrix by removing the current row and column
            int[][] minor = new int[matDimension - 1][matDimension - 1];
    
            //? Populate the minor matrix by excluding the current row and column
            for (int j = 1; j < matDimension; j++) 
                for (int k = 0, l = 0; k < matDimension; k++) 
                    if (k != i) {
                        minor[j - 1][l++] = matrix[j][k];
                    }

            //? Recursively calculate the determinant of the minor matrix and accumulate it
            determinant += sign * matrix[0][i] * findDeterminant(minor);
    
            //? Flip the sign for the next iteration (to alternate between positive and negative)
            sign *= -1;
        }
    
        // Return the final determinant of the original matrix
        return determinant;
    }
    
    
    //* @Override the toString method for better performance using StringBuilder */ 
    public String toString()
    {
       StringBuilder matSb=new StringBuilder();
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) 
                matSb.append(mat[i][j] + " ");
            
            matSb.append("\n");
        }
        return matSb.toString();
    }
    
}