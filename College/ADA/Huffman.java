import java.util.*;

class Node implements Comparable<Node> {
    char symbol;
    int frequency;
    Node left, right;

    public Node(char symbol, int frequency) {
        this.symbol = symbol;
        this.frequency = frequency;
    }

    public Node(int frequency, Node left, Node right) {
        this.frequency = frequency;
        this.left = left;
        this.right = right;
    }

    @Override
    public int compareTo(Node other) {
        return this.frequency - other.frequency;
    }
}

public class Huffman {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter the number of symbols: ");
        int n = scanner.nextInt();

        char[] symbols = new char[n];
        int[] frequencies = new int[n];

        for (int i = 0; i < n; i++) {
            System.out.print("Enter symbol " + (i + 1) + ": ");
            symbols[i] = scanner.next().charAt(0);
            System.out.print("Enter frequency for symbol " + symbols[i] + ": ");
            frequencies[i] = scanner.nextInt();
        }

        Node root = huffman(symbols, frequencies, n);

        System.out.println("Huffman Tree:");
        printHuffmanTree(root, "");

        scanner.close();
    }

    public static Node huffman(char[] symbols, int[] frequencies, int n) {
        PriorityQueue<Node> pq = new PriorityQueue<>();

        for (int i = 0; i < n; i++) {
            Node x = new Node(symbols[i], frequencies[i]);
            pq.offer(x);
        }

        for (int i = 1; i < n; i++) {
            Node p = pq.poll();
            Node q = pq.poll();
            Node r = new Node(p.frequency + q.frequency, p, q);
            pq.offer(r);
        }

        return pq.poll();
    }

    public static void printHuffmanTree(Node node, String code) {
        if (node == null) {
            return;
        }

        if (node.left == null && node.right == null) {
            System.out.println(node.symbol + ": " + code);
        }

        printHuffmanTree(node.left, code + "0");
        printHuffmanTree(node.right, code + "1");
    }
}