package AssignmentADA.help;

// Write a function of polynomial time complexity to convert a CNF-Boolean function into equivalent graph. Thereafter, write a program to read a CNF-Boolean function and check whether it is satisfiability or not by checking the corresponding graph having a clique of k vertices or not, where k is number of sum terms in the CNF-Boolean function.

import java.util.*;

public class Q1CNFBooleanFunctionality {

    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        System.out.println("Enter CNF Boolean formula (e.g., (A v ~B) ^ (~A v C) ^ (B v C)):");
        String cnf = s.nextLine();
        if (isSatisfiable(cnf)) {
            System.out.println("The CNF formula is satisfiable.");
        } else {
            System.out.println("The CNF formula is not satisfiable.");
        }
    }

    // Represent the graph using an adjacency list
    static class Graph {
        private Map<String, Set<String>> adjacencyList = new HashMap<>();

        void addNode(String node) {
            adjacencyList.putIfAbsent(node, new HashSet<>());
        }

        void addEdge(String node1, String node2) {
            adjacencyList.get(node1).add(node2);
            adjacencyList.get(node2).add(node1);
        }

        Set<String> getNeighbors(String node) {
            return adjacencyList.getOrDefault(node, new HashSet<>());
        }

        boolean hasCliqueOfSizeK(int k) {
            List<String> nodes = new ArrayList<>(adjacencyList.keySet());
            return findClique(nodes, new HashSet<>(), 0, k);
        }

        private boolean findClique(List<String> nodes, Set<String> currentClique, int index, int k) {
            if (currentClique.size() == k) return true;
            if (index == nodes.size()) return false;

            String node = nodes.get(index);
            if (canBeAddedToClique(node, currentClique)) {
                currentClique.add(node);
                if (findClique(nodes, currentClique, index + 1, k)) return true;
                currentClique.remove(node);
            }
            return findClique(nodes, currentClique, index + 1, k);
        }

        private boolean canBeAddedToClique(String node, Set<String> currentClique) {
            for (String member : currentClique) {
                if (!adjacencyList.get(node).contains(member)) return false;
            }
            return true;
        }
    }

    public static boolean isSatisfiable(String cnf) {
        String[] clauses = cnf.split("\\^");
        int k = clauses.length;
        Graph graph = new Graph();

        // Build graph
        for (int i = 0; i < clauses.length; i++) {
            String[] literals1 = clauses[i].replace("(", "").replace(")", "").split("v");
            for (String literal1 : literals1) {
                graph.addNode(literal1.trim());
                for (int j = i + 1; j < clauses.length; j++) {
                    String[] literals2 = clauses[j].replace("(", "").replace(")", "").split("v");
                    for (String literal2 : literals2) {
                        if (!areContradictory(literal1, literal2)) {
                            graph.addNode(literal2.trim());
                            graph.addEdge(literal1.trim(), literal2.trim());
                        }
                    }
                }
            }
        }

        return graph.hasCliqueOfSizeK(k);
    }

    private static boolean areContradictory(String literal1, String literal2) {
        return literal1.equals("~" + literal2) || literal2.equals("~" + literal1);
    }

   
}
