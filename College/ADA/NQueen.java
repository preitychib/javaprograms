import java.util.Scanner;

public class NQueen {
    static int[] col;
     static int n;
 
     public static void main(String[] args) {
         Scanner sc = new Scanner(System.in);
         System.out.println("enter the value of n");
         n = sc.nextInt();
        col = new int[n + 1];
        queens(0);
        sc.close();
     }
 
    static void queens(int i) {
        if(isPromising(i)) {
            if(i==n) {
              printSolution();
         } else {
               for (int j = 1; j<=n; j++) {
                   col[i + 1] = j;
                  queens(i+1);
                }
           }
        }
    }
 
     static boolean isPromising(int i) {
        int k = 1;
         boolean promising = true;
 
        while(k<i && promising) {
             if(col[i]==col[k] || Math.abs(col[i] - col[k]) == (i - k)) {
                 promising = false;
            }
            k++;
        }
         return promising;
     }
 
   static void printSolution() {
         for(int i = 1; i<=n; i++) {
          for(int j=1; j<=n; j++) {
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
 