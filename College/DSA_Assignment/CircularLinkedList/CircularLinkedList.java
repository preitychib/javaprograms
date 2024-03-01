package CircularLinkedList;

class Node {
    int data;
    Node link;

    Node(int data) {
        this.data = data;
        this.link = null;
    }
}

class CircularLinkedList {
    Node first;

    CircularLinkedList() {
        this.first = null;
    }

    public boolean isEmpty() {
        return first == null;
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

    public void display() {
        if (isEmpty()) {
            System.out.println("List is empty");
            return;
        }
        Node current = first;
        do {
            System.out.print(current.data + " ");
            current = current.link;
        } while (current != first);
        System.out.println();
    }

    public static void main(String[] args) {
        CircularLinkedList list = new CircularLinkedList();

        try {
            list.insert(10, 0);
            list.insert(20, 1);
            list.insert(30, 2);
            list.insert(40, 3);
            list.insert(50, 1);
            list.insert(60, 0);

            list.display();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}


