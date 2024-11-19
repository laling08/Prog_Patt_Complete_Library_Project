package org.example.Controller;

import org.example.Model.Enums.Genre;
import org.example.Model.Medias.*;
import org.example.Model.Users.User;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class DataAccess {

    /**
     * Adds a book to the books table
     * @param book  the book to be added to the database
     */
    public void addBook(Book book) {
        String sql = " INSERT INTO books (book_id, title, language, genre, publication_year, " +
                "age_restriction, status, ISBN, author, publisher, illustrator, edition) VALUES(?,?,?,?,?,?,?,?,?,?,?,?)";

        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setInt(1, book.getId());
            pstmt.setString(2, book.getTitle());
            pstmt.setString(3, book.getLanguage());
            pstmt.setString(4, book.getGenre().name());
            pstmt.setInt(5, book.getPublicationYear());
            pstmt.setInt(6, book.getAgeRestriction());
            pstmt.setString(7, book.getStatus());
            pstmt.setString(8, book.getISBN());
            pstmt.setString(9, book.getAuthor());
            pstmt.setString(10, book.getPublisher());
            pstmt.setString(11, book.getIllustrator());
            pstmt.setInt(12, book.getEdition());

            pstmt.executeUpdate();
            System.out.println("Book data inserted successfully");

            addMedia(book.getId(), "book");
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    /**
     * Adds a movie to the movies table
     * @param movie the movie to be added to the database
     */
    public void addMovie(Movie movie) {
        String sql = " INSERT INTO movies (book_id, title, language, genre, publication_year, " +
                "age_restriction, status, director, duration) VALUES(?,?,?,?,?,?,?,?,?)";

        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setInt(1, movie.getId());
            pstmt.setString(2, movie.getTitle());
            pstmt.setString(3, movie.getLanguage());
            pstmt.setString(4, movie.getGenre().name());
            pstmt.setInt(5, movie.getPublicationYear());
            pstmt.setInt(6, movie.getAgeRestriction());
            pstmt.setString(7, movie.getStatus());
            pstmt.setString(8, movie.getDirector());
            pstmt.setInt(9, movie.getDuration());

            pstmt.executeUpdate();
            System.out.println("Movie data inserted successfully");

            addMedia(movie.getId(), "movie");
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    /**
     * Adds an audiobook to the audiobooks table
     * @param audiobook the audiobook to be added to the database
     */
    public void addAudiobook(Audiobook audiobook) {
        String sql = " INSERT INTO audiobooks (book_id, title, language, genre, publication_year, " +
                "age_restriction, status, ISBN, author, publisher, narrator, edition, duration) VALUES(?,?,?,?,?,?,?,?,?,?,?,?,?)";

        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setInt(1, audiobook.getId());
            pstmt.setString(2, audiobook.getTitle());
            pstmt.setString(3, audiobook.getLanguage());
            pstmt.setString(4, audiobook.getGenre().name());
            pstmt.setInt(5, audiobook.getPublicationYear());
            pstmt.setInt(6, audiobook.getAgeRestriction());
            pstmt.setString(7, audiobook.getStatus());
            pstmt.setString(8, audiobook.getISBN());
            pstmt.setString(9, audiobook.getAuthor());
            pstmt.setString(10, audiobook.getPublisher());
            pstmt.setString(11, audiobook.getNarrator());
            pstmt.setInt(12, audiobook.getEdition());
            pstmt.setInt(13, audiobook.getDuration());

            pstmt.executeUpdate();
            System.out.println("Audiobook data inserted successfully");

            addMedia(audiobook.getId(), "audiobook");
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    /** Adds a magazine to the magazine table
     * @param magazine  the magazine to be added to the database
     */
    public void addMagazine(Magazine magazine) {
        String sql = " INSERT INTO movies (book_id, title, language, genre, publication_year, " +
                "age_restriction, status, ISSN, publisher, publication_month) VALUES(?,?,?,?,?,?,?,?,?,?)";

        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setInt(1, magazine.getId());
            pstmt.setString(2, magazine.getTitle());
            pstmt.setString(3, magazine.getLanguage());
            pstmt.setString(4, magazine.getGenre().name());
            pstmt.setInt(5, magazine.getPublicationYear());
            pstmt.setInt(6, magazine.getAgeRestriction());
            pstmt.setString(7, magazine.getStatus());
            pstmt.setString(8, magazine.getISSN());
            pstmt.setString(9, magazine.getPublisher());
            pstmt.setString(10, magazine.getPublicationMonth());

            pstmt.executeUpdate();
            System.out.println("Magazine data inserted successfully");

            addMedia(magazine.getId(), "magazine");
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    /**
     * Inserts the newly added media types into the media table aswell
     * @param id    the id of the media to be added
     * @param type  the type of the media
     */
    private void addMedia(int id, String type) {
        String sql = " INSERT INTO media (media_id, type) VALUES(?,?)";

        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setInt(1, id);
            pstmt.setString(2, type);

            pstmt.executeUpdate();
            System.out.println("Media data inserted successfully");
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    /**
     * Adds a user (reg. member or librarian) to the users table
     * @param user
     */
    public void addUser(User user) {
        String sql = " INSERT INTO movies (user_id, fname, lname, dob) VALUES(?,?,?,?)";

        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setInt(1, user.getId());
            pstmt.setString(2, user.getFname());
            pstmt.setString(3, user.getLname());
            pstmt.setString(4, user.getDob().toString());

            pstmt.executeUpdate();
            System.out.println("User data inserted successfully");
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    /**
     * Adds the information of a loan to the database
     * @param user  the user wishing to take out the media
     * @param media the media that the user wants to take out
     */
    public void addLoan(User user, Media media) {
        String sql = " INSERT INTO loans (media_id, user_id, type, title, checkout_date, expected_return_date) VALUES(?,?,?,?,?,?)";

        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setInt(1, media.getId());
            pstmt.setInt(2, user.getId());
            pstmt.setString(3, media.getClass().toString());
            pstmt.setString(4, media.getTitle());
            pstmt.setString(5, LocalDate.now().toString());
            pstmt.setString(6, media.calculateReturnDate().toString());

            pstmt.executeUpdate();
            System.out.println("Loan data inserted successfully");
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    /**
     * Updates the date returned of a piece of media to the current day
     * @param userId    the id of the user wishing to return some media
     * @param title     the title of the media that they wish to return
     */
    public void updateReturnedDate(int userId, String title) {
        String sql = " UPDATE loans SET date_returned = ? WHERE user_id = ? AND media_id = ?";

        try (Connection conn = DatabaseConnection.getConnection();
        PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setString(1, LocalDate.now().toString());
            pstmt.setInt(2, userId);
            pstmt.setString(3, title);

            int rowsUpdated = pstmt.executeUpdate();
            if (rowsUpdated > 0) {
                System.out.println("Return date successfully updated");
            } else {
                System.out.println("This piece of media cannot be returned: the user id and title do not match.");
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    /**
     * Updates the loan status of a book (either Available or Borrowed)
     * @param book      the books whose status has changed
     * @param status    the new status of the book
     */
    private void updateStatus(Book book, String status) {
        String sql = " UPDATE books SET status = ? WHERE book_id = ? ";

        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setString(1, status);
            pstmt.setInt(2, book.getId());

            int rowsUpdated = pstmt.executeUpdate();
            if (rowsUpdated > 0) {
                System.out.println("Status successfully updated");
            } else {
                System.out.println("Status cannot be updated");
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    /**
     * Updates the loan status of a movie (either Available or Borrowed)
     * @param movie     the movie whose status has changed
     * @param status    the new status of the movie
     */
    private void updateStatus(Movie movie, String status) {
        String sql = " UPDATE movies SET status = ? WHERE movie_id = ? ";

        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setString(1, status);
            pstmt.setInt(2, movie.getId());

            int rowsUpdated = pstmt.executeUpdate();
            if (rowsUpdated > 0) {
                System.out.println("Status successfully updated");
            } else {
                System.out.println("Status cannot be updated");
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    /**
     * Updates the loan status of a movie (either Available or Borrowed)
     * @param audiobook the movie whose status has changed
     * @param status    the new status of the movie
     */
    private void updateStatus(Audiobook audiobook, String status) {
        String sql = " UPDATE audiobooks SET status = ? WHERE audiobook_id = ? ";

        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setString(1, status);
            pstmt.setInt(2, audiobook.getId());

            int rowsUpdated = pstmt.executeUpdate();
            if (rowsUpdated > 0) {
                System.out.println("Status successfully updated");
            } else {
                System.out.println("Status cannot be updated");
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    /**
     * Updates the loan status of a movie (either Available or Borrowed)
     * @param magazine  the movie whose status has changed
     * @param status    the new status of the movie
     */
    private void updateStatus(Magazine magazine, String status) {
        String sql = " UPDATE magazines SET status = ? WHERE magazine_id = ? ";

        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setString(1, status);
            pstmt.setInt(2, magazine.getId());

            int rowsUpdated = pstmt.executeUpdate();
            if (rowsUpdated > 0) {
                System.out.println("Status successfully updated");
            } else {
                System.out.println("Status cannot be updated");
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    /**
     * Finds and returns a book stored in the database as a Book object
     * @param id    the id of the book to be found
     * @return      the book corresponding to the id
     */
    public Book getBook(int id) {
        Book book = null;
        String sql = "SELECT * FROM books WHERE book_id = ?";

        try (Connection conn = DatabaseConnection.getConnection();
        PreparedStatement pstmt = conn.prepareStatement(sql);
        ResultSet rs = pstmt.executeQuery()) {

            book = new Book(
                    rs.getInt("book_id"),
                    rs.getString("title"),
                    rs.getString("language"),
                    Genre.valueOf(rs.getString("genre")),
                    rs.getInt("publication_year"),
                    rs.getInt("age_restriction"),
                    rs.getString("ISBN"),
                    rs.getString("author"),
                    rs.getString("publisher"),
                    rs.getString("illustrator"),
                    rs.getInt("edition"));

        } catch (SQLException e) {
            System.out.println(e.getMessage());
        } catch (IllegalArgumentException e) {
            System.out.println("The genre is of an incorrect type.");
            System.out.println(e.getMessage());
        }

        return book;
    }

    /**
     * Gets all the books stored in the database
     * @return a list of all the books
     */
    public List<Book> getAllBooks() {
        List<Book> books = new ArrayList<>();
        String sql = " SELECT * FROM books ";

        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql);
             ResultSet rs = pstmt.executeQuery()) {

            while (rs.next()) {
                Book book = new Book(
                        rs.getInt("book_id"),
                        rs.getString("title"),
                        rs.getString("language"),
                        Genre.valueOf(rs.getString("genre")),
                        rs.getInt("publication_year"),
                        rs.getInt("age_restriction"),
                        rs.getString("ISBN"),
                        rs.getString("author"),
                        rs.getString("publisher"),
                        rs.getString("illustrator"),
                        rs.getInt("edition"));
                books.add(book);
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        } catch (IllegalArgumentException e) {
            System.out.println("The genre is of an incorrect type.");
            System.out.println(e.getMessage());
        }

        return books;
    }

    /**
     * Finds and returns a movie stored in the database
     * @param id    the id of the movie to be found
     * @return      the movie from the id
     */
    public Movie getMovie(int id) {
        Movie movie = null;
        String sql = "SELECT * FROM movies WHERE movie_id = ?";

        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql);
             ResultSet rs = pstmt.executeQuery()) {

            movie = new Movie(
                    rs.getInt("movie_id"),
                    rs.getString("title"),
                    rs.getString("language"),
                    Genre.valueOf(rs.getString("genre")),
                    rs.getInt("publication_year"),
                    rs.getInt("age_restriction"),
                    rs.getString("director"),
                    rs.getInt("duration"));

        } catch (SQLException e) {
            System.out.println(e.getMessage());
        } catch (IllegalArgumentException e) {
            System.out.println("The genre is of an incorrect type.");
            System.out.println(e.getMessage());
        }

        return movie;
    }

    /**
     * Gets all the movies stored in the database
     * @return  a list of all the movies
     */
    public List<Movie> getAllMovies() {
        List<Movie> movies = new ArrayList<>();
        String sql = "SELECT * FROM movies";

        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql);
             ResultSet rs = pstmt.executeQuery()) {

            while (rs.next()) {
                Movie movie = new Movie(
                        rs.getInt("movie_id"),
                        rs.getString("title"),
                        rs.getString("language"),
                        Genre.valueOf(rs.getString("genre")),
                        rs.getInt("publication_year"),
                        rs.getInt("age_restriction"),
                        rs.getString("director"),
                        rs.getInt("duration"));
                movies.add(movie);
            }

        } catch (SQLException e) {
            System.out.println(e.getMessage());
        } catch (IllegalArgumentException e) {
            System.out.println("The genre is of an incorrect type.");
            System.out.println(e.getMessage());
        }

        return movies;
    }

    /**
     * Gets all the audiobooks stored in the database
     * @param id    the id of the audiobook to find
     * @return      the audiobook corresponding to the id
     */
    public Audiobook getAudiobook(int id) {
        Audiobook audiobook = null;
        String sql = "SELECT * FROM audiobooks WHERE audiobook_id = ?";

        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql);
             ResultSet rs = pstmt.executeQuery()) {

            audiobook = new Audiobook(
                    rs.getInt("audiobook_id"),
                    rs.getString("title"),
                    rs.getString("language"),
                    Genre.valueOf(rs.getString("genre")),
                    rs.getInt("publication_year"),
                    rs.getInt("age_restriction"),
                    rs.getString("ISBN"),
                    rs.getString("author"),
                    rs.getString("publisher"),
                    rs.getString("narrator"),
                    rs.getInt("edition"),
                    rs.getInt("duration"));

        } catch (SQLException e) {
            System.out.println(e.getMessage());
        } catch (IllegalArgumentException e) {
            System.out.println("The genre is of an incorrect type.");
            System.out.println(e.getMessage());
        }

        return audiobook;
    }

    /**
     * Gets all the audioboks stored in the database
     * @return  a list of all the audiobooks
     */
    public List<Audiobook> getAllAudiobooks() {
        List<Audiobook> audiobooks = new ArrayList<>();
        String sql = "SELECT * FROM audiobooks WHERE audiobook_id = ?";

        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql);
             ResultSet rs = pstmt.executeQuery()) {

            while (rs.next()) {
                Audiobook audiobook = new Audiobook(
                        rs.getInt("audiobook_id"),
                        rs.getString("title"),
                        rs.getString("language"),
                        Genre.valueOf(rs.getString("genre")),
                        rs.getInt("publication_year"),
                        rs.getInt("age_restriction"),
                        rs.getString("ISBN"),
                        rs.getString("author"),
                        rs.getString("publisher"),
                        rs.getString("narrator"),
                        rs.getInt("edition"),
                        rs.getInt("duration"));
                audiobooks.add(audiobook);
            }

        } catch (SQLException e) {
            System.out.println(e.getMessage());
        } catch (IllegalArgumentException e) {
            System.out.println("The genre is of an incorrect type.");
            System.out.println(e.getMessage());
        }

        return audiobooks;
    }

    /**
     * Finds and returns a magazine stored in the database
     * @param id    the id of the magazine to be found
     * @return      the magazine from the id
     */
    public Magazine getMagazine(int id) {
        Magazine magazine = null;
        String sql = "SELECT * FROM magazines WHERE magazine_id = ?";

        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql);
             ResultSet rs = pstmt.executeQuery()) {

            magazine = new Magazine(
                    rs.getInt("magazine_id"),
                    rs.getString("title"),
                    rs.getString("language"),
                    Genre.valueOf(rs.getString("genre")),
                    rs.getInt("publication_year"),
                    rs.getInt("age_restriction"),
                    rs.getString("ISSN"),
                    rs.getString("publisher"),
                    rs.getString("publication_month"));

        } catch (SQLException e) {
            System.out.println(e.getMessage());
        } catch (IllegalArgumentException e) {
            System.out.println("The genre is of an incorrect type.");
            System.out.println(e.getMessage());
        }

        return magazine;
    }

    /**
     * Gets all the magazines stored in the database
     * @return  a list of all the magazines
     */
    public List<Magazine> getAllMagazines() {
        List<Magazine> magazines = new ArrayList<>();
        String sql = "SELECT * FROM magazines";

        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql);
             ResultSet rs = pstmt.executeQuery()) {

            while (rs.next()) {
                Magazine magazine = new Magazine(
                        rs.getInt("magazine_id"),
                        rs.getString("title"),
                        rs.getString("language"),
                        Genre.valueOf(rs.getString("genre")),
                        rs.getInt("publication_year"),
                        rs.getInt("age_restriction"),
                        rs.getString("ISSN"),
                        rs.getString("publisher"),
                        rs.getString("publication_month"));
                magazines.add(magazine);
            }

        } catch (SQLException e) {
            System.out.println(e.getMessage());
        } catch (IllegalArgumentException e) {
            System.out.println("The genre is of an incorrect type.");
            System.out.println(e.getMessage());
        }

        return magazines;
    }
}
