import java.util.Scanner;
public class TriDiagonalMatrix{


    // Method to read non-null elments of the tri diagonal matrix
    void readTDM(int a[][], int n){
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the non null elements of the tri diagonal matrix:");
        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                if(i == j || i == j-1 || i == j+1){
                    System.out.print("a[" + i + "][" + j + "]: ");
                    a[i][j] = sc.nextInt();
                }
            }
        }
    }

    //Method to print the tri diagonal matrix 
     void print(int a[][],int n){
        System.out.println("Tri diagonal matrix:");
        for (int i =0;i<n;i++){
            for(int j=0;j<n;j++){
                if(i==j || i==j-1||i==j+1){
                    System.out.print(a[i][j] + " ");

                }
                else{
                    System.out.print("0");
                }
            }
            System.out.println();
        }
    }
 // Method to multiply two diagonal matrix & return the resultant matrix 
    int[][] mul(int a[][],int b[][],int n){
        int[][] result = new int[n][n];
         for(int i =0;i<n;i++){
            for(int j =0;j<n;j++){
                result[i][j]=0;
                for(int k=0;k<n;k++){
                    if((i==k || i==k-1 || i==k+1) && (k==j || k==j-1 ||k==j+1)){
                        result[i][j] += a[i][k] * b[k][j];
                    }
                }
            }
        }
        return result;
    }

 // Method to print the resultant ,atrix 
    void printRes(int a[][],int n){
        System.out.println("Resultant matrix after multiplication:");
        for(int i =0;i<n;i++){
            for(int j=0;j<n;j++){
                System.out.print(a[i][j] + " ");
            }
            System.out.println();
        }
    }





    // Main Method
    public static void main(String[] args){
        TriDiagonalMatrix matrix = new TriDiagonalMatrix();
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter the size of the matrix(n*n):");
        int n = sc.nextInt();
        int[][] a = new int[n][n];
        int[][] b = new int[n][n];
        
        matrix.readTDM(a,n);
        matrix.print(a,n);
        matrix.readTDM(b,n);
        matrix.print(b,n);
        
        int[][] result = matrix.mul(a,b,n);
        matrix.printRes(result,n);
    }
}

         
         
    