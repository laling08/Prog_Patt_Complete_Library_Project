package org.example.Controller;

import org.example.Model.Medias.Movie;

import java.util.ArrayList;
import java.util.List;

public class MovieController {
    private final List<Movie> movies;

    public MovieController() {
        movies = new ArrayList<>();
    }

    // Add a new movie to the collection
    public void addMovie(Movie movie) {
        movies.add(movie);
        System.out.println("Added movie: " + movie.getTitle());
    }

    // List all movies in the collection
    public void listMovies() {
        System.out.println("Listing all movies:");
        for (Movie movie : movies) {
            System.out.println("Title: " + movie.getTitle() + ", Director: " + movie.getDirector() + ", Duration: " + movie.getDuration() + " minutes");
        }
    }

    // Find a movie by title
    public Movie findMovieByTitle(String title) {
        for (Movie movie : movies) {
            if (movie.getTitle().equalsIgnoreCase(title)) {
                return movie;
            }
        }
        System.out.println("No movie found with the title: " + title);
        return null;
    }

    // Check out a movie
    public void checkoutMovie(String title) {
        Movie movie = findMovieByTitle(title);
        if (movie != null) {
            movie.Checkout();
        }
    }

    // Return a movie
    public void returnMovie(String title) {
        Movie movie = findMovieByTitle(title);
        if (movie != null) {
            movie.ReturnItem();
        }
    }

    // Renew a movie loan
    public void renewMovie(String title) {
        Movie movie = findMovieByTitle(title);
        if (movie != null) {
            movie.renewLoan();
        }
    }

    // Apply a late fee to a movie
    public void applyLateFee(String title) {
        Movie movie = findMovieByTitle(title);
        if (movie != null) {
            movie.GiveLateFee();
        }
    }
}
