package org.example;

public class Audiobook extends Media{
    private String ISBN;
    private String author;
    private String publisher;
    private String narrator;
    private int edition;
    private int duration;

    // Set the default max checkout length for Audiobook
    { maxCheckoutLength = 14; }

    public Audiobook(String title, String language, Genre genre, int publicationYear, int ageRestriction,
                     String ISBN, String author, String publisher, String narrator, int edition, int duration) {
        super(title, language, genre, publicationYear, ageRestriction);
        this.ISBN = ISBN;
        this.author = author;
        this.publisher = publisher;
        this.narrator = narrator;
        this.edition = edition;
        this.duration = duration;
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

    public String getNarrator() {
        return narrator;
    }

    public void setNarrator(String narrator) {
        this.narrator = narrator;
    }

    public int getEdition() {
        return edition;
    }

    public void setEdition(int edition) {
        this.edition = edition;
    }

    public int getDuration() {
        return duration;
    }

    public void setDuration(int duration) {
        this.duration = duration;
    }

    @Override
    public void Checkout() {

    }

    @Override
    public void ReturnItem(char ReturnedCondition) {

    }

    @Override
    public void renewLoan() {

    }

    @Override
    public void GiveLateFee() {

    }

}
