package org.example;

import org.example.Controller.DataAccess;
import org.example.Controller.DatabaseSetup;
import org.example.Model.Enums.Genre;
import org.example.Model.Medias.Audiobook;
import org.example.Model.Medias.Book;
import org.example.Model.Medias.Magazine;
import org.example.Model.Medias.Movie;
import org.example.Model.Users.Member;
import org.example.Model.Users.User;
import org.example.View.CompleteLibrary;

import javax.swing.*;

import static org.example.Controller.DataAccess.*;

public class Main {
    /**
     * This is the start of our Complete Library.
     */
    public static void main(String[] args) {
//         DatabaseSetup.createTables();
//         populateDatabase();

//        System.out.println(getAllBooks());
//        System.out.println(getAllMovies());
//        System.out.println(getAllAudiobooks());
//        System.out.println(getAllMagazines());

        javax.swing.SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                createAndShowGUI();
            }
        });
    }

    public static void populateDatabase() {
        Book b1 = new Book("The Great Gatsby", "English", Genre.HISTORICAL_FICTION, 1925, 10, "978-0743273565", "F. Scott Fitzgerald", "Scribner", "", 2);
        Book b2 = new Book("Harry Potter and the Philosopher's Stone", "English", Genre.FANTASY, 1997, 0, "978-0747532699", "J.K. Rowling", "Bloomsbury", "Thomas Taylor", 2);
        Book b3 = new Book("Le petit prince", "Français", Genre.LITERATURE, 1943, 0, "978-0156013987", "Antoine de Saint-Exupéry", "Reynal & Hitchcock", "Antoine de Saint-Exupéry", 3);
        Book b4 = new Book("To Kill a Mockingbird", "English", Genre.HISTORICAL_FICTION, 1960, 8, "987-0061120084", "Harper Lee", "L.B. Lippincott & Co.", "", 1);
        Book b5 = new Book("1984", "English", Genre.SCIENCE_FICTION, 1949, 8, "978-0451524935", "George Orwell", "Secker & Warburg", "", 1);

        Audiobook ab1 = new Audiobook("The Great Gatsby", "English", Genre.HISTORICAL_FICTION, 1925, 10, "978-0743272565", "F. Scott Fitzgerald", "Scribner", "Frank Muller", 1, 320);
        Audiobook ab2 = new Audiobook("Harry Potter and the Philosopher's Stone", "English", Genre.FANTASY, 1997, 0, "978-0747532699", "J.K. Rowling", "Bloomsbury", "Stephen Fry", 1, 534);
        Audiobook ab3 = new Audiobook("Harry Potter and the Half-Blood Prince", "English", Genre.FANTASY, 2005, 0, "978-0439785969", "J.K. Rowling", "Bloomsbury", "Jim Dale", 1, 784);
        Audiobook ab4 = new Audiobook("The Hobbit", "English", Genre.FANTASY, 1937, 8, "978-0547928227", "J.R.R. Tolkien", "George Allen & Unwin", "Rob Inglis", 2, 680);
        Audiobook ab5 = new Audiobook("Atomic Habits", "English", Genre.SELF_HELP, 2018, 14, "978-0735211292", "James Clear", "Penguin Audio", "James Clear", 2, 398);

        Movie mv1 = new Movie("Inception", "English", Genre.SCIENCE_FICTION, 2010, 13, "Christopher Nolan", 148);
        Movie mv2 = new Movie("Parasite", "Korean", Genre.THRILLER, 2019, 18, "Bong Joon-ho", 132);
        Movie mv3 = new Movie("Spirited Away", "Japanese", Genre.ACTION_ADVENTURE, 2001, 0, "Hayao Miyazaki", 125);
        Movie mv4 = new Movie("Schindler's List", "English", Genre.HISTORICAL_FICTION, 1993, 18, "Steven Spielberg", 195);
        Movie mv5 = new Movie("The Matrix", "English", Genre.SCIENCE_FICTION, 1999, 14, "The Wachowskis", 136);

        Magazine m1 = new Magazine("National Geographic", "English", Genre.SCIENCE, 2024, 0, "0027-9358", "National Geographic Partners", "January");
        Magazine m2 = new Magazine("Vogue", "English", Genre.FASHION, 2024, 10, "0027-9358", "Condé Nast", "February");
        Magazine m3 = new Magazine("Time", "English", Genre.NEWS, 2024, 12, "0040-781X", "Time USA, LLC", "March");
        Magazine m4 = new Magazine("Scientific American", "English", Genre.SCIENCE, 2024, 0, "0036-8733", "Springer Nature", "April");
        Magazine m5 = new Magazine("Forbes", "English", Genre.OTHER, 2024, 12, "0015-6914", "Forbes Media", "May");

        addBook(b1);
        addBook(b2);
        addBook(b3);
        addBook(b4);
        addBook(b5);
        addAudiobook(ab1);
        addAudiobook(ab2);
        addAudiobook(ab3);
        addAudiobook(ab4);
        addAudiobook(ab5);
        addMovie(mv1);
        addMovie(mv2);
        addMovie(mv3);
        addMovie(mv4);
        addMovie(mv5);
        addMagazine(m1);
        addMagazine(m2);
        addMagazine(m3);
        addMagazine(m4);
        addMagazine(m5);
    }

    private static void createAndShowGUI() {
        // Create and set up the window.
        CompleteLibrary frame = new CompleteLibrary();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // Display the window.
        frame.setVisible(true);
    }

}