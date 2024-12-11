//? Question 13

import java.util.Arrays;
import java.util.Scanner;

public class NQueen {

    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        System.out.println("enter the value of n");
        int n=sc.nextInt();
        int[] col=new int[n+1];
        queens(0,n,col);
        sc.close();
    }

    public static void queens(int i, int n, int[] col) {
        System.out.println("ii"+i+" "+Arrays.toString(col));
        if(isPromising(i,col)) {
            if(i==n) {
                printSolution(n,col);
            } else {
                for(int j=1;j<=n;j++) {
                    col[i+1]=j;
                    queens(i+1,n,col);
                }
            }
        }
    }

    public static boolean isPromising(int i,int[] col) {
        int k=1;
        boolean promising=true;

        while(k<i&&promising) {
            if(col[i]==col[k]||Math.abs(col[i]-col[k])==(i-k)) {
                promising=false;
            }
            k++;
        }
        return promising;
    }

    public static void printSolution(int n,int[] col) {
        for(int i=1;i<=n;i++) {
            for(int j=1;j<=n;j++) {
                if(col[i]==j) {
                    System.out.print("Q ");
                } else {
                    System.out.print("X ");
                }
            }
            System.out.println();
        }
        System.out.println();
    }
}
