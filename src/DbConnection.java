import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DbConnection {

    private static final String URL =
        "jdbc:mysql://localhost:3306/student_db?useSSL=false&allowPublicKeyRetrieval=true&serverTimezone=UTC";

    private static final String USER = "root";

    // Put the MySQL root password that you created during installation here
    private static final String PASSWORD = "root123";

    public static Connection getConnection() {

        try {
            Connection connection =
                    DriverManager.getConnection(URL, USER, PASSWORD);

            System.out.println("Database connected successfully!");

            return connection;

        } catch (SQLException e) {

            System.out.println("Database connection failed!");
            System.out.println("Error: " + e.getMessage());

            return null;
        }
    }

    public static void main(String[] args) {

        Connection connection = getConnection();

        if (connection != null) {

            try {
                connection.close();
                System.out.println("Database connection closed.");

            } catch (SQLException e) {
                System.out.println("Error while closing connection.");
            }
        }
    }
}