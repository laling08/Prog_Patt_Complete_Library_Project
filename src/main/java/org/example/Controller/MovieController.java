package org.example.Controller;

import org.example.Model.Enums.Genre;
import org.example.Model.Exceptions.TooYoungException;
import org.example.Model.Hold;
import org.example.Model.Loan;
import org.example.Model.Medias.Movie;
import org.example.Model.Users.User;

import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;
import java.util.List;
import java.util.Optional;

import static org.example.Controller.DataAccess.*;
import static org.example.Controller.DataAccess.updateStatus;

public class MovieController {
    private Movie model;

    public MovieController(Movie model) {
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

    public String getDirector() {
        return model.getDirector();
    }

    public void setDirector(String director) {
        model.setDirector(director);
    }

    public int getDuration() {
        return model.getDuration();
    }

    public void setDuration(int duration) {
        model.setDuration(duration);
    }

    /**
     * Adds a new movie to the database
     * @param movie  new movie to add to database
     */
    public void addMovie(Movie movie) {
        DataAccess.addMovie(movie);
    }

    /**
     * Lists all the movies stored in the database
     */
    public void listMovies() {
        DataAccess.getAllMovies();
    }

    /**
     * Find a movie with its id
     * @param id    id of movie to find
     * @return      movie with corresponding id
     */
    public Movie findMovie(int id) {
        return DataAccess.getMovie(id);
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
     * Checks out a movie from the library by changing its status,
     * and creating a new loan object
     * @param user  library member who is taking out the movie
     * @return      whether the operation was successful
     * @throws TooYoungException
     */
    public boolean checkoutMovie(User user) throws TooYoungException {
        if (ChronoUnit.DAYS.between(user.getDob(), LocalDateTime.now()) / 365.25 < model.getAgeRestriction()) {
            throw new TooYoungException();
        } else if (model.getStatus() == "Available") {
            updateStatus(model, "Checked Out");
            Loan loan = new Loan(getMovie(getId()), user.getId());
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
                Loan loan = new Loan(getMovie(getId()), user.getId());
                addLoan(loan);
            }
            removeHold(hold);
            return true;
        } else {
            return false;
        }
    }

    /**
     * Returns a movie by changing its status
     * @return whether the operation was successful
     */
    public boolean returnMovie(User user) {
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
     * Places a hold on a movie by changing its status and creating a hold object
     * @param user  user who is checking out the movie
     * @return      whether the operation was successful
     * @throws TooYoungException
     */
    public boolean placeMovieHold(User user) throws TooYoungException {
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
