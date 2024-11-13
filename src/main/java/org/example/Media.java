package org.example;

import java.util.ArrayList;
import java.util.List;

/**
 * Model for Media Class
 */
public abstract class Media implements Loanable{
    protected int id;
    protected List<Loan> history = new ArrayList<>();
    protected String title;
    protected String language;
    protected Genre genre;
    protected int publicationYear;
    protected int ageRestriction;
    protected int maxCheckoutLength;
    protected int count = 1;
    protected String status;

    public Media(String title, String language, Genre genre, int publicationYear, int ageRestriction) {
        this.title = title;
        this.language = language;
        this.genre = genre;
        this.publicationYear = publicationYear;
        this.ageRestriction = ageRestriction;
        this.status = "Available";
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public List<Loan> getHistory() {
        return history;
    }

    public void setHistory(List<Loan> history) {
        this.history = history;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getLanguage() {
        return language;
    }

    public void setLanguage(String language) {
        this.language = language;
    }

    public Genre getGenre() {
        return genre;
    }

    public void setGenre(Genre genre) {
        this.genre = genre;
    }

    public int getPublicationYear() {
        return publicationYear;
    }

    public void setPublicationYear(int publicationYear) {
        this.publicationYear = publicationYear;
    }

    public int getAgeRestriction() {
        return ageRestriction;
    }

    public void setAgeRestriction(int ageRestriction) {
        this.ageRestriction = ageRestriction;
    }

    public int getMaxCheckoutLength() {
        return maxCheckoutLength;
    }

    public void setMaxCheckoutLength(int maxCheckoutLength) {
        this.maxCheckoutLength = maxCheckoutLength;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
