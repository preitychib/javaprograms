// ? Tridiagonal my approach
import java.util.Scanner;

public class Tridiagonal {

    static int[] mapTridiagonal(int x,int y,int n) {
        int i=x;
        int j=y-Math.max(x-2+1,0);
        if(j<0||(y>=(Math.min(x+2,n))))
            return new int[]{-1,-1}; // not valid
        return new int[]{i,j};
    }

    static int[] mapPentadiagonal(int x,int y,int n) {
        int i=x;
        int j=y-Math.max(x-3+1,0);
        if(j<0||(y>=(Math.min(x+3,n))))
            return new int[]{-1,-1}; // not valid
        return new int[]{i,j};
    }

    static void mul(int[][] a,int[][] b,int[][] c,int n) {
        for(int i=0;i<n;i++) {
            for(int j=Math.max(0,i-2);j<=Math.min(i+2,n-1);j++) {
                int[] mapPenta=mapPentadiagonal(i,j,n);
                for(int k=Math.max(Math.max(i-1,j-1),0);k<=Math.min(Math.min(i+1,j+1),n-1);k++) {
                    int[] mapTriIK=mapTridiagonal(i,k,n);
                    int[] mapTriKJ=mapTridiagonal(k,j,n);
                    c[mapPenta[0]][mapPenta[1]]+=a[mapTriIK[0]][mapTriIK[1]]*b[mapTriKJ[0]][mapTriKJ[1]];
                }
            }
        }
    }

    static void printPentaDiagonal(int[][] c,int n) {
        System.out.println("\nThis is how it is stored in memory:");
        for(int[] i:c) {
            for(int a:i) {
                System.out.print(a+"\t");
            }
            System.out.println();
        }

        System.out.println("\nThe multiplication of given matrix is:");
        for(int i=0;i<n;i++) {
            for(int j=0;j<n;j++) {
                int[] mapPenta=mapPentadiagonal(i,j,n);
                if(mapPenta[0]==-1) System.out.print(0+"\t");
                else
                    System.out.print(c[mapPenta[0]][mapPenta[1]]+"\t");
            }
            System.out.println();
        }
    }

    static int[][] initializeTridiagonal(int n) {
        int[][] x;
        if(n<3) {
            x=new int[n][n];
            return x;
        }

        x=new int[n][];
        for(int i=0;i<n;i++) {
            int l=(i==0||i==n-1)?2:3;
            x[i]=new int[l];
        }
        return x;
    }

    static int[][] initializePentadiagonal(int n) {
        int[][] x;
        if(n<=3) {
            x=new int[n][n];
            return x;
        }

        x=new int[n][];
        for(int i=0;i<n;i++) {
            if(i==0||i==n-1) {
                x[i]=new int[Math.min(n,3)];
            } else if(i==1||i==n-2) {
                x[i]=new int[Math.min(n,4)];
            } else
                x[i]=new int[5];
        }
        return x;
    }

    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        System.out.println("Enter the value of n");
        int n=sc.nextInt();
        int[][] a=initializeTridiagonal(n);
        int[][] b=initializeTridiagonal(n);
        int[][] c=initializePentadiagonal(n);

        System.out.println("Enter the non-zero "+(3*n-2)+" elements of a");
        for(int i=0;i<n;i++) {
            int l=(i==0||i==n-1)?2:3;
            for(int j=0;j<l;j++) {
                a[i][j]=sc.nextInt();
            }
        }

        System.out.println("\nEnter the non zero "+(3*n-2)+" elements of b");
        for(int i=0;i<n;i++) {
            int l=(i==0||i==n-1)?2:3;
            for(int j=0;j<l;j++) {
                b[i][j]=sc.nextInt();
            }
        }

        mul(a,b,c,n);

        printPentaDiagonal(c,n);

        sc.close();
    }
}


// --pc