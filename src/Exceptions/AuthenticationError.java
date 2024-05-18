package Exceptions;

public class AuthenticationError extends Exception {
    public AuthenticationError(String message) {
        super(message);
    }
}
