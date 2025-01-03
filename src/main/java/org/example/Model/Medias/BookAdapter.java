package org.example.Model.Medias;

import org.example.Model.Enums.Genre;
import org.example.Model.Interfaces.MediaAdapter;

public class BookAdapter implements MediaAdapter {
    private final Book book;

    public BookAdapter(Book book) {
        this.book = book;
    }


    @Override
    public String getTitle() {
        return book.getTitle();
    }

    @Override
    public String getLanguage() {
        return book.getLanguage();
    }

    @Override
    public Genre getGenre() {
        return book.getGenre();
    }

    @Override
    public int getPublicationYear() {
        return book.getPublicationYear();
    }

    @Override
    public int getAgeRestriction() {
        return book.getAgeRestriction();
    }

    @Override
    public int getMaxCheckoutLength() {
        return book.getMaxCheckoutLength();
    }

    @Override
    public String getMediaInfo() {
        return "Book ISBN: " + book.getISBN() + ", Author: " + book.getAuthor() + ", Publisher" + book.getPublisher();
    }

    public String getISBN() {
        return book.getISBN();
    }

    public String getAuthor() {
        return book.getAuthor();
    }

    public String getPublisher() {
        return book.getPublisher();
    }

    public String getIllustrator() {
        return book.getIllustrator();
    }

    public int getEdition() {
        return book.getEdition();
    }
}
