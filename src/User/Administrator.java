package User;

import Exceptions.AdminActionError;
import Exceptions.BookError;

public class Administrator extends User {

    // Constructor
    public Administrator(String email, String password, String full_name, String phone_number) {
        super(email, password, full_name, phone_number);
    }

    // Methods
    public void accept_book_request(Author author, String book) throws AdminActionError, BookError {
        if (book == null || book.isEmpty()) {
            throw new AdminActionError("Book request is invalid.");
        }
        author.add_book(book);
        System.out.println("Book request accepted: " + book + " by " + author.getFull_name());
    }

    public void deny_book_request(Author author, String book) throws AdminActionError {
        if (book == null || book.isEmpty()) {
            throw new AdminActionError("Book request is invalid.");
        }
        System.out.println("Book request denied: " + book + " by " + author.getFull_name());
    }

    public void accept_author_request(Author author) throws AdminActionError {
        if (author == null) {
            throw new AdminActionError("Author request is invalid.");
        }
        System.out.println("Author request accepted: " + author.getFull_name());
    }

    public void deny_author_request(Author author) throws AdminActionError {
        if (author == null) {
            throw new AdminActionError("Author request is invalid.");
        }
        System.out.println("Author request denied: " + author.getFull_name());
    }

    public void accept_order(Client client, String order) throws AdminActionError {
        if (order == null || order.isEmpty()) {
            throw new AdminActionError("Order request is invalid.");
        }
        client.getOrder_history().add(order);
        System.out.println("Order request accepted: " + order + " by " + client.getFull_name());
    }

    public void deny_order(Client client, String order) throws AdminActionError {
        if (order == null || order.isEmpty()) {
            throw new AdminActionError("Order request is invalid.");
        }
        System.out.println("Order request denied: " + order + " by " + client.getFull_name());
    }
}
