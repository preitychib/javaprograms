//* Write a GUI application for the students' registration process Student fills out registration forms comprised of first name, middle name, last name, father's name, city, state, email, mobile, DOB, qualification, etc. After form submission, data must be stored in a database table. The application should also have the facility to search and display the submitted forms. Make necessary assumptions, if any. */ 
public class StudentGUIDB {
    public static void main(String[] args) {
        StudentGUIDBController controller = new StudentGUIDBController();
        controller.getConnection();
        controller.closeConnection();
    }
}
