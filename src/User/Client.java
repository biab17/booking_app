package User;

import Exceptions.OrderError;
import Exceptions.FeedbackError;
import java.util.ArrayList;

public class Client extends User {
    // Attributes
    private ArrayList<String> order_history;

    // Constructor
    public Client(String email, String password, String full_name, String phone_number) {
        super(email, password, full_name, phone_number);
        this.order_history = new ArrayList<>();
    }

    // Methods
    public void search_books(String query) {
        System.out.println("Searching books for query: " + query);
    }

    public void get_suggestions() {
        System.out.println("Getting book suggestions...");
    }

    public void buy_book(String book) throws OrderError {
        if (book == null || book.isEmpty()) {
            throw new OrderError("Book is out of stock.");
        }
        order_history.add(book);
        System.out.println("Book purchased: " + book);
    }

    public void borrow_book(String book) throws OrderError {
        if (book == null || book.isEmpty()) {
            throw new OrderError("Book is not available for borrowing.");
        }
        System.out.println("Book borrowed: " + book);
    }

    public void return_book(String book) throws OrderError {
        if (!order_history.contains(book)) {
            throw new OrderError("This book was not borrowed by the client.");
        }
        order_history.remove(book);
        System.out.println("Book returned: " + book);
    }

    public void check_order_history() {
        System.out.println("Order History: " + order_history);
    }

    public void send_feedback(Author author, String feedback_message) throws FeedbackError {
        if (!order_history.contains(feedback_message)) {
            throw new FeedbackError("Feedback not valid for this book.");
        }
        System.out.println("Sending feedback to " + author.getFull_name() + ": " + feedback_message);
    }

    public ArrayList<String> getOrder_history() {
        return order_history;
    }
}

