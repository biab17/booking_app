package User;

import Exceptions.BookError;
import java.util.ArrayList;

public class Author extends User {
    // Attributes
    private  final ArrayList<String> booksAuthored;

    // Constructor
    public Author(String email, String password, String full_name, String phone_number) {
        super(email, password, full_name, phone_number);
        this.booksAuthored = new ArrayList<>();
    }

    // Methods
    public void add_book(String book) throws BookError {
        if (booksAuthored.contains(book)) {
            throw new BookError("Book already exists: " + book);
        }
        booksAuthored.add(book);
        System.out.println("Book added: " + book);
    }

    public void renew_stock(String book) throws BookError {
        if (!booksAuthored.contains(book)) {
            throw new BookError("Book not found: " + book);
        }
        System.out.println("Stock renewed for book: " + book);
    }

    public void view_feedback(String book) throws BookError {
        if (!booksAuthored.contains(book)) {
            throw new BookError("Book not found: " + book);
        }
        System.out.println("Viewing feedback for book: " + book);
    }

    public ArrayList<String> getBooksAuthored() {
        return booksAuthored;
    }
}
