import java.util.PriorityQueue;
import java.util.Scanner;

public class O1KnapsackBestFirstSearch {
    
    static class Node {
        int level;
        int profit;
        int weight;
        double bound;
    }

    // Knapsack Best-First Search Algorithm
    static void knapsack(int n, int[] p, int[] w, int W) {
        // PriorityQueue to store nodes, sorted by their bound
        PriorityQueue<Node> PQ = new PriorityQueue<>((n1, n2) -> {
            if (n2.bound < n1.bound) {
                return -1;
            } else if (n2.bound == n1.bound) {
                return 0;
            } else {
                return 1;
            }
        });

        // Initialize the root node with level -1, profit 0, weight 0
        Node v = new Node();
        v.level = -1;
        v.profit = 0;
        v.weight = 0;
        v.bound = getBound(v, W, n, w, p);

        // Add the root node to the priority queue
        PQ.offer(v);

        int maxProfit = 0;

        // Process the nodes in the priority queue
        while (!PQ.isEmpty()) {
            v = PQ.poll();  // Get the node with the highest bound

            // If the bound is greater than the current max profit, explore further
            if (v.bound > maxProfit) {
                Node u = new Node();
                u.level = v.level + 1;
                u.weight = v.weight + w[u.level];
                u.profit = v.profit + p[u.level];
                System.out.println("current level(i) = " + u.level + ", current profit = " + u.profit + ", current weight = " + u.weight + ", bound = " + getBound(u, W, n, w, p));

                // If including the current item doesn't exceed the weight limit
                if (u.weight <= W && u.profit > maxProfit) {
                    maxProfit = u.profit;  // Update max profit
                }

                // Calculate the bound for the current node
                u.bound = getBound(u, W, n, w, p);

                // If the bound is greater than the current max profit, add to the queue
                if (u.bound > maxProfit) {
                    PQ.offer(u);
                }

                // Explore the node where we don't include the current item
                u.weight = v.weight;
                u.profit = v.profit;
                u.bound = getBound(u, W, n, w, p);

                // If the bound is greater than the current max profit, add to the queue
                if (u.bound > maxProfit) {
                    PQ.offer(u);
                }
            }
        }
    }

    // Calculate the bound of a node
    static double getBound(Node u, int W, int n, int[] w, int[] p) {
        // If the weight exceeds the capacity, return 0 (not valid)
        if (u.weight >= W) {
            return 0;
        } else {
            double bound = u.profit;
            int j = u.level + 1;
            int totWeight = u.weight;

            // Add items to the knapsack as long as the weight doesn't exceed the capacity
            while (j < n && totWeight + w[j] <= W) {
                totWeight += w[j];
                bound += p[j];
                j++;
            }

            // If there are remaining items that cannot fit entirely, use a fractional part
            int k = j;
            if (k < n) {
                bound += (double) (W - totWeight) * p[k] / w[k];
            }

            return bound;
        }
    }

    // Main method to execute the program
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // Input: Number of items
        System.out.println("Enter the number of items:");
        int n = sc.nextInt();

        // Input: Capacity of the knapsack
        System.out.println("Enter the capacity of knapsack:");
        int W = sc.nextInt();

        // Input: Profit of items
        int[] p = new int[n];
        System.out.println("Enter the profit of " + n + " items:");
        for (int i = 0; i < n; i++) {
            p[i] = sc.nextInt();
        }

        // Input: Weight of items
        int[] w = new int[n];
        System.out.println("Enter the weight of " + n + " items:");
        for (int i = 0; i < n; i++) {
            w[i] = sc.nextInt();
        }

        // Call the knapsack algorithm
        knapsack(n, p, w, W);
    }
}