//! not tested 
//! requires given database and procedure to exit on the server

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
public class CallableJDBC {
 
public static void main(String args[]) throws SQLException,ClassNotFoundException {
      //Registering the Driver
      Class.forName("com.mysql.jdbc.Driver");

      //Getting the connection
      String mysqlUrl = "jdbc:mysql://localhost/testdb";
      Connection con = DriverManager.getConnection(mysqlUrl, "root", "password");
      System.out.println("Connection established......");
      //Preparing a CallableStateement
      CallableStatement cstmt = con.prepareCall("{call myProcedure(?, ?, ?)}");

      cstmt.setString(1, "Raghav");
      cstmt.setInt(2, 3000);
      cstmt.setString(3, "Hyderabad");

      cstmt.setString(1, "Kalyan");
      cstmt.setInt(2, 4000);
      cstmt.setString(3, "Vishakhapatnam");

      cstmt.setString(1, "Rukmini");
      cstmt.setInt(2, 5000);
      cstmt.setString(3, "Delhi");

      cstmt.setString(1, "Archana");
      cstmt.setInt(2, 15000);
      cstmt.setString(3, "Mumbai");

      cstmt.execute();
      System.out.println("Rows inserted ....");
   }
}


//? notes

// Connection connection = ...
// try{
//     connection.setAutoCommit(false);


//     Statement statement1 = null;
//     try{
//         statement1 = connection.createStatement();
//         statement1.executeUpdate(
//             "update people set name='John' where id=123");
//     } finally {
//         if(statement1 != null) {
//             statement1.close();
//         }
//     }


//     Statement statement2 = null;
//     try{
//         statement2 = connection.createStatement();
//         statement2.executeUpdate(
//             "update people set name='Gary' where id=456");
//     } finally {
//         if(statement2 != null) {
//             statement2.close();
//         }
//     }

//     connection.commit();
// } catch(Exception e) {
//     connection.rollback();
// } finally {
//     if(connection != null) {
//         connection.close();
//     }
// }


