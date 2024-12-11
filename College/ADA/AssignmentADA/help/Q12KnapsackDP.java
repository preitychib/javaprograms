package AssignmentADA.help;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Q12KnapsackDP {
    public static void knapSack(int[] w, int[] p, int n, int W) {
        int[][] P = new int[n + 1][W + 1];
        int[][] keep = new int[n + 1][W + 1];

        // Initialize first row of profits to 0
        for (int wgt = 0; wgt <= W; wgt++) {
            P[0][wgt] = 0;
        }

        // Build table P[][] in bottom-up manner
        for (int i = 1; i <= n; i++) {
            for (int wgt = 0; wgt <= W; wgt++) {
                if (w[i - 1] <= wgt && (p[i - 1] + P[i - 1][wgt - w[i - 1]] > P[i - 1][wgt])) {
                    P[i][wgt] = p[i - 1] + P[i - 1][wgt - w[i - 1]];
                    keep[i][wgt] = 1;
                } else {
                    P[i][wgt] = P[i - 1][wgt];
                    keep[i][wgt] = 0;
                }
            }
        }

        // Backtracking to find the items included
        int K = W;
        List<Integer> items = new ArrayList<>();

        for (int i = n; i >= 1; i--) {
            if (keep[i][K] == 1) {
                items.add(i);
                K -= w[i - 1];
            }
        }

        // Printing the results
        System.out.println("Maximum Profit: " + P[n][W]);
        System.out.print("Items included (item numbers): ");
        for (int i = items.size() - 1; i >= 0; i--) {
            System.out.print(items.get(i) + " ");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Input number of items and capacity of knapsack
        System.out.print("Enter number of items (n): ");
        int n = scanner.nextInt();

        System.out.print("Enter capacity of knapsack (W): ");
        int W = scanner.nextInt();

        int[] w = new int[n]; // Weights
        int[] p = new int[n]; // Profits

        // Input weights and profits
        System.out.println("Enter weights of items:");
        for (int i = 0; i < n; i++) {
            System.out.print("Weight of item " + (i + 1) + ": ");
            w[i] = scanner.nextInt();
        }

        System.out.println("Enter profits of items:");
        for (int i = 0; i < n; i++) {
            System.out.print("Profit of item " + (i + 1) + ": ");
            p[i] = scanner.nextInt();
        }

        // Solve the knapsack problem
        knapSack(w, p, n, W);

        scanner.close();
    }
}
