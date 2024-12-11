package AssignmentADA.help;

// Write a program for Traversing Sales Person (TSP) problem using best first search branch and bound method.

import java.util.*;

class TSPNode implements Comparable<TSPNode> {
    int level;
    int[] path;
    int bound;
    int cost;

    TSPNode(int level, int[] path, int bound, int cost) {
        this.level = level;
        this.path = path.clone();
        this.bound = bound;
        this.cost = cost;
    }

    @Override
    public int compareTo(TSPNode other) {
        return Integer.compare(this.bound, other.bound);
    }
}

public class Q3TravellingSalesPerson {

    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);

        System.out.println("Enter the number of cities:");
        int n = s.nextInt();
        int[][] graph = new int[n][n];

        System.out.println("Enter the adjacency matrix (enter 9999 for no direct path):");
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                graph[i][j] = s.nextInt();
                if (i == j) graph[i][j] = 0;
            }
        }

        int result = tspBestFirstSearch(graph);
        System.out.println("Minimum cost to visit all cities: " + result);

    }

    private static int tspBestFirstSearch(int[][] graph) {
        int n = graph.length;
        PriorityQueue<TSPNode> pq = new PriorityQueue<>();
        int[] initialPath = new int[n + 1];
        initialPath[0] = 0;
        TSPNode root = new TSPNode(0, initialPath, calculateBound(graph, initialPath, 0), 0);
        pq.add(root);

        int minCost = Integer.MAX_VALUE;

        while (!pq.isEmpty()) {
            TSPNode current = pq.poll();

            if (current.bound < minCost) {
                for (int i = 0; i < n; i++) {
                    if (isValidNextCity(current.path, current.level, i)) {
                        int[] newPath = current.path.clone();
                        newPath[current.level + 1] = i;
                        int newCost = current.cost + graph[current.path[current.level]][i];

                        if (current.level + 1 == n - 1) {
                            newCost += graph[i][0];
                            minCost = Math.min(minCost, newCost);
                        } else {
                            int newBound = calculateBound(graph, newPath, newCost);
                            if (newBound < minCost) {
                                pq.add(new TSPNode(current.level + 1, newPath, newBound, newCost));
                            }
                        }
                    }
                }
            }
        }
        return minCost;
    }

    private static int calculateBound(int[][] graph, int[] path, int currentCost) {
        int n = graph.length;
        boolean[] visited = new boolean[n];
        for (int i = 0; i <= path[0]; i++) {
            visited[path[i]] = true;
        }

        int bound = currentCost;
        for (int i = 0; i < n; i++) {
            if (!visited[i]) {
                int minEdge = Integer.MAX_VALUE;
                for (int j = 0; j < n; j++) {
                    if (i != j && !visited[j]) {
                        minEdge = Math.min(minEdge, graph[i][j]);
                    }
                }
                bound += minEdge;
            }
        }
        return bound;
    }

    private static boolean isValidNextCity(int[] path, int level, int city) {
        for (int i = 0; i <= level; i++) {
            if (path[i] == city) {
                return false;
            }
        }
        return true;
    }

    
}
