package org.example.Controller;

import org.example.Model.Medias.Book;

import java.util.ArrayList;
import java.util.List;

public class BookController {
    private final List<Book> books;

    public BookController() {
        books = new ArrayList<>();
    }

    // Add a new book to the library
    public void addBook(Book book) {
        books.add(book);
        System.out.println("Added book: " + book.getTitle());
    }

    // List all available books
    public void listBooks() {
        System.out.println("Listing all books:");
        for (Book book : books) {
            System.out.println("Title: " + book.getTitle() + ", Author: " + book.getAuthor() + ", ISBN: " + book.getISBN());
        }
    }

    // Find a book by title
    public Book findBookByTitle(String title) {
        for (Book book : books) {
            if (book.getTitle().equalsIgnoreCase(title)) {
                return book;
            }
        }
        System.out.println("No book found with the title: " + title);
        return null;
    }

    // Check out a book
    public void checkoutBook(String title) {
        Book book = findBookByTitle(title);
        if (book != null) {
            book.Checkout();
        }
    }

    // Return a book
    public void returnBook(String title) {
        Book book = findBookByTitle(title);
        if (book != null) {
            book.ReturnItem();
        }
    }

    // Renew a book loan
    public void renewBook(String title) {
        Book book = findBookByTitle(title);
        if (book != null) {
            book.renewLoan();
        }
    }

    // Apply a late fee for a book
    public void applyLateFee(String title) {
        Book book = findBookByTitle(title);
        if (book != null) {
            book.GiveLateFee();
        }
    }
}
