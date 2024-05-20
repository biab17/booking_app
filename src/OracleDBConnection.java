import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class OracleDBConnection {

    private static final String DB_URL = "jdbc:oracle:thin:@//<hostname>:<port>/<service_name>";
    private static final String DB_USER = "<your_db_username>";
    private static final String DB_PASSWORD = "<your_db_password>";

    public static void main(String[] args) {
        Connection connection = null;
        try {
            // Load Oracle JDBC Driver
            Class.forName("oracle.jdbc.driver.OracleDriver");

            // Connect to the database
            connection = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD);
            System.out.println("Connected to the Oracle database successfully!");

            // Example: Query the USERS table
            String query = "SELECT * FROM USERS";
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            ResultSet resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {
                System.out.println("User ID: " + resultSet.getInt("user_id"));
                System.out.println("Full Name: " + resultSet.getString("full_name"));
                System.out.println("Email: " + resultSet.getString("email"));
                System.out.println("User Type: " + resultSet.getString("user_type"));
                System.out.println("Phone Number: " + resultSet.getString("phone_number"));
                System.out.println("-----");
            }

            resultSet.close();
            preparedStatement.close();
        } catch (ClassNotFoundException e) {
            System.out.println("Oracle JDBC Driver not found. Include the ojdbc8.jar in your classpath.");
            e.printStackTrace();
        } catch (SQLException e) {
            System.out.println("Connection failed!");
            e.printStackTrace();
        } finally {
            if (connection != null) {
                try {
                    connection.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
