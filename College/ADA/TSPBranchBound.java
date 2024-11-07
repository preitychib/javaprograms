import java.util.*;

class Node implements Comparable<Node> {
    int level;           // Current level in the state space tree
    List<Integer> path;  // The current path taken
    double bound;        // Bound of the node

    public Node(int level, List<Integer> path, double bound) {
        this.level = level;
        this.path = new ArrayList<>(path);
        this.bound = bound;
    }

    // Compare based on the bound (lower bound has higher priority)
    @Override
    public int compareTo(Node other) {
        return Double.compare(this.bound, other.bound);
    }
}

public class TSPBranchBound {
    private int[][] W;   // Adjacency matrix representing distances
    private int n;       // Number of vertices

    // Constructor
    public TSPBranchBound(int[][] W, int n) {
        this.W = W;
        this.n = n;
    }

    // Calculate the bound for a given node
    private double bound(Node u) {
        double bound = 0;
        boolean[] visited = new boolean[n + 1];
        for (int i : u.path) visited[i] = true;

        // Add edge costs of the partial path
        for (int i = 0; i < u.path.size() - 1; i++) {
            bound += W[u.path.get(i) - 1][u.path.get(i + 1) - 1];
        }

        // Calculate the bound by adding minimum possible edge weights
        for (int i = 1; i <= n; i++) {
            if (!visited[i]) {
                int minCost = Integer.MAX_VALUE;
                for (int j = 1; j <= n; j++) {
                    if (!visited[j] && i != j && W[i - 1][j - 1] < minCost) {
                        minCost = W[i - 1][j - 1];
                    }
                }
                bound += minCost;
            }
        }
        return bound;
    }

    // Calculate the length of a given path
    private double pathLength(Node u) {
        double length = 0;
        for (int i = 0; i < u.path.size() - 1; i++) {
            length += W[u.path.get(i) - 1][u.path.get(i + 1) - 1];
        }
        return length;
    }

    // Branch and Bound algorithm for the Traveling Salesman Problem
    public void travelSalesPerson_Best() {
        PriorityQueue<Node> PQ = new PriorityQueue<>();
        Node v = new Node(0, Collections.singletonList(1), 0);
        v.bound = bound(v);
        PQ.add(v);

        double minLength = Double.MAX_VALUE;
        List<Integer> outTour = new ArrayList<>();

        while (!PQ.isEmpty()) {
            v = PQ.poll();  // Get the node with the best bound

            if (v.bound >= minLength) continue;

            // Explore the next level
            if (v.level == n - 1) continue; // Stop if we've reached the last level

            for (int i = 2; i <= n; i++) {
                if (!v.path.contains(i)) {  // Only consider unvisited vertices
                    Node u = new Node(v.level + 1, new ArrayList<>(v.path), 0);
                    u.path.add(i);  // Add the next vertex to the path

                    if (u.level == n - 2) {  // If we're at the second to last level
                        // Add the remaining unvisited vertex
                        for (int j = 2; j <= n; j++) {
                            if (!u.path.contains(j)) {
                                u.path.add(j);
                                break;
                            }
                        }
                        u.path.add(1);  // Return to the starting vertex

                        // Calculate the length of the path
                        double length = pathLength(u);
                        if (length < minLength) {
                            minLength = length;
                            outTour = new ArrayList<>(u.path);
                        }
                    } else {
                        u.bound = bound(u);  // Calculate the bound for node u
                        if (u.bound < minLength) {
                            PQ.add(u);  // Add node u to the priority queue if promising
                        }
                    }
                }
            }
        }

        System.out.println("Minimum length: " + minLength);
        System.out.println("Optimal tour: " + outTour);
    }

    public static void main(String[] args) {
        int[][] W = {
            {0, 14, 4, 10,20},
            {14, 0, 7, 8, 7},
            {4, 5, 0, 7, 16},
            {11, 7, 9, 0, 2},
            {18, 7, 17, 4, 0},
        };
        int n = 5;

        TSPBranchBound solver = new TSPBranchBound(W, n);
        solver.travelSalesPerson_Best();
    }
}
