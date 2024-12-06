package org.example.Model.Medias;

import org.example.Model.Enums.Genre;

public class Audiobook extends Media {
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

    public Audiobook(int id, String title, String language, Genre genre, int publicationYear, int ageRestriction,
                     String ISBN, String author, String publisher, String narrator, int edition, int duration) {
        super(id, title, language, genre, publicationYear, ageRestriction);
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
    public String toString() {
        String baseToString = super.toString();

        return String.format("AUDIOBOOK\n%sISBN:\t\t\t%s\nAuthor:\t\t\t%s\nPublisher:\t\t\t%s\nNarrator:\t\t\t%s\nEdition:\t\t\t%d\nDuration:\t\t\t%s\n",
                baseToString, ISBN, author, publisher, narrator, edition, duration);
    }

    public String toStringFR() {
        String baseToString = super.toStringFR();

        return String.format("LIVREAUDIO\n%sISBN:\t\t%s\nAuteur(e):\t\t%s\nMaison d'édition:\t%s\nNarrateur/Narratrice:\t%s\nÉdition:\t\t%d\nLongueur:\t\t%s\n",
                baseToString, ISBN, author, publisher, narrator, edition, duration);
    }
}
