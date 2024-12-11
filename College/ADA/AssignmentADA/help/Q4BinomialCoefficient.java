/*
* Write a program using single one dimensional array of minimum size
* to get binomial coefficient nCk by using dynamic programming approach.
*/

package AssignmentADA.help;

import java.util.Scanner;

public class Q4BinomialCoefficient {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the value of n and k: ");
        int n = sc.nextInt();
        int k = sc.nextInt();
        sc.close();

        System.out.println("Binomial Coefficient of " + n + "C" + k + " is: " + binomialCoefficient(n, k));
    }

    public static int binomialCoefficient(int n, int k) {
        int[] C = new int[k + 1];
        C[0] = 1;

        for (int i = 1; i <= n; i++) {
            for (int j = Math.min(i, k); j > 0; j--) {
                C[j] = C[j] + C[j - 1];
            }
        }

        return C[k];
    }
}