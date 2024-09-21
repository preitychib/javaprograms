import java.io.FileInputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;
// import com.mysql.cj.jdbc.Driver;

public class StudentGUIDBModel {
    Connection con;

    Connection getConnected() throws InstantiationException, IllegalAccessException {
        try (FileInputStream fis = new FileInputStream("connection.prop")) {
            Properties p = new Properties();
            p.load(fis);
            String driverName = (String) p.get("DRIVERNAME");
            String url = (String) p.get("URL");
            String username = (String) p.get("USERNAME");
            String password = (String) p.get("PASSWORD");
            System.out.println("connected with user:" + username);
            // Class.forName(driverName);
            con = DriverManager.getConnection(url, username, password);
            if (con != null) {
                System.out.println("Connection created successfully");

            } else {
                System.out.println("Unable to create connection");
            }
            return con;
        } catch (ClassNotFoundException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return null;
    }

    void closeConnection() {
        try {
            if(con!=null)
                con.close();
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }
}
