package org.example.Model.Exceptions;

public class TooYoungException extends Exception {
    public TooYoungException() {
        super("You borrowing a book that is not appropriate for your age.");
    }

    public TooYoungException(String message) {
        super(message);
    }

}
