package GeneralTree;

import java.util.Scanner;

class Node<T> {
    T data;
    Node<T> left;
    Node<T> right;

    Node() {
        this.data = null;
        this.left = null;
        this.right = null;
    }

    Node(T data) {
        this.data = data;
        this.left = null;
        this.right = null;
    }

    Node(T data, Node<T> left, Node<T> right) {
        this.data = data;
        this.left = left;
        this.right = right;
    }
}

public class GeneralTree<T> {
    Node<T> root;

    GeneralTree() {
        root = null;
    }

    boolean isEmpty() {
        return root == null;
    }

    
    void build(Node<T> current, Node<T> previous,Scanner sc) {
        if (current == null) {
            current = root =new Node<T>();
            System.out.println("Enter the root node: ");
        } else if (current == previous.left) {
            System.out.println("Enter the left child of "+ previous.data);
        } else {
            System.out.println("Enter the right child of " + previous.data);
        }
        @SuppressWarnings("unchecked")
        T data =(T) sc.next();
        current.data = (T) data;
        
    }
    int size(Node<T> r) {
        if (r == null) {
            return 0;
        } else {
            return size(r.left) + size(r.right) + 1;
        }
    }

    void preOrder(Node<T> r) {
        if (r != null) {
            System.out.print(r.data + " ");
            preOrder(r.left);
            preOrder(r.right);
        }
    }

    void inOrder(Node<T> r) {
        if (r != null) {
            inOrder(r.left);
            System.out.print(r.data + " ");
            inOrder(r.right);
        }
    }

    void postOrder(Node<T> r) {
        if (r != null) {
            postOrder(r.left);
            postOrder(r.right);
            System.out.print(r.data + " ");
        }
    }

    Node<T> getRoot() {
        return root;
    }
}

