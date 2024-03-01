package CircularLinkedList;

import java.util.Scanner;

class Node {
    int data;
    Node link;

    Node(int data) {
        this.data = data;
        this.link = null;
    }
}
public class CircularLinkedList {
    Node first;

    CircularLinkedList() {
        this.first = null;
    }

    
    public void insert(int x, int index) throws Exception {
        if (index < 0) {
            throw new Exception("Invalid index");
        }

        Node newNode = new Node(x);
        newNode.link = newNode; // Circular link to itself

        if (isEmpty()) {
            first = newNode;
        } else if (index == 0) {
            Node last = first;
            while (last.link != first) {
                last = last.link;
            }
            newNode.link = first;
            first = newNode;
            last.link = first;
        } else {
            Node prev = first;
            for (int i = 1; i < index; i++) {
                prev = prev.link;
            }
            newNode.link = prev.link;
            prev.link = newNode;
        }
    }

    public void delete(int index) throws Exception {
        if (isEmpty()) {
            throw new Exception("Linked list is empty.");
        }

        if (index < 0 || index >= size()) {
            throw new Exception("Invalid index");
        }

        Node del;

        if (index == 0 && size() == 1) {
            del = first;
            first = null;
        } else if (index == 0) {
            Node last = first;
            while (last.link != first) {
                last = last.link;
            }
            del = first;
            first = del.link;
            last.link = first;
        } else {
            Node prev = first;
            for (int i = 1; i < index; i++) {
                prev = prev.link;
            }
            del = prev.link;
            prev.link = del.link;
        }
    }

    public int indexOf(int x) {
        if (isEmpty()) {
            return -1;
        }

        int index = 0;
        Node cur = first;

        while (cur.link != first && cur.data != x) {
            cur = cur.link;
            index++;
        }

        if (cur.data != x) {
            return -1;
        } else {
            return index;
        }
    }

    public int get(int index) throws Exception {
        if (index < 0 || index >= size()) {
            throw new Exception("Invalid index");
        }

        Node cur = first;
        for (int i = 0; i < index; i++) {
            cur = cur.link;
        }
        return cur.data;
    }

    public void display() {
        if (isEmpty()) {
            System.out.println("List is empty");
            return;
        }
        Node cur = first;
        do {
            System.out.print(cur.data + " ");
            cur = cur.link;
        } while (cur != first);
        System.out.println();
    }

    public int size() {
        if (first == null) {
            return 0;
        }
        int size = 1;
        Node cur = first;
        while (cur.link != first) {
            size++;
            cur = cur.link;
        }
        return size;
    }

    public boolean isEmpty() {
        return first == null;
    }

    public void readData(Node node,Scanner scanner) {
        System.out.print("Enter data: ");
        int data = scanner.nextInt();
        node.data = data;
    }

    public void create(int n) throws Exception {
        Node cur = null;
        Scanner scanner = new Scanner(System.in);

        for (int i = 1; i <= n; i++) {
            if (i == 1) {
                cur = first = new Node(0); // Assuming default value is 0
            } else {
                cur.link = new Node(0);
                cur = cur.link;
            }
            readData(cur,scanner);
        }
        cur.link = first;
        scanner.close();
    }
}