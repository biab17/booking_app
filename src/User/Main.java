package User;

import Exceptions.*;

public class Main {
    public static void main(String[] args) {
        try {
            // Create instances of User, Author, Administrator, and Client
            User user = new User("user@example.com", "userpassword", "John Doe", "123-456-7890");
            Author author = new Author("author@example.com", "authorpassword", "Jane Austen", "234-567-8901");
            Administrator admin = new Administrator("admin@example.com", "adminpassword", "Alice Admin", "345-678-9012");
            Client client = new Client("client@example.com", "clientpassword", "Bob Client", "456-789-0123");

            // Test User methods
            System.out.println("Testing User methods:");
            user.register();
            user.login("user@example.com", "userpassword");
            user.login("user@example.com", "wrongpassword");

            // Test Author methods
            System.out.println("\nTesting Author methods:");
            author.register();
            author.login("author@example.com", "authorpassword");
            author.add_book("Pride and Prejudice");
            author.renew_stock("Pride and Prejudice");
            author.view_feedback("Pride and Prejudice");

            // Test Administrator methods
            System.out.println("\nTesting Administrator methods:");
            admin.register();
            admin.login("admin@example.com", "adminpassword");
            admin.accept_book_request(author, "Emma");
            admin.deny_book_request(author, "Mansfield Park");
            admin.accept_author_request(author);
            admin.deny_author_request(author);
            admin.accept_order(client, "Order123");
            admin.deny_order(client, "Order456");

            // Test Client methods
            System.out.println("\nTesting Client methods:");
            client.register();
            client.login("client@example.com", "clientpassword");
            client.search_books("Java programming");
            client.get_suggestions();
            client.buy_book("Effective Java");
            client.borrow_book("Clean Code");
            client.return_book("Clean Code");
            client.check_order_history();
            client.send_feedback(author, "Great book!");
        } catch (AuthenticationError | BookError | AdminActionError | OrderError | FeedbackError e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}
