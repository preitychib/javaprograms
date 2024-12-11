//? Question 17
package AssignmentADA;

import java.util.Scanner;
import java.util.Arrays;

public class SumOfSubset {
    public static void sumOfSubsets(int i,int weight,int total,int W,int[] w,boolean[] include,int n) {
        if(isPromising(i,weight,total,W,w,n)) {
            if(weight==W) {
                printInclude(include,w,n);
            } else {
                include[i]=true;
                sumOfSubsets(i+1,weight+w[i],total-w[i],W,w,include,n);
                include[i]=false;
                sumOfSubsets(i+1,weight,total-w[i],W,w,include,n);
            }
        }
    }

    public static boolean isPromising(int i,int weight,int total,int W,int[] w,int n) {
        if(weight>W) return false;
        if(weight==W) return true;
        if(i==n) return false;
        return (weight+w[i]<=W)||isPromising(i+1,weight,total-w[i],W,w,n);
    }

    public static void printInclude(boolean[] include,int[] w,int n) {
        for(int i=0;i<n;i++) {
            if(include[i]) {
                System.out.print(w[i]+" ");
            }
        }
        System.out.println();
    }

    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);

        System.out.print("Enter the number of items: ");
        int n=scanner.nextInt();

        int[] w=new int[n];
        boolean[] include=new boolean[n];

        System.out.println("Enter the weights of the items:");
        for(int i=0;i<n;i++) {
            w[i]=scanner.nextInt();
        }

        System.out.print("Enter the target sum: ");
        int W=scanner.nextInt();

        sumOfSubsets(0,0,Arrays.stream(w).sum(),W,w,include,n);
        scanner.close();
    }
}

