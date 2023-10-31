//* Write down a menu driver program for a student registeration for the placement activity the registeration form consist of student_id, student_name, course and SGPA of the current semester and email_id. Whenever student is registered to an arraylist and if somebody do not want to request for departicipation and his/her name is deleted */

public class StudentRegisteration {
    private int studentId;
    private String studentName;
    private String course;
    private float sgpaCurrentSem;
    private String emailId;
    StudentRegisteration(int sId, String sName, String sCourse, float sgpa, String sEmailId) {
        studentId = sId;
        studentName = sName;
        course = sCourse;
        sgpaCurrentSem = sgpa;
        emailId = sEmailId;
    }
    
    //? updates the student details
    void setStudentDetails(String sName, String sCourse, float sgpa, String sEmailId) {
        studentName = sName;
        course = sCourse;
        sgpaCurrentSem = sgpa;
        emailId = sEmailId;
    }
    
    //? Displays the details of the student
    void getStudentDetails() {
        System.out.println("The Details of the student is:");
        System.out.println("Student Id: "+studentId);
        System.out.println("Student Name: "+studentName);
        System.out.println("Student Course: "+course);
        System.out.println("Student Current Semester SGPA: "+sgpaCurrentSem);
        System.out.println("Student Email: "+emailId);
    }

    //? Returns the id of current student
    public int getStudentId()
    {
        return studentId;
    }
}
