package org.example.Model.Medias;

import org.example.Model.Enums.Genre;

public class Book extends Media {
    private String ISBN;
    private String author;
    private String publisher;
    private String illustrator;
    private int edition;

    // Setting the default max length for book
    { maxCheckoutLength = 21; }

    public Book(String title, String language, Genre genre, int publicationYear, int ageRestriction,
                String ISBN, String author, String publisher, String illustrator, int edition) {
        super(title, language, genre, publicationYear, ageRestriction);
        this.ISBN = ISBN;
        this.author = author;
        this.publisher = publisher;
        this.illustrator = illustrator;
        this.edition = edition;
    }

    public Book(int id, String title, String language, Genre genre, int publicationYear, int ageRestriction,
                String ISBN, String author, String publisher, String illustrator, int edition) {
        super(id, title, language, genre, publicationYear, ageRestriction);
        this.ISBN = ISBN;
        this.author = author;
        this.publisher = publisher;
        this.illustrator = illustrator;
        this.edition = edition;
    }

    public String getISBN() {
        return ISBN;
    }

    public void setISBN(String ISBN) {
        this.ISBN = ISBN;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getPublisher() {
        return publisher;
    }

    public void setPublisher(String publisher) {
        this.publisher = publisher;
    }

    public String getIllustrator() {
        return illustrator;
    }

    public void setIllustrator(String illustrator) {
        this.illustrator = illustrator;
    }

    public int getEdition() {
        return edition;
    }

    public void setEdition(int edition) {
        this.edition = edition;
    }

    @Override
    public void Checkout() {

    }

    @Override
    public void ReturnItem() {

    }

    @Override
    public void renewLoan() {

    }

    @Override
    public void GiveLateFee() {

    }


}
