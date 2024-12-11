import java.util.*;

public class ChainedMatrix5 {
    public static  int multiply(int[]arr, int n){
        int[][]mat= new int[n+1][n+1];
        int[][]p= new int[n][n+1];

        for(int d=1;d<n;d++){
            for(int i=1;i<=n-d;i++){
                int j= i+d;

                mat[i][j]= mat[i][i]+mat[i+1][j]+arr[i-1]*arr[i]*arr[j];
                p[i][j]=i;

                for(int k=i+1;k<=j-1;k++){
                    int val=mat[i][k]+mat[k+1][j]+arr[i-1]*arr[k]*arr[j];
                    if(val<mat[i][j]){
                        mat[i][j]=val;
                        p[i][j]=k;
                    }
                }
            }
            
        }
        System.out.println();
        path(1,n,p);
        System.out.println();
        return mat[1][n];
    }

    public static void path(int i, int j, int[][]p){
        if(i==j){
            System.out.print("A"+i);
            return;
        }
        int k=p[i][j];
        System.out.print("(");
        path(i,k,p);
        path(k+1,j,p);
        System.out.print(")");



    }
    public static void main(String[] args) {
        int n;
        Scanner sc= new Scanner(System.in);
        System.out.print("Enter the number of matrices: ");

        n=sc.nextInt();
        System.out.println();
        int[]d= new int[n+1];
        System.out.println("enter the elements of arrary: ");
        for(int i=0;i<=n;i++){
            d[i]=sc.nextInt();
        }

        System.out.println("Number of minimum multiplications rrequired are: "+multiply(d,n));

    }
    
}
