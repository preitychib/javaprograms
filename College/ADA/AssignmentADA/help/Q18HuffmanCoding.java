package AssignmentADA.help;

import java.util.*;

class Node implements Comparable<Node> {
    char symbol;
    int frequency;
    Node left, right;

    public Node(char symbol, int frequency) {
        this.symbol = symbol;
        this.frequency = frequency;
        this.left = null;
        this.right = null;
    }

    public Node(int frequency, Node left, Node right) {
        this.symbol = '\0'; // Non-leaf nodes do not hold a symbol
        this.frequency = frequency;
        this.left = left;
        this.right = right;
    }

    public boolean isLeaf() {
        return (this.left == null && this.right == null);
    }

    @Override
    public int compareTo(Node other) {
        return this.frequency - other.frequency;
    }
}

public class Q18HuffmanCoding {
    public static Node Huffman(char[] symbol, int[] frequency, int n) {
        PriorityQueue<Node> PQ = new PriorityQueue<>();
        for (int i = 0; i < n; i++) {
            Node x = new Node(symbol[i], frequency[i]);
            PQ.add(x);
        }
        for (int i = 1; i <= n - 1; i++) {
            Node p = PQ.remove();
            Node q = PQ.remove();
            Node r = new Node(p.frequency + q.frequency, p, q);
            PQ.add(r);
        }
        return PQ.remove();
    }

    public static void generateCodes(Node root, String code, Map<Character, String> huffmanCode) {
        if (root == null)
            return;
        if (root.isLeaf()) {
            huffmanCode.put(root.symbol, code);
        }
        generateCodes(root.left, code + "0", huffmanCode);
        generateCodes(root.right, code + "1", huffmanCode);
    }

    public static void main(String[] args) {
        char[] symbol = { 'A', 'B', 'C', 'D', 'E', 'F' };
        int[] frequency = { 5, 9, 12, 13, 16, 45 };
        int n = symbol.length;

        Node root = Huffman(symbol, frequency, n);

        Map<Character, String> huffmanCode = new HashMap<>();
        generateCodes(root, "", huffmanCode);

        System.out.println("Huffman Codes:");
        for (char c : symbol) {
            System.out.println(c + ": " + huffmanCode.get(c));
        }
    }
}