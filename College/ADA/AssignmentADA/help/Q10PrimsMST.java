package AssignmentADA.help;
import java.util.*;

public class Q10PrimsMST {
    private static final int INF = Integer.MAX_VALUE;

    public static void findMinimumSpanningTree(int[][] W, int n) {
        List<Edge> F = new ArrayList<>();
        int[] nearest = new int[n + 1];
        int[] distance = new int[n + 1];
        
        // Initialize nearest and distance arrays
        for (int i = 2; i <= n; i++) {
            nearest[i] = 1;
            distance[i] = W[1][i];
        }
        
        // Main algorithm loop
        for (int k = 0; k < n - 1; k++) {
            int min = INF;
            int near = -1;
            
            // Find the vertex with minimum distance
            for (int i = 2; i <= n; i++) {
                if (distance[i] >= 0 && distance[i] < min) {
                    min = distance[i];
                    near = i;
                }
            }
            
            // Check if graph is disconnected
            if (near == -1) {
                System.out.println("Graph is disconnected!");
                break;
            }
            
            F.add(new Edge(nearest[near], near));
            distance[near] = -1;
            
            // Update distances of remaining vertices
            for (int i = 2; i <= n; i++) {
                if (W[i][near] != INF && W[i][near] < distance[i]) {
                    distance[i] = W[i][near];
                    nearest[i] = near;
                }
            }
        }
        
        // Print the minimum spanning tree edges
        System.out.println("\nEdges in the Minimum Spanning Tree:");
        for (Edge edge : F) {
            System.out.println(edge.from + " - " + edge.to);
        }
    }
    
    static class Edge {
        int from;
        int to;
        
        Edge(int from, int to) {
            this.from = from;
            this.to = to;
        }
    }
    
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        // Input number of vertices
        System.out.print("Enter the number of vertices: ");
        int n = sc.nextInt();
        
        int[][] W = new int[n + 1][n + 1];
        
        // Instructions for input
        System.out.println("\nEnter the adjacency matrix:");
        System.out.println("Use -1 or any negative number to represent infinity (no connection)");
        System.out.println("Use 0 for self-loops (diagonal elements)");
        System.out.println("For all other connections, enter the positive weight");
        
        // Input adjacency matrix
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= n; j++) {
                while (true) {
                    try {
                        System.out.printf("Enter weight for edge (%d,%d): ", i, j);
                        int weight = sc.nextInt();
                        
                        // Validate input
                        if (i == j && weight != 0) {
                            System.out.println("Diagonal elements must be 0. Please enter again.");
                            continue;
                        }
                        
                        // Convert negative numbers to INF
                        W[i][j] = (weight < 0) ? INF : weight;
                        break;
                        
                    } catch (InputMismatchException e) {
                        System.out.println("Please enter a valid integer!");
                        sc.nextLine(); // Clear the invalid input
                    }
                }
            }
        }
        
        // Print the input matrix for verification
        System.out.println("\nInput adjacency matrix:");
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= n; j++) {
                if (W[i][j] == INF) {
                    System.out.print("INF\t");
                } else {
                    System.out.print(W[i][j] + "\t");
                }
            }
            System.out.println();
        }
        
        // Find and print MST
        findMinimumSpanningTree(W, n);
        
        sc.close();
    }
}


 