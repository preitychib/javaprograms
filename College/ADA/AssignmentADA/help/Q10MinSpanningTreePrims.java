package AssignmentADA.help;

// Write a program to get minimum spanning tree of a given graph using Prim's algorithm.

import java.util.Arrays;
import java.util.Scanner;

public class Q10MinSpanningTreePrims {

    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);

        System.out.println("Enter the number of vertices:");
        int V = s.nextInt();

        int[][] graph = new int[V][V];
        System.out.println("Enter the adjacency matrix of the graph:");
        for (int i = 0; i < V; i++) {
            for (int j = 0; j < V; j++) {
                graph[i][j] = s.nextInt();
            }
        }

        primMST(graph, V);
    }

    static void primMST(int[][] graph, int V) {
        int[] parent = new int[V];  // To store the MST
        int[] key = new int[V];     // Key values used to pick the minimum weight edge
        boolean[] inMST = new boolean[V]; // To represent set of vertices in MST

        // Initialize all keys as INFINITE
        Arrays.fill(key, Integer.MAX_VALUE);
        Arrays.fill(inMST, false);

        // Start with the first vertex
        key[0] = 0;
        parent[0] = -1; // First node is the root of MST

        for (int count = 0; count < V - 1; count++) {
            // Pick the minimum key vertex from the set of vertices not yet included in MST
            int u = minKey(key, inMST, V);

            // Add the picked vertex to the MST Set
            inMST[u] = true;

            // Update key value and parent index of the adjacent vertices of the picked vertex
            for (int v = 0; v < V; v++) {
                // graph[u][v] is non-zero for adjacent vertices
                // inMST[v] is false for vertices not yet included in MST
                // Update the key only if graph[u][v] is smaller than key[v]
                if (graph[u][v] != 0 && !inMST[v] && graph[u][v] < key[v]) {
                    parent[v] = u;
                    key[v] = graph[u][v];
                }
            }
        }

        printMST(parent, graph, V);
    }

    // A utility function to find the vertex with the smallest key value
    private static int minKey(int[] key, boolean[] inMST, int V) {
        int min = Integer.MAX_VALUE, minIndex = -1;

        for (int v = 0; v < V; v++) {
            if (!inMST[v] && key[v] < min) {
                min = key[v];
                minIndex = v;
            }
        }
        return minIndex;
    }

    // A utility function to print the constructed MST stored in parent[]
    private static void printMST(int[] parent, int[][] graph, int V) {
        System.out.println("Edge \tWeight");
        int totalCost = 0;
        for (int i = 1; i < V; i++) {
            System.out.println(parent[i] + " - " + i + "\t" + graph[i][parent[i]]);
            totalCost += graph[i][parent[i]];
        }
        System.out.println("Total cost of the Minimum Spanning Tree: " + totalCost);
    }

    
}
