import java.util.*;

public class KnapsackBestFirstBacktrack {
    
    static class Node {
        int level;
        int profit;
        int weight;
        double bound;
        boolean[] include;  // Track items included in this node
        
        Node() {
            include = new boolean[100];  // Assuming max 100 items
        }
        
        // Copy constructor for creating node copies with include tracking
        Node(Node other) {
            this.level = other.level;
            this.profit = other.profit;
            this.weight = other.weight;
            this.bound = other.bound;
            this.include = Arrays.copyOf(other.include, other.include.length);
        }
    }

    static int maxProfit = 0;
    static boolean[] bestSet;
    static int numItems;
    
    /**
     * Calculate the bound of a node for branch and bound
     * 
     * @param u Current node
     * @param W Knapsack capacity
     * @param w Array of item weights
     * @param p Array of item profits
     * @return Calculated bound value
     */
    static double getBound(Node u, int W, int[] w, int[] p) {
        // If weight exceeds capacity, return 0
        if (u.weight >= W) {
            return 0;
        }
        
        double bound = u.profit;
        int j = u.level + 1;
        int totWeight = u.weight;

        // Add full items while possible
        while (j < numItems && totWeight + w[j] <= W) {
            totWeight += w[j];
            bound += p[j];
            j++;
        }

        // If remaining space, add fractional item
        if (j < numItems) {
            bound += (double)(W - totWeight) * p[j] / w[j];
        }

        return bound;
    }

    /**
     * Knapsack Best-First Branch and Bound algorithm
     * 
     * @param W Knapsack capacity
     * @param w Array of item weights
     * @param p Array of item profits
     */
    static void knapsackBestFirstBacktrack(int W, int[] w, int[] p) {
        // Track all profitable paths
        List<Node> profitablePaths = new ArrayList<>();
        
        // Priority queue to explore nodes with highest bound first
        PriorityQueue<Node> pq = new PriorityQueue<>((n1, n2) -> 
            Double.compare(n2.bound, n1.bound)
        );

        // Initialize root node
        Node root = new Node();
        root.level = -1;
        root.profit = 0;
        root.weight = 0;
        root.bound = getBound(root, W, w, p);
        
        pq.offer(root);

        // Track max profit node
        Node maxProfitNode = null;

        // Process nodes in priority queue
        while (!pq.isEmpty()) {
            Node v = pq.poll();

            // If bound is promising, explore further
            if (v.bound > maxProfit) {
                // Node including current item
                Node includeNode = new Node(v);
                includeNode.level = v.level + 1;
                includeNode.weight = v.weight + w[includeNode.level];
                includeNode.profit = v.profit + p[includeNode.level];
                includeNode.include[includeNode.level] = true;

                // Update bound
                includeNode.bound = getBound(includeNode, W, w, p);

                // If weight is valid and profit is higher
                if (includeNode.weight <= W && includeNode.profit > maxProfit) {
                    maxProfit = includeNode.profit;
                    maxProfitNode = includeNode;
                    profitablePaths.add(includeNode);
                }

                // Add to queue if bound is promising
                if (includeNode.bound > maxProfit) {
                    pq.offer(includeNode);
                }

                // Node excluding current item
                Node excludeNode = new Node(v);
                excludeNode.level = v.level + 1;
                excludeNode.bound = getBound(excludeNode, W, p, w);

                // Add to queue if bound is promising
                if (excludeNode.bound > maxProfit) {
                    pq.offer(excludeNode);
                }
            }
        }

        // Display profitable paths
        System.out.println("\n--- Profitable Paths ---");
        for (Node path : profitablePaths) {
            System.out.println("Path Details:");
            System.out.println("Profit: " + path.profit);
            System.out.println("Weight: " + path.weight);
            System.out.print("Items Included: ");
            for (int i = 0; i < numItems; i++) {
                if (path.include[i]) {
                    System.out.print((i+1) + " ");
                }
            }
            System.out.println("\n");
        }

        // Display max profit solution
        if (maxProfitNode != null) {
            System.out.println("Maximum Profit Solution:");
            System.out.println("Total Profit: " + maxProfit);
            System.out.print("Items Included: ");
            for (int i = 0; i < numItems; i++) {
                if (maxProfitNode.include[i]) {
                    System.out.print((i+1) + " ");
                }
            }
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // Input: Number of items
        System.out.println("Enter the number of items:");
        numItems = sc.nextInt();

        // Input: Knapsack capacity
        System.out.println("Enter the capacity of knapsack:");
        int capacity = sc.nextInt();

        // Input: Profits
        int[] profits = new int[numItems];
        System.out.println("Enter the profits of items:");
        for (int i = 0; i < numItems; i++) {
            profits[i] = sc.nextInt();
        }

        // Input: Weights
        int[] weights = new int[numItems];
        System.out.println("Enter the weights of items:");
        for (int i = 0; i < numItems; i++) {
            weights[i] = sc.nextInt();
        }

        // Reset max profit before algorithm
        maxProfit = 0;

        // Run the knapsack algorithm
        knapsackBestFirstBacktrack(capacity, weights, profits);
    }
}