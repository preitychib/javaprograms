//! not tested 
//! requires given database to exit on the server
import java.sql.*;

public class StatementDemo {

    public static void main(String[] args) throws ClassNotFoundException {
        Class.forName("com.mysql.jdbc.Driver");
        //Getting the connection
        String mysqlUrl = "jdbc:mysql://localhost/testdb";
        String user = "sa";
        String password = "";

        try(Connection connection = DriverManager.getConnection(mysqlUrl, user, password)) {
            try(Statement statement = connection.createStatement()){
                String sql = "select * from people";
                try(ResultSet result = statement.executeQuery(sql)){
                    while(result.next()) {
                        System.out.println("Name: "+result.getString("name")+" Age: "+result.getLong("age"));
                    }
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }
}