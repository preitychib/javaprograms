import java.util.Scanner;
public class  MatrixChainMultiplication1{
    static void order(int[][]P,int i,int j){
        if(i==j){
            System.out.print("A" +j);
        }
        else{
            int k =P[i-1][j-i-1];
            System.out.print("(");
            order(P,i,k);
            order(P,k+1,j);
            System.out.print(")");
        }
    }
    static void chainMatrixOrder(int[]d,int n){
        int[][] M = new int[n][];
        int[][] P = new int[n-1][];

        //Initialize matrices M & P 
        for(int i =0;i<n;i++){
            M[i] = new int[n-1];
        }
        for(int i =0;i<n-1;i++){
            P[i]= new int[n-i-1];

        }
        //Base case:cost is zero when multiplyiong one matrix
        for(int i=0;i<n;i++){
            M[i][0]=0;

        }
        // Compute costs 
        for(int dg =1;dg<n;dg++){
            for(int i=0;i<n-dg;i++){
                int j=dg;
                M[i][j]=Integer.MAX_VALUE;
                for(int k=i;k<i+j;k++){
                    int cost=M[i][k-1]+M[k+1][i+j-k-1]+d[i]*d[k+1]*d[i+j+1];
                    if(cost<M[i][j]){
                        M[i][j]=cost;
                        P[i][j-1]=k+1;
                    }
                }
            }
        }
        // Display the P matrix
        System.out.println("Matrix P");
        for(int i=0;i<n-1;i++){
            for(int j=0;j<i;j++){
                System.out.print("\t");
            }
            for(int j=0;j<n-i-1;j++){
                System.out.print(P[i][j]+"\t");

            }
            System.out.println();
        }
         //Display optimal order
         System.out.print("\nOptimal Order:");
         order(P,1,n);
         System.out.println();
    }
    public static void main(String[] args){
        int n =5;
        int[] d ={5,9,8,3,4,2};
        chainMatrixOrder(d,n);
    }
}