import java.util.*;

public class KnapsackDP {
    public static int[] knapsack(int[] w, int[] p, int n, int W) {
        int[][] P = new int[n + 1][W + 1];
        boolean[][] keep = new boolean[n+1][W+1];

        for (int i = 1; i <= n; i++) {
            for (int j = 0; j <= W; j++) {
                if (w[i - 1] <= j && (p[i - 1] + P[i - 1][j - w[i - 1]] > P[i - 1][j])) {
                    P[i][j] = p[i - 1] + P[i - 1][j - w[i - 1]];
                    keep[i][j] = true;
                } else {
                    P[i][j] = P[i - 1][j];
                    keep[i][j] = false;
                }
            }
        }

        int k = W;
        int[] A = new int[n];
        for (int i = n; i >= 1; i--) {
            if (keep[i][k] == true) {
                A[i - 1] = 1;
                k = k - w[i - 1];
            } else {
                A[i - 1] = 0;
            }
        }
        return A;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter the number of items: ");
        int n = scanner.nextInt();
        System.out.print("Enter the capacity of the knapsack: ");
        int W = scanner.nextInt();

        int[] w = new int[n];
        int[] p = new int[n];

        System.out.println("Enter the weights and profits of the items:");
        for (int i = 0; i < n; i++) {
            System.out.print("Weight " + (i + 1) + ": ");
            w[i] = scanner.nextInt();
            System.out.print("Profit " + (i + 1) + ": ");
            p[i] = scanner.nextInt();
        }
        

        int[] result = knapsack(w, p, n, W);
        System.out.print("The solution is: ");
        for (int i = 0; i < n; i++) {
            System.out.print(result[i] + " ");
        }
        System.out.println();

        scanner.close();
    }
}