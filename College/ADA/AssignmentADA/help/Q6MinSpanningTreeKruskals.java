package AssignmentADA.help;

// Write a program to get minimum spanning tree of a given graph using Kruskal's algorithm

import java.util.*;

class Edge implements Comparable<Edge> {
    int src, dest, weight;

    Edge(int src, int dest, int weight) {
        this.src = src;
        this.dest = dest;
        this.weight = weight;
    }

    @Override
    public int compareTo(Edge other) {
        return Integer.compare(this.weight, other.weight);
    }
}

class Graph {
    int V;
    List<Edge> edges;

    Graph(int V) {
        this.V = V;
        edges = new ArrayList<>();
    }

    void addEdge(int src, int dest, int weight) {
        edges.add(new Edge(src, dest, weight));
    }

    // Find function for the disjoint-set (Union-Find)
    int find(int[] parent, int vertex) {
        if (parent[vertex] != vertex) {
            parent[vertex] = find(parent, parent[vertex]);  // Path compression
        }
        return parent[vertex];
    }

    // Union function for the disjoint-set
    void union(int[] parent, int[] rank, int srcRoot, int destRoot) {
        if (rank[srcRoot] < rank[destRoot]) {
            parent[srcRoot] = destRoot;
        } else if (rank[srcRoot] > rank[destRoot]) {
            parent[destRoot] = srcRoot;
        } else {
            parent[destRoot] = srcRoot;
            rank[srcRoot]++;
        }
    }

    void kruskalMST() {
        Collections.sort(edges);

        int[] parent = new int[V];
        int[] rank = new int[V];

        for (int i = 0; i < V; i++) {
            parent[i] = i;
            rank[i] = 0;
        }

        List<Edge> mst = new ArrayList<>();
        int mstCost = 0;

        for (Edge edge : edges) {
            int srcRoot = find(parent, edge.src);
            int destRoot = find(parent, edge.dest);

            if (srcRoot != destRoot) {
                mst.add(edge);
                mstCost += edge.weight;
                union(parent, rank, srcRoot, destRoot);
            }
        }

        System.out.println("Edges in the Minimum Spanning Tree:");
        for (Edge edge : mst) {
            System.out.println(edge.src + " -- " + edge.dest + " == " + edge.weight);
        }
        System.out.println("Total cost of the Minimum Spanning Tree: " + mstCost);
    }
}

public class Q6MinSpanningTreeKruskals {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);

        System.out.println("Enter the number of vertices:");
        int V = s.nextInt();

        System.out.println("Enter the number of edges:");
        int E = s.nextInt();

        Graph graph = new Graph(V);

        System.out.println("Enter the edges in the format: src dest weight");
        for (int i = 0; i < E; i++) {
            int src = s.nextInt();
            int dest = s.nextInt();
            int weight = s.nextInt();
            graph.addEdge(src, dest, weight);
        }

        graph.kruskalMST();
    }
}
