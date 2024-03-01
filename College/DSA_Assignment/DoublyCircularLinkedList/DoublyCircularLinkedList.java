package DoublyCircularLinkedList;

import java.util.Scanner;

class Node {
    int data;
    Node Llink;
    Node Rlink;

    Node(int data) {
        this.data = data;
        this.Llink = null;
        this.Rlink = null;
    }
}

public class DoublyCircularLinkedList {
    Node first;

    DoublyCircularLinkedList() {
        this.first = null;
    }

    public boolean isEmpty() {
        return first == null;
    }

    public int size() {
        if (first == null) {
            return 0;
        }
        int size = 1;
        Node cur = first;
        while (cur.Rlink != first) {
            size++;
            cur = cur.Rlink;
        }
        return size;
    }

    public void insert(int x, int index) throws Exception {
        if (index < 0 || index > size()) {
            throw new Exception("Invalid index");
        }
        Node newNode = new Node(x);
        newNode.Llink = newNode;
        newNode.Rlink = newNode;

        if (isEmpty()) {
            first = newNode;
        } else if (index == 0) {
            Node last = first.Llink;
            Node next = first;
            newNode.Rlink = next;
            newNode.Llink = last;
            first = newNode;
            next.Llink = last.Rlink = first;
        } else {
            Node prev = first;
            for (int i = 1; i < index; i++) {
                prev = prev.Rlink;
            }
            Node next = prev.Rlink;
            newNode.Rlink = next;
            newNode.Llink = prev;
            prev.Rlink = next.Llink = newNode;
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
            Node last = first.Llink;
            del = first;
            first = del.Rlink;
            last.Rlink = first;
            first.Llink = last;
        } else {
            Node prev = first;
            for (int i = 1; i < index; i++) {
                prev = prev.Rlink;
            }
            del = prev.Rlink;
            Node next = del.Rlink;
            prev.Rlink = next;
            next.Llink = prev;
        }
    }

    public int indexOf(int x) {
        if (isEmpty()) {
            return -1;
        }
        int index = 0;
        Node cur = first;
        while (cur.Rlink != first && cur.data != x) {
            cur = cur.Rlink;
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
            cur = cur.Rlink;
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
            cur = cur.Rlink;
        } while (cur != first);
        System.out.println();
    }

    public void readData(Node node,Scanner scanner) {
        System.out.print("Enter data: ");
        int data = scanner.nextInt();
        node.data = data;
    }

    public void create(int n) throws Exception {
        if (n <= 0) {
            throw new Exception("Invalid size for list creation");
        }

        Node cur = null;
        Scanner scanner = new Scanner(System.in);

        for (int i = 1; i <= n; i++) {
            if (i == 1) {
                cur = first = new Node(0); // Assuming default value is 0
            } else {
                Node prev = cur;
                cur.Rlink = new Node(0);
                cur = cur.Rlink;
                cur.Llink = prev;
            }
            readData(cur,scanner);
        }

        if (cur != null) {
            cur.Rlink = first;
            first.Llink = cur;
        }
        scanner.close();
    }

    public static void main(String[] args) {
        try {
            DoublyCircularLinkedList list = new DoublyCircularLinkedList();
            list.create(5);
            list.display();
            list.insert(10, 2);
            list.display();
            list.delete(3);
            list.display();
            System.out.println("Index of 10: " + list.indexOf(10));
            System.out.println("Element at index 2: " + list.get(2));
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}