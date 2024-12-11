// ? Question 19
package AssignmentADA;

import java.util.Scanner;

public class MColoring {
    public static void m_coloring(int i,int n,int m,int[][] W,int[] vcolor) {
        if(isPromising(i,W,vcolor)) {
            if(i==n) {
                for(int j=1;j<=n;j++) {
                    System.out.print(vcolor[j]+" ");
                }
                System.out.println();
            } else {
                for(int color=1;color<=m;color++) {
                    vcolor[i+1]=color;
                    m_coloring(i+1,n,m,W,vcolor);
                }
            }
        }
    }

    public static boolean isPromising(int i,int[][] W,int[] vcolor) {
        int j=1;
        boolean promising=true;

        while(j<i &&promising) {
            if(W[i][j]==1 && vcolor[i]==vcolor[j]) {
                promising=false;
            }
            j++;
        }
        return promising;
    }

    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);

        System.out.print("Enter the number of vertices (n): ");
        int n=sc.nextInt();

        System.out.print("Enter the number of colors (m): ");
        int m=sc.nextInt();

        int[][] W=new int[n+1][n+1];
        for(int i=1;i<=n;i++) {
            for(int j=1;j<=n;j++) {
                W[i][j]=sc.nextInt();
            }
        }

        int[] vcolor=new int[n+1];
        m_coloring(0,n,m,W,vcolor);
        sc.close();
    }
}

