import java.sql.Connection;

public class StudentGUIDBController {
    StudentGUIDBModel model;

    StudentGUIDBController() {
        model = new StudentGUIDBModel();
    }

    Connection getConnection() {
        Connection connection=null;
        try {
            connection = model.getConnected();
        } catch (InstantiationException | IllegalAccessException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return connection;
    }

    void closeConnection() {
        model.closeConnection();
    }
}
