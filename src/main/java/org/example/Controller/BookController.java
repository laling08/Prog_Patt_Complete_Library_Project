package org.example.Controller;

import org.example.Model.Enums.Genre;
import org.example.Model.Exceptions.TooYoungException;
import org.example.Model.Hold;
import org.example.Model.Loan;
import org.example.Model.Medias.Audiobook;
import org.example.Model.Medias.Book;
import org.example.Model.Users.User;

import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;
import java.util.List;
import java.util.Optional;

import static org.example.Controller.DataAccess.*;
import static org.example.Controller.DataAccess.updateStatus;

public class BookController {
    private Book model;

    public BookController(Book model) {
        this.model = model;
    }

    public int getId() {
        return model.getId();
    }

    public void setTitle(String title) {
        model.setTitle(title);
    }

    public String getTitle() {
        return model.getTitle();
    }

    public void setLanguage(String language) {
        model.setLanguage(language);
    }

    public String getLanguage() {
        return model.getLanguage();
    }

    public Genre getGenre() {
        return model.getGenre();
    }

    public void setGenre(Genre genre) {
        model.setGenre(genre);
    }

    public int getPublicationYear() {
        return model.getPublicationYear();
    }

    public void setPublicationYear(int publicationYear) {
        model.setPublicationYear(publicationYear);
    }

    public int getAgeRestriction() {
        return model.getAgeRestriction();
    }

    public void setAgeRestriction(int ageRestriction) {
        model.setAgeRestriction(ageRestriction);
    }

    public String getISBN() {
        return model.getISBN();
    }

    public void setISBN(String ISBN) {
        model.setISBN(ISBN);
    }

    public String getAuthor() {
        return model.getAuthor();
    }

    public void setAuthor(String author) {
        model.setAuthor(author);
    }

    public String getPublisher() {
        return model.getPublisher();
    }

    public void setPublisher(String publisher) {
        model.setPublisher(publisher);
    }

    public String getIllustrator() {
        return model.getIllustrator();
    }

    public void setIllustrator(String illustrator) {
        model.setIllustrator(illustrator);
    }

    public int getEdition() {
        return model.getEdition();
    }

    public void setEdition(int edition) {
        model.setEdition(edition);
    }

    /**
     * Adds a new book to the database
     * @param book  new book to add to database
     */
    public void addBook(Book book) {
        DataAccess.addBook(book);
    }

    /**
     * Lists all the books stored in the database
     */
    public void listBooks() {
        DataAccess.getAllBooks();
    }

    /**
     * Find a book with its id
     * @param id    id of book to find
     * @return      book with corresponding id
     */
    public Book findBook(int id) {
        return DataAccess.getBook(id);
    }

    /**
     * Helper class used in order to find the person who reserved a
     * piece of media first, so that they get first dibs at checking it out
     * @return  the hold of the person who reserved the item first
     */
    private Hold findFirstReserver() {
        List<Hold> holds = findHold(getId());
        Optional<Hold> earliestHold = holds.stream()
                .min((hold1, hold2) -> hold1.getHoldDate().compareTo(hold2.getHoldDate()));
        return earliestHold.orElse(null);
    }

    /**
     * Checks out a book from the library by changing its status,
     * and creating a new loan object
     * @param user  library member who is taking out the book
     * @return      whether the operation was successful
     * @throws TooYoungException
     */
    public boolean checkoutBook(User user) throws TooYoungException {
        if (ChronoUnit.DAYS.between(user.getDob(), LocalDateTime.now()) / 365.25 < model.getAgeRestriction()) {
            throw new TooYoungException();
        } else if (model.getStatus() == "Available") {
            updateStatus(model, "Checked Out");
            Loan loan = new Loan(getBook(getId()), user.getId());
            addLoan(loan);
            return true;
        } else if (model.getStatus() == "Reserved") {
            Hold hold = findFirstReserver();
            if (hold.getUserId() == user.getId()) {
                List<Hold> holds = findHold(getId());
                if (holds.size() > 1) {
                    updateStatus(model, "Checked Out and Reserved");
                } else {
                    updateStatus(model, "Checked Out");
                }
                Loan loan = new Loan(getBook(getId()), user.getId());
                addLoan(loan);
            }
            removeHold(hold);
            return true;
        } else {
            return false;
        }
    }

    /**
     * Returns a book by changing its status
     * @return whether the operation was successful
     */
    public boolean returnBook(User user) {
        if (model.getStatus() == "Checked Out") {
            updateStatus(model, "Available");
            return true;
        } else if (model.getStatus() == "Checked Out and Reserved") {
            updateStatus(model, "Reserved");
            return true;
        } else {
            updateStatus(model, "Unknown");
            return false;
        }
    }

    /**
     * Places a hold on a book by changing its status and creating a hold object
     * @param user  user who is checking out the movie
     * @return      whether the operation was successful
     * @throws TooYoungException
     */
    public boolean placeBookHold(User user) throws TooYoungException {
        if (ChronoUnit.DAYS.between(user.getDob(), LocalDateTime.now()) / 365.25 < model.getAgeRestriction()) {
            throw new TooYoungException();
        } else if (model.getStatus() == "Checked Out" || model.getStatus() == "Reserved" || model.getStatus() == "Checked Out and Reserved") {
            Hold hold = new Hold(user.getId(), model.getId(), LocalDateTime.now());
            addHold(hold);
            if (model.getStatus() == "Checked Out") {
                updateStatus(model, "Checked Out and Reserved");
            }
            return true;
        } else {
            return false;
        }
    }
}
