package RadixSort;


class Node {
    int data;
    Node link;

    Node(int data) {
        this.data = data;
        this.link = null;
    }

    Node(int data, Node link) {
        this.data = data;
        this.link = link;
    }
}

class LinkedList {
    Node first;
    int size;

    LinkedList() {
        this.size = 0;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public int getSize() {
        return this.size;
    }

    public void insert(int data) {
        Node newNode = new Node(data);
        newNode.link = first;
        first = newNode;
        size++;
    }

    public Object delete() {
        if (isEmpty()) {
            System.out.println("List is empty. Nothing to delete.");
            return null;
        } else {
            Node temp = first;
            first = first.link;
            size--;
            return temp.data;
        }
    }

    public Object deleteLast() {
        if (isEmpty()) {
            System.out.println("List is empty. Nothing to delete.");
            return null;
        } else {
            Node current = first;
            Node previous = null;
            while (current.link != null) {
                previous = current;
                current = current.link;
            }
            if (previous == null) {
                first = null;
            } else {
                previous.link = null;
            }
            size--;
            return current.data;
        }
    }
}

public class RadixSort {

    public static void radixSort(int[] a, int n) {
        int m = max(a, n);
        int d = (int) Math.floor(Math.log10(m)) + 1;
        LinkedList[] L = new LinkedList[10];

        for (int i = 0; i < 10; i++) {
            L[i] = new LinkedList();
        }

        for (int k = 1; k <= d; k++) {
            for (int i = 0; i < n; i++) {
                L[(a[i] / (int) Math.pow(10, k - 1)) % 10].insert(a[i]);
            }
            int i = 0;
            for (int j = 0; j < 10; j++) {
                while (!L[j].isEmpty()) {
                    a[i] = (int) L[j].deleteLast();
                    i++;
                }
            }
        }
    }

    public static int max(int[] a, int n) {
        int max = a[0];
        for (int i = 1; i < n; i++) {
            if (a[i] > max) {
                max = a[i];
            }
        }
        return max;
    }

    public static void printArray(int[] arr) {
        for (int i : arr) {
            System.out.print(i + " ");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        int[] array = {329, 457, 657, 839, 436, 720, 355};
        int n = array.length;

        System.out.println("Original array:");
        printArray(array);

        radixSort(array, n);

        System.out.println("Sorted array:");
        printArray(array);
    }
}

