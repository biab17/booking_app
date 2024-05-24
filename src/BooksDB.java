import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Properties;

public class BooksDB {

    private final Connection connection;
    private static final String DB_URL = "jdbc:mysql://127.0.0.1:3306/your_database";
    private static final String DB_USER = "root";
    private static final String DB_PASSWORD = "bubu18";

    public BooksDB() throws SQLException {
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

    public void insertBook(String title, int stock, int authorId) throws SQLException {
        try (PreparedStatement preparedStatement = connection.prepareStatement(Queries.INSERT_BOOKS_QUERY)) {
            preparedStatement.setString(1, title);
            preparedStatement.setInt(2, stock);
            preparedStatement.setInt(3, authorId);
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            throw new SQLException("Failed to insert book: " + e.getMessage());
        }
    }
}

