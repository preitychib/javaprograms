import java.util.Random;
public class MatrixMultiplication{
    public static int[][] matrixMultiply(int[][] A,int[][] B){
        int n =A.length;
        int [][] C = new int[n][n];

        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){ 
                C[i][j] = 0;
                for(int k = 0;k<n;k++){
                        C[i][j] += A[i][k]*B[k][j];
                }
            }
        }
        return C;
    }






















    public static int[][] generateMatrix(int n){
        Random rand = new Random();
        int[][] matrix = new int[n][n];
        for(int i =0;i<n;i++){
            for(int j =0;j<n;j++){
                matrix[i][j] = rand.nextInt(10) ;
            }
        }
        return matrix;
    }
    public static void printMatrix(int[][] matrix){
        int n = matrix.length;
        for(int i = 0;i<n;i++){
            for(int j =0;j<n;j++){
                System.out.print(matrix[i][j] + " ");
            }
            System.out.println();
        }
    }
    public static void main(String[] args) {
        int k = 2;
        int n = (int) Math.pow(2,k); // Order of the matrix, 2^k

        int[][] A = generateMatrix(n);
        int[][] B = generateMatrix(n);
        
        // for(int i = 0;i<order;i++){
        //     for(int j = 0;j<order;j++){
        //         A[i][j] = rand.nextInt(9) + 1;
        //         B[i][j] = rand.nextInt(9) + 1;
        //     }
        // }
        System.out.println("Matrix A:");
        printMatrix(A);
        System.out.println("\nMatrix B:");
        printMatrix(B);

        int[][] C = matrixMultiply(A,B);
        System.out.println("\nProduct of A and B:");
        printMatrix(C);
    }
}



        