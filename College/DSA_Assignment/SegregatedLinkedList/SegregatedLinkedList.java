package SegregatedLinkedList;

class Node {
    int data;
    Node link;

    Node(int data) {
        this.data = data;
        this.link = null;
    }
}

class LinkedList {
    Node first;

    LinkedList() {
        this.first = null;
    }

    public void insert(int data) {
        Node newNode = new Node(data);
        if (first == null) {
            first = newNode;
        } else {
            Node temp = first;
            while (temp.link != null) {
                temp = temp.link;
            }
            temp.link = newNode;
        }
    }

    public void segregate() {
        if (first == null) return;

        Node cur = first, firstNeg = null, curNeg = null, firstPos = null, curPos = null;

        while (cur != null) {
            if (cur.data < 0) {
                if (firstNeg == null) {
                    firstNeg = curNeg = cur;
                } else {
                    curNeg.link = cur;
                    curNeg = curNeg.link;
                }
            } else if (cur.data > 0) {
                if (firstPos == null) {
                    firstPos = curPos = cur;
                } else {
                    curPos.link = cur;
                    curPos = curPos.link;
                }
            }
            cur = cur.link;
        }

        if (firstNeg != null) {
            if (firstPos != null) {
                curPos.link = null;
                curNeg.link = firstPos;
            } else {
                curNeg.link = null;
            }
            first = firstNeg;
        } else {
            if (firstPos != null) {
                curPos.link = null;
                first = firstPos;
            }
        }
    }

    public void display() {
        Node temp = first;
        while (temp != null) {
            System.out.print(temp.data + " ");
            temp = temp.link;
        }
        System.out.println();
    }
}

public class SegregatedLinkedList {
    public static void main(String[] args) {
        LinkedList list = new LinkedList();
        list.insert(9);
        list.insert(-3);
        list.insert(5);
        list.insert(-2);
        list.insert(-8);
        list.insert(-6);
        list.insert(1);
        list.insert(3);

        System.out.println("Original list:");
        list.display();

        list.segregate();

        System.out.println("Segregated list:");
        list.display();
    }
}
