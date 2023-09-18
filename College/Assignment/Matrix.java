//* Define a class Matrix which stores set of values in a two dimensional array. The dimension of the matrix is passed through contructors, and necessary memory allocation is done. The class contains a method, called populate(int range), which randomly generates numbers betwee I-range and store it as matrix values. Create a function to add, subtract, multiply two matrix. Also write a recursive function to find the determinant of a matirx. Also add required method in the class so that values of the Matrix can be printed using System.out.println() method. Also write a test program to test the above class.matrix class */ 

import java.util.Random;
import java.util.Scanner;

public class Matrix {
    int[][] mat;
    int m;
    int n;


    //* Constructor for user input */ 
    Matrix() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the dimension of the matrix:");
        m = sc.nextInt();
        n = sc.nextInt();
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
        Scanner s = new Scanner(System.in);
        int max; int min;
       //? Ensure that the upper bound is greater than or equal to the lower bound
        System.out.println("Enter the lower and upper bound:");
        min = s.nextInt();
        max = s.nextInt();
        
        Random random = new Random();
        for (int i = 0; i < mat.length; i++) 
        for (int j = 0; j < mat[0].length; j++)
        //? Generate random values in the specified range
        mat[i][j] = random.nextInt(max-min) + min;
        
    }
    
    //* @return Object matrix containing sum of two matrix */ 
    Matrix addMatrix(Matrix matObj2) {
        if (mat[0].length != matObj2.mat[0].length && mat.length != matObj2.mat.length) {
            throw new IllegalArgumentException("Matrix dimensions are not compatible for addition");
        }

        Matrix matObj3 = new Matrix(mat.length,mat[0].length);

        for (int i = 0; i < mat.length; i++) 
            for (int j = 0; j < mat[i].length; j++) 
                matObj3.mat[i][j] = mat[i][j] + matObj2.mat[i][j];
           
        return matObj3;
    }

    //* @return Object matrix containing difference of two matrix */ 
    Matrix subMatrix(Matrix matObj2) {
        if (mat[0].length != matObj2.mat[0].length && mat.length != matObj2.mat.length) {
            throw new IllegalArgumentException("Matrix dimensions are not compatible for subtraction");
        }

        Matrix matObj3 = new Matrix(mat.length, mat[0].length);

        for (int i = 0; i < mat.length; i++)
            for (int j = 0; j < mat[i].length; j++)
                matObj3.mat[i][j] = mat[i][j] - matObj2.mat[i][j];

        return matObj3;
    }
    
    //* @return Object matrix containing product of two matrix */ 
    Matrix mulMatrix(Matrix matObj2) {
        if (mat[0].length != matObj2.mat.length) {
            throw new IllegalArgumentException("Matrix dimensions are not compatible for multiplication");
        }
    
        Matrix matObj3 = new Matrix(mat.length, matObj2.mat[0].length);
    
        for (int i = 0; i < mat.length; i++) {
            for (int j = 0; j < matObj2.mat[0].length; j++) {
                matObj3.mat[i][j] = 0;
                for (int k = 0; k < mat[0].length; k++) {
                    matObj3.mat[i][j] += mat[i][k] * matObj2.mat[k][j];
                }
            }
        }
    
        return matObj3;
    }
    
    //* @return determinant of the matrix using recursion (Laplace expansion along the first row)*/ 
    int findDeterminant(int[][] matrix) {
        if (mat[0].length !=mat[0].length ) 
            throw new IllegalArgumentException("Enter a square matrix to find determinant.");

        int det = 0;
    
        int numRows = matrix.length;
        int numCols = matrix[0].length;
    
        if (numRows == 1 && numCols == 1) {
            return matrix[0][0];
        }
    
        int sign = 1;
    
        for (int i = 0; i < numRows; i++) {
            int[][] minor = new int[numRows - 1][numCols - 1];
    
            for (int j = 1; j < numRows; j++) {
                for (int k = 0, l = 0; k < numCols; k++) {
                    if (k != i) {
                        minor[j - 1][l++] = matrix[j][k];
                    }
                }
            }
    
            det += sign * matrix[0][i] * findDeterminant(minor);
            sign *= -1;
        }
    
        return det;
    }
    
    //* @Override the toString method for better performance using StringBuilder */ 
    public String toString()
    {
        //? For better performance we are using stringBuilder instead of String class
        StringBuilder matSb=new StringBuilder();
        for (int i = 0; i < mat.length; i++) {
            for (int j = 0; j < mat[i].length; j++) 
                matSb.append(mat[i][j] + " ");
            
            matSb.append("\n");
        }
        return matSb.toString();
    }
    
}