//* 13. Write a program to store marks of five courses into a database table. The program takes inputs such as enrolment, marks of 5 courses and store it to a database table using JDBC APIs. Make necessary assumption about the database and tables. */

//! NEEDS Configuration at your end
//! works on my end. hehe 
import java.sql.*;
import java.util.Properties;
import java.util.Scanner;

// import com.mysql.cj.jdbc.Driver;

public class CourseDB {

    static Connection getConnected() throws SQLException {
        Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/student", "admin", "admin");
        System.out.println("Db connected");
        return con;
    }

    static void addStudentMarks() {
        Connection connection = null;
        PreparedStatement statement = null;
        Scanner scanner = new Scanner(System.in);
        try {
            connection = getConnected();
            //? Prepare a statement
            String sql = "INSERT INTO student_marks (enrolment, course1, course2, course3, course4, course5) VALUES (?, ?, ?, ?, ?, ?)";
             statement = connection.prepareStatement(sql);

            //? Input marks for each student
            for (int i = 0; i < 2; i++) {
                System.out.println("Enter details for Student " + (i + 1));
                System.out.print("Enrolment: ");
                int enrolment = scanner.nextInt();

                System.out.print("Course 1 marks: ");
                int course1 = scanner.nextInt();

                System.out.print("Course 2 marks: ");
                int course2 = scanner.nextInt();

                System.out.print("Course 3 marks: ");
                int course3 = scanner.nextInt();

                System.out.print("Course 4 marks: ");
                int course4 = scanner.nextInt();

                System.out.print("Course 5 marks: ");
                int course5 = scanner.nextInt();

                // Set parameters
                statement.setInt(1, enrolment);
                statement.setInt(2, course1);
                statement.setInt(3, course2);
                statement.setInt(4, course3);
                statement.setInt(5, course4);
                statement.setInt(6, course5);

                // Execute the update
                statement.executeUpdate();
            }

            System.out.println("Data inserted successfully!");

        } catch (SQLException    e) {
            e.printStackTrace();
        } finally {
            try {
                if (statement != null)
                    statement.close();
                if (connection != null)
                    connection.close();
            } catch (SQLException se) {
                se.printStackTrace();
            }
        }
        scanner.close();
    }

    public static void main(String[] args) {
        addStudentMarks();
    }
}

// java -cp .:path/file:///home/preity/JDBCFolder/mysql-connector-j-8.2.0/mysql-connector-j-8.2.0.jar Coursejdbc
