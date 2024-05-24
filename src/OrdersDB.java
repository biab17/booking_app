import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Properties;

public class OrdersDB {

    private final Connection connection;
    private static final String DB_URL = "jdbc:mysql://127.0.0.1:3306/your_database";
    private static final String DB_USER = "root";
    private static final String DB_PASSWORD = "your_password";

    public OrdersDB() throws SQLException {
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

    public void insertOrder(int clientId, int bookId, String orderDate) throws SQLException {
        try (PreparedStatement preparedStatement = connection.prepareStatement(Queries.INSERT_ORDERS_QUERY)) {
            preparedStatement.setInt(1, clientId);
            preparedStatement.setInt(2, bookId);
            preparedStatement.setString(3, orderDate);
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            throw new SQLException("Failed to insert order: " + e.getMessage());
        }
    }
}

