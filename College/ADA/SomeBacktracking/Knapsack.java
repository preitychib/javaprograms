package SomeBacktracking;

import java.util.Scanner;

public class Knapsack {
    private int[] p; // profits
    private int[] w; // weights
    private int W; // knapsack capacity
    private int maxProfit;
    private int[] bestSet;
    private int numbest;

    public Knapsack() {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter the number of items: ");
        int n = scanner.nextInt();

        this.p = new int[n];
        this.w = new int[n];
        this.bestSet = new int[n];

        System.out.println("Enter the profits and weights of the items:");
        for (int i = 0; i < n; i++) {
            System.out.print("Profit of item " + (i + 1) + ": ");
            this.p[i] = scanner.nextInt();
            System.out.print("Weight of item " + (i + 1) + ": ");
            this.w[i] = scanner.nextInt();
        }

        System.out.print("Enter the knapsack capacity: ");
        this.W = scanner.nextInt();
    }

    public void knapsack(int i, int profit, int weight) {
        if (weight <= W && profit > maxProfit) {
            maxProfit = profit;
            numbest = i;
            for (int j = 0; j < i; j++) {
                bestSet[j] = (this.bestSet[j] == 1) ? 1 : 0;
            }
            bestSet[i] = 1;
        }
        if (isPromising(i)) {
            bestSet[i] = 1;
            knapsack(i + 1, profit + p[i], weight + w[i]);
            bestSet[i] = 0;
            knapsack(i + 1, profit, weight);
        }
    }

    private boolean isPromising(int i) {
        if (w[i] > W) {
            return false;
        } else {
            int j = i + 1;
            int bound = 0;
            int totalWeight = 0;
            while (j <= p.length - 1 && totalWeight + w[j] <= W) {
                totalWeight += w[j];
                bound += p[j];
                j++;
            }
            if (j <= p.length - 1) {
                bound += (W - totalWeight) * p[j] / w[j];
            }
            return bound > maxProfit;
        }
    }

    public static void main(String[] args) {
        Knapsack knapsack = new Knapsack();
        knapsack.knapsack(0, 0, 0);
        System.out.println("Maximum Profit: " + knapsack.maxProfit);
        System.out.println("Best Set: ");
        for (int i = 0; i < knapsack.bestSet.length; i++) {
            if (knapsack.bestSet[i] == 1) {
                System.out.println("Item " + (i + 1) + " is included.");
            }
        }
    }
}