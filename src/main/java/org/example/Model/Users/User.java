package org.example.Model.Users;

import org.example.Model.Enums.Genre;
import org.example.Model.Loan;
import org.example.Model.Medias.*;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import static org.example.Controller.DataAccess.*;

public abstract class User {
    protected String fname;
    protected String lname;
    protected int id;
    protected LocalDate dob;
    private static int count = 1;

    public User(String fname, String lname) {
        this.fname = fname;
        this.lname = lname;
        this.id = count++;
    }

    public String getFname() {
        return fname;
    }

    public void setFname(String fname) {
        this.fname = fname;
    }

    public String getLname() {
        return lname;
    }

    public void setLname(String lname) {
        this.lname = lname;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public LocalDate getDob() {
        return dob;
    }

    public void setDob(LocalDate dob) {
        this.dob = dob;
    }

    public boolean PayFee (double amount) {
        return true;
    }

    public Loan ViewPersonalHistory() {
        return null;
    }

    /**
     * When a user returns an item, it removes it from the user's CurrentCheckouts,
     * updates the item's status, and removes the loan from the loan file.
     * @param mediaId the media item being returned
     * @return true if the return process is successful
     */
    public boolean returnMedia(int mediaId, int userId) {
        returnLoan(userId, mediaId);

        String itemType = findMediaType(mediaId);
        switch (itemType) {
            case "Book":
                Book book = getBook(mediaId);
                if (book.getStatus() == "Checked Out") {
                    updateStatus(book, "Available");
                } else if (book.getStatus() == "Checked Out and Reserved") {
                    updateStatus(book, "Reserved");
                } else {
                    updateStatus(book, "Unknown");
                }
                break;
            case "Movie":
                Movie movie = getMovie(mediaId);
                if (movie.getStatus() == "Checked Out") {
                    updateStatus(movie, "Available");
                } else if (movie.getStatus() == "Checked Out and Reserved") {
                    updateStatus(movie, "Reserved");
                } else {
                    updateStatus(movie, "Unknown");
                }
                break;
            case "Audiobook":
                Audiobook audiobook = getAudiobook(mediaId);
                if (audiobook.getStatus() == "Checked Out") {
                    updateStatus(audiobook, "Available");
                } else if (audiobook.getStatus() == "Checked Out and Reserved") {
                    updateStatus(audiobook, "Reserved");
                } else {
                    updateStatus(audiobook, "Unknown");
                }
                break;
            case "Magazine":
                Magazine magazine = getMagazine(mediaId);
                if (magazine.getStatus() == "Checked Out") {
                    updateStatus(magazine, "Available");
                } else if (magazine.getStatus() == "Checked Out and Reserved") {
                    updateStatus(magazine, "Reserved");
                } else {
                    updateStatus(magazine, "Unknown");
                }
                break;
            default:
                return false;
        }

        return true;
    }
}
