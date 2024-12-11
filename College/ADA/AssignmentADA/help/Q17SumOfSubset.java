package AssignmentADA.help;

import java.util.Scanner;

public class Q17SumOfSubset {
    static int n;                  // Number of elements
    static int[] w;                // Array of weights
    static boolean[] include;      // Inclusion array for elements
    static int W;                  // Target sum
    static int totalWeight;        // Sum of all weights
    static int nodesVisited = 0;   // Optional: Count of nodes visited

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Input number of elements and target sum W
        System.out.print("Enter the number of elements (n): ");
        n = scanner.nextInt();

        w = new int[n + 1];        // 1-based indexing for weights
        include = new boolean[n + 1];

        // Input weights
        System.out.println("Enter the weights of the elements:");
        totalWeight = 0;
        for (int i = 1; i <= n; i++) {
            System.out.print("w[" + i + "] = ");
            w[i] = scanner.nextInt();
            totalWeight += w[i];
        }

        // Input target sum W
        System.out.print("Enter the target sum (W): ");
        W = scanner.nextInt();

        System.out.println("\nSubsets that sum to " + W + ":");
        sumOfSubsets(0, 0, totalWeight);

        // Optional: Print number of nodes visited
        System.out.println("\nTotal nodes visited: " + nodesVisited);

        scanner.close();
    }

    // Recursive function to find and print all subsets that sum to W
    static void sumOfSubsets(int i, int weight, int total) {
        nodesVisited++;  // Optional: Increment nodes visited count

        if (isPromising(i, weight, total)) {
            if (weight == W) {
                // Found a valid subset, print it
                printSubset();
            } else if (i < n) {
                // Include the next element
                include[i + 1] = true;
                sumOfSubsets(i + 1, weight + w[i + 1], total - w[i + 1]);

                // Exclude the next element
                include[i + 1] = false;
                sumOfSubsets(i + 1, weight, total - w[i + 1]);
            }
        }
    }

    // Function to check if the node is promising
    static boolean isPromising(int i, int weight, int total) {
        return (weight + total >= W) && (weight == W || (i + 1 <= n && weight + w[i + 1] <= W));
    }

    // Function to print the current subset
    static void printSubset() {
        System.out.print("{ ");
        for (int i = 1; i <= n; i++) {
            if (include[i]) {
                System.out.print(w[i] + " ");
            }
        }
        System.out.println("}");
    }
}
