package StudentRecord;
class Student {
    String name;
    int age;
    String department;
    boolean feePending;
    double attendence;

    // Constructor
    public Student(String name, int age, String department,boolean feePending,double attendence) {
        this.name = name;
        this.age = age;
        this.department = department;
        this.feePending=feePending;
        this.attendence=attendence;
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
    int noPendingFee;
    double avgAtd;

    StudentLinkedList(){
        noPendingFee=0;
        avgAtd=0.0;
    }

    void calAvgAtd(){
        double atdSum=0;
        int n=0;
        Node node=head;
        if(node==null){
            avgAtd=0.0;
            return;
        }
        while(node.next!=null){
           atdSum+=node.data.attendence;
            n++;
            node=node.next;
        }
        avgAtd= atdSum/(double)n;
    }
    void calNoPendingFee(){
        int n=0;
        Node node=head;
        if(node==null){
            noPendingFee=0; return;
        }
        while(node.next!=null){
            if(node.data.feePending==true)
                n++;
            
            node=node.next;
        }
        noPendingFee= n;
    }
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
        calNoPendingFee();
        calAvgAtd();
        System.out.println("No of students with pending fee: "+noPendingFee+
        ", Average Attendance: "+avgAtd);
        while (current != null) {
            System.out.println("Name: " + current.data.name + ", Age: " + current.data.age +
             ", Department: " + current.data.department+ "\nAttendance:"+ current.data.attendence
             +", Fee Pending? "+ ((boolean) current.data.feePending==true?"Yes":"No"));
            current = current.next;
        }
    }
}

public class StudentRecord {
    public static void main(String[] args) {
        // Create a linked list of students
        StudentLinkedList studentList = new StudentLinkedList();

        // Insert some students
        studentList.insert(new Student("Alice", 20, "Computer Science",true,77.6));
        studentList.insert(new Student("Bob", 21, "Electrical Engineering",false,88.3));
        studentList.insert(new Student("Charlie", 19, "Mathematics",false,56.7));

        // Display the linked list of students
        studentList.display();
    }
}
