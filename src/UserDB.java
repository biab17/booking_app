import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Properties;

public class UserDB {

    private final Connection connection;
    private static final String DB_URL = "jdbc:mysql://127.0.0.1:3306/your_database";
    private static final String DB_USER = "root";
    private static final String DB_PASSWORD = "bubu18";

    public UserDB() throws SQLException {
        Properties properties = new Properties();
        properties.put("user", DB_USER);
        properties.put("password", DB_PASSWORD);
        try {
            connection = DriverManager.getConnection(DB_URL, properties);
        } catch (SQLException e) {
            throw new SQLException("Failed to establish database connection: " + e.getMessage());
        }
    }

    public void closeConnection() {
        if (connection != null) {
            try {
                connection.close();
            } catch (SQLException e) {
                System.err.println("Error while closing database connection: " + e.getMessage());
            }
        }
    }

    public void insertUser(String email, String password, String fullName, String phoneNumber, String userType) throws SQLException {
        try (PreparedStatement preparedStatement = connection.prepareStatement(Queries.INSERT_USERS_QUERY)) {
            preparedStatement.setString(1, email);
            preparedStatement.setString(2, password);
            preparedStatement.setString(3, fullName);
            preparedStatement.setString(4, phoneNumber);
            preparedStatement.setString(5, userType);
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            throw new SQLException("Failed to insert user: " + e.getMessage());
        }
    }
}
