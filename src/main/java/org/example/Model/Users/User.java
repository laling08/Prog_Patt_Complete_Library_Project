package org.example.Model.Users;

import org.example.Model.Enums.Genre;
import org.example.Model.Exceptions.TooYoungException;
import org.example.Model.Hold;
import org.example.Model.Loan;
import org.example.Model.Medias.*;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

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

    /**
     * Helper class used in order to find the person who reserved a
     * piece of media first, so that they get first dibs at checking it out
     * @param mediaId   id of the media so that we can find who has a hold on it
     * @return          the hold of the person who reserved the item first
     */
    private static Hold findFirstReserver(int mediaId) {
        List<Hold> holds = findHold(mediaId);
        Optional<Hold> earliestHold = holds.stream()
                .min((hold1, hold2) -> hold1.getHoldDate().compareTo(hold2.getHoldDate()));
        return earliestHold.orElse(null);
    }

    public boolean checkout(int mediaId, int userId) throws TooYoungException {
        String itemType = findMediaType(mediaId);

        switch (itemType) {
            case "Book":
                Book book = getBook(mediaId);
                if (ChronoUnit.DAYS.between(dob, LocalDateTime.now()) / 365.25 < book.getAgeRestriction()) {
                    throw new TooYoungException();
                } else if (book.getStatus() == "Available") {
                    updateStatus(book, "Checked Out");
                    Loan loan = new Loan(getBook(mediaId), userId);
                    addLoan(loan);
                } else if (book.getStatus() == "Reserved") {
                    Hold hold = findFirstReserver(mediaId);
                    if (hold.getUserId() == userId) {
                        List<Hold> holds = findHold(mediaId);
                        if (holds.size() > 1) {
                            updateStatus(book, "Checked Out and Reserved");
                        } else {
                            updateStatus(book, "Checked Out");
                        }
                        Loan loan = new Loan(getBook(mediaId), userId);
                        addLoan(loan);
                    }
                    removeHold(hold);
                } else {
                    return false;
                }
                break;
            case "Movie":
                Movie movie = getMovie(mediaId);
                if (ChronoUnit.DAYS.between(dob, LocalDateTime.now()) / 365.25 < movie.getAgeRestriction()) {
                    throw new TooYoungException();
                } else if (movie.getStatus() == "Available") {
                    updateStatus(movie, "Checked Out");
                    Loan loan = new Loan(getMovie(mediaId), userId);
                    addLoan(loan);
                } else if (movie.getStatus() == "Reserved") {
                    Hold hold = findFirstReserver(mediaId);
                    if (hold.getUserId() == userId) {
                        List<Hold> holds = findHold(mediaId);
                        if (holds.size() > 1) {
                            updateStatus(movie, "Checked Out and Reserved");
                        } else {
                            updateStatus(movie, "Checked Out");
                        }
                        Loan loan = new Loan(getMovie(mediaId), userId);
                        addLoan(loan);
                    }
                    removeHold(hold);
                } else {
                    return false;
                }
                break;
            case "Audiobook":
                Audiobook audiobook = getAudiobook(mediaId);
                if (ChronoUnit.DAYS.between(dob, LocalDateTime.now()) / 365.25 < audiobook.getAgeRestriction()) {
                    throw new TooYoungException();
                } else if (audiobook.getStatus() == "Available") {
                    updateStatus(audiobook, "Checked Out");
                    Loan loan = new Loan(getAudiobook(mediaId), userId);
                    addLoan(loan);
                } else if (audiobook.getStatus() == "Reserved") {
                    Hold hold = findFirstReserver(mediaId);
                    if (hold.getUserId() == userId) {
                        List<Hold> holds = findHold(mediaId);
                        if (holds.size() > 1) {
                            updateStatus(audiobook, "Checked Out and Reserved");
                        } else {
                            updateStatus(audiobook, "Checked Out");
                        }
                        Loan loan = new Loan(getMovie(mediaId), userId);
                        addLoan(loan);
                    }
                    removeHold(hold);
                } else {
                    return false;
                }
                break;
            case "Magazine":
                Magazine magazine = getMagazine(mediaId);
                if (ChronoUnit.DAYS.between(dob, LocalDateTime.now()) / 365.25 < magazine.getAgeRestriction()) {
                    throw new TooYoungException();
                } else if (magazine.getStatus() == "Available") {
                    updateStatus(magazine, "Checked Out");
                    Loan loan = new Loan(getMagazine(mediaId), userId);
                    addLoan(loan);
                } else if (magazine.getStatus() == "Reserved") {
                    Hold hold = findFirstReserver(mediaId);
                    if (hold.getUserId() == userId) {
                        List<Hold> holds = findHold(mediaId);
                        if (holds.size() > 1) {
                            updateStatus(magazine, "Checked Out and Reserved");
                        } else {
                            updateStatus(magazine, "Checked Out");
                        }
                        Loan loan = new Loan(getMagazine(mediaId), userId);
                        addLoan(loan);
                    }
                    removeHold(hold);
                } else {
                    return false;
                }
                break;
            default:
                return false;
        }

        return true;
    }

    public boolean placeHold(int mediaId, int userId) throws TooYoungException {
        String itemType = findMediaType(mediaId);

        switch (itemType) {
            case "Book":
                Book book = getBook(mediaId);
                if (ChronoUnit.DAYS.between(dob, LocalDateTime.now()) / 365.25 < book.getAgeRestriction()) {
                    throw new TooYoungException();
                } else if (book.getStatus() == "Checked Out" || book.getStatus() == "Reserved" || book.getStatus() == "Checked Out and Reserved") {
                    Hold hold = new Hold(userId, mediaId, LocalDateTime.now());
                    addHold(hold);
                    if (book.getStatus() == "Checked Out") {
                        updateStatus(book, "Checked Out and Reserved");
                    }
                } else {
                    return false;
                }
                break;
            case "Movie":
                Movie movie = getMovie(mediaId);
                if (ChronoUnit.DAYS.between(dob, LocalDateTime.now()) / 365.25 < movie.getAgeRestriction()) {
                    throw new TooYoungException();
                } else if (movie.getStatus() == "Checked Out" || movie.getStatus() == "Reserved" || movie.getStatus() == "Checked Out and Reserved") {
                    Hold hold = new Hold(userId, mediaId, LocalDateTime.now());
                    addHold(hold);
                    if (movie.getStatus() == "Checked Out") {
                        updateStatus(movie, "Checked Out and Reserved");
                    }
                } else {
                    return false;
                }
                break;
            case "Audiobook":
                Audiobook audiobook = getAudiobook(mediaId);
                if (ChronoUnit.DAYS.between(dob, LocalDateTime.now()) / 365.25 < audiobook.getAgeRestriction()) {
                    throw new TooYoungException();
                } else if (audiobook.getStatus() == "Checked Out" || audiobook.getStatus() == "Reserved" || audiobook.getStatus() == "Checked Out and Reserved") {
                    Hold hold = new Hold(userId, mediaId, LocalDateTime.now());
                    addHold(hold);
                    if (audiobook.getStatus() == "Checked Out") {
                        updateStatus(audiobook, "Checked Out and Reserved");
                    }
                } else {
                    return false;
                }
                break;
            case "Magazine":
                Magazine magazine = getMagazine(mediaId);
                if (ChronoUnit.DAYS.between(dob, LocalDateTime.now()) / 365.25 < magazine.getAgeRestriction()) {
                    throw new TooYoungException();
                } else if (magazine.getStatus() == "Checked Out" || magazine.getStatus() == "Reserved" || magazine.getStatus() == "Checked Out and Reserved") {
                    Hold hold = new Hold(userId, mediaId, LocalDateTime.now());
                    addHold(hold);
                    if (magazine.getStatus() == "Checked Out") {
                        updateStatus(magazine, "Checked Out and Reserved");
                    }
                } else {
                    return false;
                }
                break;
            default:
                return false;
        }

        return true;
    }
}
