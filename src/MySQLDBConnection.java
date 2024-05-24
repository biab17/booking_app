import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Properties;

public class MySQLDBConnection {

    private final Connection connection;
    private static final String DB_URL = "jdbc:mysql://localhost:3306/library_schema_bun";
    private static final String DB_USER = "root";
    private static final String DB_PASSWORD = "bubu18";

    public MySQLDBConnection() throws SQLException {
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

    public Connection getConnection() {
        return connection;
    }

    /*public void executeUpdate(String query) throws SQLException {
        try (PreparedStatement preparedStatement = connection.prepareStatement(Queries)) {
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            throw new SQLException("Failed to execute update: " + e.getMessage());
        }
    }*/
}


