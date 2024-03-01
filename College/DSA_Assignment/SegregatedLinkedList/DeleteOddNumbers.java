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

    public Node deleteOddNumbers(Node first) {
        if (first == null) {
            return null;
        }

        Node current = first;
        Node prev = null;

        while (current != null && current.data % 2 != 0) {
            first = current.link;
            current = first;
        }

        while (current != null) {
            while (current != null && current.data % 2 == 0) {
                prev = current;
                current = current.link;
            }

            if (current == null) {
                return first;
            }

            prev.link = current.link;
            current = prev.link;
        }

        return first;
    }

    public void display(Node first) {
        Node temp = first;
        while (temp != null) {
            System.out.print(temp.data + " ");
            temp = temp.link;
        }
        System.out.println();
    }
}

public class DeleteOddNumbers {
    public static void main(String[] args) {
        LinkedList list = new LinkedList();

        list.first = new Node(1);
        list.first.link = new Node(2);
        list.first.link.link = new Node(3);
        list.first.link.link.link = new Node(4);
        list.first.link.link.link.link = new Node(5);

        System.out.println("Original list:");
        list.display(list.first);

        list.first = list.deleteOddNumbers(list.first);

        System.out.println("Modified list after deleting odd numbers:");
        list.display(list.first);
    }
}