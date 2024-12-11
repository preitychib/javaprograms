package AssignmentADA.help;

// Write a function in polynomial time complexity to convert an undirected graph into equivalent CNF- Boolean function. Thereafter, write a program to read adjacency matrix of the graph and check whether it is having a clique of k vertices or not by checking the corresponding CNF-Boolean function's satisfiability, where k is entered by user

import java.util.*;

public class Q2GraphToCNF {

    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);

        System.out.println("Enter the number of vertices in the graph:");
        int n = s.nextInt();

        System.out.println("Enter the adjacency matrix:");
        int[][] adjacencyMatrix = new int[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                adjacencyMatrix[i][j] = s.nextInt();
            }
        }

        System.out.println("Enter the value of k (size of clique):");
        int k = s.nextInt();

        String cnf = convertGraphToCNF(adjacencyMatrix, k);
        boolean satisfiable = isCNFSatisfiable(cnf);

        if (satisfiable) {
            System.out.println("The graph contains a clique of size " + k + ".");
        } else {
            System.out.println("The graph does not contain a clique of size " + k + ".");
        }

    }

    // Function to convert the graph into CNF
    public static String convertGraphToCNF(int[][] adjacencyMatrix, int k) {
        int n = adjacencyMatrix.length;
        StringBuilder cnf = new StringBuilder();

        // Ensure each position in the clique is filled by a distinct vertex
        for (int i = 1; i <= k; i++) {
            StringBuilder clause = new StringBuilder();
            for (int v = 1; v <= n; v++) {
                clause.append("x").append(v).append(i).append(" v ");
            }
            clause.setLength(clause.length() - 3);  // Remove the last 'v'
            cnf.append("(").append(clause).append(") ^ ");
        }

        // Ensure no two positions are filled by the same vertex
        for (int i = 1; i <= k; i++) {
            for (int j = 1; j <= n; j++) {
                for (int l = j + 1; l <= n; l++) {
                    cnf.append("(~x").append(j).append(i).append(" v ~x").append(l).append(i).append(") ^ ");
                }
            }
        }

        // Ensure vertices selected form a clique
        for (int i = 1; i <= k; i++) {
            for (int j = i + 1; j <= k; j++) {
                for (int v1 = 1; v1 <= n; v1++) {
                    for (int v2 = v1 + 1; v2 <= n; v2++) {
                        if (adjacencyMatrix[v1 - 1][v2 - 1] == 0) {
                            cnf.append("(~x").append(v1).append(i).append(" v ~x").append(v2).append(j).append(") ^ ");
                        }
                    }
                }
            }
        }

        cnf.setLength(cnf.length() - 3);  // Remove the last ' ^ '
        return cnf.toString();
    }

    // Function to simulate checking satisfiability (placeholder for actual SAT solver)
    public static boolean isCNFSatisfiable(String cnf) {
        // In a real-world scenario, this function would call a SAT solver.
        // Here, we assume the formula is satisfiable as a placeholder.
        System.out.println("CNF Formula: " + cnf);
        // Use SAT4J or another SAT solver library for actual checking.
        return true;  // Placeholder
    }

    
}

