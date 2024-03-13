package ArrayTreeRepresentation;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

class ArrayTree<T> {
    int height;
    // Object[] allows the ArrayTree class to store objects of any type, including instances of the generic type T. 
    Object[] arrTree;

    ArrayTree(int height) {
        this.height = height;
        int size = (int) Math.pow(2, height) - 1;
        arrTree = new Object[size];
    }

    boolean isEmpty() {
        return arrTree[0] == null;
    }

    // accepts generic type T
    void build(int i, Scanner sc) {
        if (i == 0) {
            System.out.println("Enter the root node");
        } else if (i % 2 == 1) {
            System.out.println("Enter the left child of " + arrTree[(i - 1) / 2] + " node:");
        } else {
            System.out.println("Enter the right child of " + arrTree[(i - 1) / 2] + " node:");
        }
        // String returned by sc.next() is automatically upcasted to an Object
        // actual type of data stored in the array depends on the type parameter T 
        // everything is resolved in compile time
        arrTree[i] = sc.next(); // store generic type

        char choice;
        System.out.println("Does " + arrTree[i] + " has left child");
        choice = sc.next().charAt(0);
        if ((choice == 'y' || choice == 'Y') && ((2 * (i + 1) - 1) < arrTree.length)) {
            build(2 * (i + 1) - 1, sc);
        }
        System.out.println("Does " + arrTree[i] + " has right child");
        choice = sc.next().charAt(0);
        if ((choice == 'y' || choice == 'Y') && ((2 * (i + 1)) < arrTree.length)) {
            build(2 * (i + 1), sc);
        }
    }

    int size() {
        int n = 0;
        for (int i = 0; i < arrTree.length; i++) {
            if (arrTree[i] != null)
                n++;
        }
        return n;
    }

    int height() {
        return height;
    }

    // will start from root i.e. 0
    void preOrder(int i) {
        if (arrTree[i] != null)
            System.out.println(arrTree[i]);
        int rightNodePos = 2 * (i + 1);
        int leftNodePos = rightNodePos - 1;
        if (leftNodePos < arrTree.length && arrTree[leftNodePos] != null) {
            preOrder(leftNodePos);
        }
        if (rightNodePos < arrTree.length && arrTree[rightNodePos] != null) {
            preOrder(rightNodePos);
        }
    }

    void inOrder(int i) {
        int rightNodePos = 2 * (i + 1);
        int leftNodePos = rightNodePos - 1;
        if (leftNodePos < arrTree.length && arrTree[leftNodePos] != null) {
            inOrder(leftNodePos);
        }
        if (arrTree[i] != null)
            System.out.println(arrTree[i]);

        if (rightNodePos < arrTree.length && arrTree[rightNodePos] != null) {
            inOrder(rightNodePos);
        }
    }

    void postOrder(int i) {
        int rightNodePos = 2 * (i + 1);
        int leftNodePos = rightNodePos - 1;
        if (leftNodePos < arrTree.length && arrTree[leftNodePos] != null) {
            postOrder(leftNodePos);
        }
        if (rightNodePos < arrTree.length && arrTree[rightNodePos] != null) {
            postOrder(rightNodePos);
        }
        if (arrTree[i] != null)
            System.out.println(arrTree[i]);
    }

    void levelOrder() {
        if (arrTree[0] == null)
            return;
        // will contain index of the array
        Queue<Integer> queue = new LinkedList<>();
        queue.add(0);
        System.out.println("The level order traversal of given tree is: ");
        while (!queue.isEmpty()) {
            int i = queue.remove();
            System.out.print(arrTree[i] + " ");
            int rightNodePos = 2 * (i + 1);
            int leftNodePos = rightNodePos - 1;
            if (leftNodePos < arrTree.length && arrTree[leftNodePos] != null)
                queue.add(leftNodePos);
            if (rightNodePos < arrTree.length && arrTree[rightNodePos] != null)
                queue.add(rightNodePos);
        }
    }
}

public class ArrayTreeRepresentation {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter the height of the tree: ");
        int height = scanner.nextInt();
        ArrayTree<Integer> tree = new ArrayTree<>(height);

        int choice;
        do {
            System.out.println("\nMenu:");
            System.out.println("1. Build Tree");
            System.out.println("2. Pre-order Traversal");
            System.out.println("3. In-order Traversal");
            System.out.println("4. Post-order Traversal");
            System.out.println("5. Level-order Traversal");
            System.out.println("6. Exit");
            System.out.print("Enter your choice: ");
            choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    tree.build(0, scanner);
                    break;
                case 2:
                    System.out.println("Pre-order Traversal:");
                    tree.preOrder(0);
                    break;
                case 3:
                    System.out.println("In-order Traversal:");
                    tree.inOrder(0);
                    break;
                case 4:
                    System.out.println("Post-order Traversal:");
                    tree.postOrder(0);
                    break;
                case 5:
                    System.out.println("Level-order Traversal:");
                    tree.levelOrder();
                    break;
                case 6:
                    System.out.println("Exiting...");
                    break;
                default:
                    System.out.println("Invalid choice. Please enter a number between 1 and 6.");
            }
        } while (choice != 6);

        scanner.close();
    }
}

