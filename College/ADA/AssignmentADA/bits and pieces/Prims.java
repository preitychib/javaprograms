import java.util.*;

class Edge {
    int to;
    int weight;

    public Edge(int to, int weight) {
        this.to = to;
        this.weight = weight;
    }
}

public class Prims {
    static int spanningTree(int vt, int ed, List<List<Edge>> adj) {
        // Priority queue to select the minimum weight edge
        PriorityQueue<Edge> pq = new PriorityQueue<>((e1, e2) -> Integer.compare(e1.weight, e2.weight));

        boolean[] visited = new boolean[vt];
        int totalWeight = 0;

        // To store edges of the MST
        List<String> mstEdges = new ArrayList<>();

        // Start from vertex 0
        pq.add(new Edge(0, 0));
        int[] parent = new int[vt]; // To keep track of the parent for each node
        Arrays.fill(parent, -1);

        while (!pq.isEmpty()) {
            Edge current = pq.poll();

            int vertex = current.to;
            int weight = current.weight;

            // Skip if the vertex is already visited
            if (visited[vertex]) continue;

            // Include this edge's weight in the MST
            totalWeight += weight;
            visited[vertex] = true;

            // If this edge forms part of the MST, store it
            if (parent[vertex] != -1) {
                mstEdges.add(parent[vertex] + " - " + vertex + " (Weight: " + weight + ")");
            }

            // Add all adjacent edges to the priority queue
            for (Edge neighbor : adj.get(vertex)) {
                if (!visited[neighbor.to]) {
                    pq.add(new Edge(neighbor.to, neighbor.weight));
                    parent[neighbor.to] = vertex; // Update the parent of the neighbor
                }
            }
        }

        // Print the MST edges
        System.out.println("Edges in the Minimum Spanning Tree:");
        for (String edge : mstEdges) {
            System.out.println(edge);
        }

        return totalWeight;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Enter the number of vertices and edges in the graph: ");
        int v = sc.nextInt();
        int e = sc.nextInt();

        // Initialize adjacency list
        List<List<Edge>> adj = new ArrayList<>();
        for (int i = 0; i < v; i++) {
            adj.add(new ArrayList<>());
        }

        System.out.println("Enter the edges one by one (format: v1 v2 weight):");
        for (int i = 0; i < e; i++) {
            int v1 = sc.nextInt();
            int v2 = sc.nextInt();
            int w = sc.nextInt();

            // Add edges to the adjacency list
            adj.get(v1).add(new Edge(v2, w));
            adj.get(v2).add(new Edge(v1, w));
        }

        // Call the spanningTree function and print the result
        int mstWeight = spanningTree(v, e, adj);
        System.out.println("Length of Minimum Spanning Tree: " + mstWeight);

        sc.close();
    }
}
