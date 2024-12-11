package AssignmentADA.help;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

public class Q6KruskalMST {

    // Disjoint Set Data Structure
    static int[] u; // Union-Find array for Disjoint Sets

    // Graph representation for Kruskal's Algorithm
    static class Edge {
        int src, dest, weight;
    }

    static class Graph {
        int V, E; // Number of vertices and edges
        Edge[] edges;

        Graph(int v, int e) {
            V = v;
            E = e;
            edges = new Edge[e];
            for (int i = 0; i < e; ++i)
                edges[i] = new Edge();
        }
    }

    // Main method
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // Input number of vertices and edges
        System.out.print("Enter the number of vertices: ");
        int V = sc.nextInt();
        System.out.print("Enter the number of edges: ");
        int E = sc.nextInt();

        // Create a graph
        Graph graph = new Graph(V, E);

        System.out.println("Enter the edges in the format: src dest weight");
        for (int i = 0; i < E; i++) {
            System.out.print("Edge " + (i + 1) + ": ");
            graph.edges[i].src = sc.nextInt() - 1; // Adjusting for 0-based indexing
            graph.edges[i].dest = sc.nextInt() - 1;
            graph.edges[i].weight = sc.nextInt();
        }

        sc.close();

        System.out.println("\nKruskal's Algorithm:");
        KruskalMST(graph);
    }

    // ---------------- Disjoint Set Methods ----------------

    // makeset method
    static void makeset(int n) {
        u = new int[n];
        for (int i = 0; i < n; i++) {
            u[i] = i;
        }
    }

    // find method
    static int find(int[] u, int i) {
        int j = i;
        while (u[j] != j) {
            j = u[j];
        }
        return j;
    }

    // merge method
    static void merge(int p, int q) {
        if (q > p) {
            u[q] = p;
        } else {
            u[p] = q;
        }
    }

    // equal method
    static boolean equal(int p, int q) {
        return p == q;
    }

    // ---------------- Kruskal's Algorithm ----------------

    static void KruskalMST(Graph graph) {
        int V = graph.V;
        Edge[] result = new Edge[V]; // Tnis will store the resultant MST
        int e = 0; // Index used in result[]
        int i; // Index used for sorted edges

        // Step 1: Sort all the edges in non-decreasing order of their weight
        Arrays.sort(graph.edges, Comparator.comparingInt(o -> o.weight));

        // Allocate memory for disjoint sets
        makeset(V);

        i = 0; // Index for sorted edges
        while (e < V - 1 && i < graph.E) {
            // Step 2: Pick the smallest edge and increment the index for next iteration
            Edge nextEdge = graph.edges[i++];
            int x = find(u, nextEdge.src);
            int y = find(u, nextEdge.dest);

            // If including this edge doesn't cause cycle, include it in result
            if (!equal(x, y)) {
                result[e++] = nextEdge;
                merge(x, y);
            }
            // Else discard the edge
        }

        // Print the constructed MST
        System.out.println("Edges in the MST:");
        int totalWeight = 0;
        for (i = 0; i < e; ++i) {
            System.out.println((result[i].src + 1) + " -- " + (result[i].dest + 1) + " == " + result[i].weight);
            totalWeight += result[i].weight;
        }
        System.out.println("Total weight of MST: " + totalWeight);
    }
}