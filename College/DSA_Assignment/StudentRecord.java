class Student {
    String name;
    int age;
    String department;

    // Constructor
    public Student(String name, int age, String department) {
        this.name = name;
        this.age = age;
        this.department = department;
    }
}

class Node {
    Student data;
    Node next;

    // Constructor
    public Node(Student data) {
        this.data = data;
        this.next = null;
    }
}

class StudentLinkedList {
    Node head;

    // Method to insert a new student at the end of the linked list
    public void insert(Student data) {
        Node newNode = new Node(data);

        if (head == null) {
            head = newNode;
        } else {
            Node current = head;
            while (current.next != null) {
                current = current.next;
            }
            current.next = newNode;
        }
    }

    // Method to display the linked list of students
    public void display() {
        Node current = head;
        while (current != null) {
            System.out.println("Name: " + current.data.name + ", Age: " + current.data.age + ", Department: " + current.data.department);
            current = current.next;
        }
    }
}

public class StudentRecord {
    public static void main(String[] args) {
        // Create a linked list of students
        StudentLinkedList studentList = new StudentLinkedList();

        // Insert some students
        studentList.insert(new Student("Alice", 20, "Computer Science"));
        studentList.insert(new Student("Bob", 21, "Electrical Engineering"));
        studentList.insert(new Student("Charlie", 19, "Mathematics"));

        // Display the linked list of students
        studentList.display();
    }
}
