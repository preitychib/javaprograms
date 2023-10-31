import java.util.ArrayList;
import java.util.Iterator;
import java.util.Scanner;

public class StudentRegisterationDemo {
    //? Check if student exists in the arraylist.
    static boolean searchStudent(ArrayList<StudentRegisteration> studentList, int sId) {
        for (StudentRegisteration s : studentList) {
            if (s.getStudentId() == sId)
                return true;
        }
        return false;
    }
    
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int choice = 0;
        ArrayList<StudentRegisteration> studentList = new ArrayList<>();
        System.out.println("Student Placement Registeration Form.");
        System.out.println("(use the given menu to perform any operations)");
        do {
            System.out.println("Menu:");
            System.out.println("1) Register");
            System.out.println("2) Deregister");
            System.out.println("3) Update");
            System.out.println("4) View a Record");
            System.out.println("5) View List");
            System.out.println("6) Exit");

            choice = sc.nextInt();

            switch (choice) {
                //? Register student 
                case 1:
                    System.out.println("Enter the Details of the student:");
                    System.out.println("Student Id: ");
                    int sId = sc.nextInt();
                    sc.nextLine();
                    if (searchStudent(studentList, sId)) {
                        System.out.println("This user id already exists.");
                        break;
                    }
                    System.out.println("Student Name: ");
                    String sName = sc.nextLine();
                    System.out.println("Student Course: ");
                    String sCourse = sc.nextLine();
                    System.out.println("Student Current Semester SGPA: ");
                    float sgpa=sc.nextFloat();
                    sc.nextLine();
                    if (sgpa > 10 || sgpa<0) {
                        System.out.println("Invalid SGPA entered.");
                        break;
                    }
                    System.out.println("Student Email: ");
                    String sEmailId = sc.nextLine();
                    if (!sEmailId.matches("^[a-zA-Z0-9+_.-]+@[a-zA-Z0-9.-]+$")) {
                        System.out.println("Invalid Email Id entered");
                        break;
                    }
                    studentList.add(new StudentRegisteration(sId, sName, sCourse, sgpa, sEmailId));
                    break;

                //? Deregister student
                case 2:
                    System.out.println("Enter the Id of the student you want to deregister.");
                    int sDeleteId = sc.nextInt();
                    boolean found = false;
                    //? Creating an iterator to safely iterate over the studentList
                    //? To avoid ConcurrentModificationException 
                    Iterator<StudentRegisteration> iterator = studentList.iterator();
                    while (iterator.hasNext()) {
                        StudentRegisteration s = iterator.next();
                        if (s.getStudentId() == sDeleteId) {
                            iterator.remove();  // This removes the current element safely
                            found = true;
                        }
                    }
                    if (!found)
                        System.out.println("Given Student does not exists!");
                    break;

                //? Update Details
                case 3:
                    System.out.println("Enter the Id of the student whose details you want to update.");
                    int sUpdaterId = sc.nextInt();
                    sc.nextLine();
                    found = false;
                    for (StudentRegisteration s : studentList) {
                        if (s.getStudentId() == sUpdaterId) {
                            System.out.println("Enter the Details of the student:");
                            System.out.println("Student Name: ");
                            sName = sc.nextLine();
                            System.out.println("Student Course: ");
                            sCourse = sc.nextLine();
                            System.out.println("Student Current Semester SGPA: ");
                            sgpa=sc.nextFloat();
                            sc.nextLine();
                            if (sgpa > 10 || sgpa<0) {
                                System.out.println("Invalid SGPA entered.");
                                break;
                            }
                            System.out.println("Student Email: ");
                            sEmailId = sc.nextLine();
                            if (!sEmailId.matches("^[a-zA-Z0-9+_.-]+@[a-zA-Z0-9.-]+$")) {
                                System.out.println("Invalid Email Id entered");
                                break;
                            }
                            s.setStudentDetails(sName, sCourse, sgpa, sEmailId);
                            found = true;
                        }
                    }
                    if (!found)
                        System.out.println("Given Student does not exists!");
                    break;

                //? View a record
                case 4:
                    System.out.println("Enter the Id of the student whose details you want.");
                    int sDisplayId = sc.nextInt();
                    found = false;
                    for (StudentRegisteration s : studentList) {
                        if (s.getStudentId() == sDisplayId) {
                            s.getStudentDetails();
                            found = true;
                        }
                    }
                    if (!found)
                        System.out.println("Given Student does not exists!");
                    break;

                //? View all records 
                case 5:
                System.out.println("== == DETAILS OF ALL STUDENTS WHO HAVE REGISTERED FOR PLACEMENT == == ");
                    for (StudentRegisteration s : studentList) {
                        s.getStudentDetails();
                        System.out.println("== == == == ");
                    }
                    break;
                    
                //? Exit
                case 6:
                    System.out.println("All the best for your placement procedure. Good Bye!");
                    break;
                default:
                    System.out.println("You have entered a invalid choice.");
            }
        } while (choice!=6);
        sc.close();
    }
}
