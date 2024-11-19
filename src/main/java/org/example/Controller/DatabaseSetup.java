package org.example.Controller;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

public class DatabaseSetup {
    public static void createTables() {
        // create tables for media
        createBooksTable();
        createAudiobooksTable();
        createMoviesTable();
        createMagazinesTable();
        createMediaTable();

        // create tables for user
        createUsersTable();
        createLoansTable();
    }

    /**
     * Creates the books table
     */
    private static void createBooksTable() {
        String sql = " CREATE TABLE IF NOT EXISTS books (\n " +
                " book_id INT PRIMARY KEY, \n" +
                " title TEXT NOT NULL, \n" +
                " language TEXT NOT NULL, \n" +
                " genre TEXT NOT NULL, \n" +
                " publication_year INT NOT NULL, \n" +
                " age_restriction INT, \n" +
                " status TEXT NOT NULL, \n" +
                " ISBN TEXT NOT NULL, \n" +
                " author TEXT NOT NULL, \n" +
                " publisher TEXT, \n" +
                " illustrator TEXT, \n" +
                " edition INT NOT NULL \n" +
                " ); ";

        try (Connection conn = DatabaseConnection.getConnection();
             Statement stmt = conn.createStatement()) {
            stmt.execute(sql);
            System.out.println("Books table created successfully");
        } catch (SQLException e) {
            System.out.println("Books table could not be created");
            System.out.println(e.getMessage());
        }
    }

    /**
     * Creates the movies table
     */
    private static void createMoviesTable() {
        String sql = " CREATE TABLE IF NOT EXISTS movies (\n " +
                " movie_id INT PRIMARY KEY, \n" +
                " title TEXT NOT NULL, \n" +
                " language TEXT NOT NULL, \n" +
                " genre TEXT NOT NULL, \n" +
                " publication_year INT NOT NULL, \n" +
                " age_restriction INT, \n" +
                " status TEXT NOT NULL, \n" +
                " director TEXT NOT NULL, \n" +
                " duration INT NOT NULL \n" +
                " ); ";

        try (Connection conn = DatabaseConnection.getConnection();
             Statement stmt = conn.createStatement()) {
            stmt.execute(sql);
            System.out.println("Movies table created successfully");
        } catch (SQLException e) {
            System.out.println("Movies table could not be created");
            System.out.println(e.getMessage());
        }
    }

    /**
     * Creates the audiobooks table
     */
    private static void createAudiobooksTable() {
        String sql = " CREATE TABLE IF NOT EXISTS audiobooks (\n " +
                " audiobook_id INT PRIMARY KEY, \n" +
                " title TEXT NOT NULL, \n" +
                " language TEXT NOT NULL, \n" +
                " genre TEXT NOT NULL, \n" +
                " publication_year INT NOT NULL, \n" +
                " age_restriction INT, \n" +
                " status TEXT NOT NULL, \n" +
                " ISBN TEXT NOT NULL, \n" +
                " author TEXT NOT NULL, \n" +
                " publisher TEXT, \n" +
                " narrator TEXT NOT NULL, \n" +
                " edition INT NOT NULL, \n" +
                " duration INT NOT NULL \n" +
                " ); ";

        try (Connection conn = DatabaseConnection.getConnection();
             Statement stmt = conn.createStatement()) {
            stmt.execute(sql);
            System.out.println("Audiobooks table created successfully");
        } catch (SQLException e) {
            System.out.println("Audiobooks table could not be created");
            System.out.println(e.getMessage());
        }
    }

    /**
     * Creates the magazines table
     */
    private static void createMagazinesTable() {
        String sql = " CREATE TABLE IF NOT EXISTS magazines (\n " +
                " magazine_id INT PRIMARY KEY, \n" +
                " title TEXT NOT NULL, \n" +
                " language TEXT NOT NULL, \n" +
                " genre TEXT NOT NULL, \n" +
                " publication_year INT NOT NULL, \n" +
                " age_restriction INT, \n" +
                " status TEXT NOT NULL, \n" +
                " ISSN TEXT NOT NULL, \n" +
                " publisher TEXT NOT NULL, \n" +
                " publication_month INT NOT NULL \n" +
                " ); ";

        try (Connection conn = DatabaseConnection.getConnection();
             Statement stmt = conn.createStatement()) {
            stmt.execute(sql);
            System.out.println("Magazines table created successfully");
        } catch (SQLException e) {
            System.out.println("Magazines table could not be created");
            System.out.println(e.getMessage());
        }
    }

    /**
     * Creates the users table
     * (represents regular members and librarians)
     */
    private static void createUsersTable() {
        String sql = " CREATE TABLE IF NOT EXISTS users (\n " +
                " user_id INT PRIMARY KEY, \n" +
                " fname TEXT NOT NULL, \n" +
                " lname TEXT NOT NULL, \n" +
                " dob TEXT NOT NULL \n" +
                " ); ";

        try (Connection conn = DatabaseConnection.getConnection();
             Statement stmt = conn.createStatement()) {
            stmt.execute(sql);
            System.out.println("Users table created successfully");
        } catch (SQLException e) {
            System.out.println("Users table could not be created");
            System.out.println(e.getMessage());
        }
    }

    /**
     * Creates the media table
     */
    private static void createMediaTable() {
        String sql = " CREATE TABLE IF NOT EXISTS media (\n " +
                " media_id INT PRIMARY KEY, \n " +
                " type TEXT NOT NULL \n" +
                " ); ";

        try (Connection conn = DatabaseConnection.getConnection();
             Statement stmt = conn.createStatement()) {
            stmt.execute(sql);
            System.out.println("Media table created successfully");
        } catch (SQLException e) {
            System.out.println("Media table could not be created");
            System.out.println(e.getMessage());
        }
    }

    /**
     * Creates the loans table
     * Connects the user to the media that they have borrowed
     * Includes user id, media id, and borrow dates
     */
    private static void createLoansTable() {
        String sql = " CREATE TABLE IF NOT EXISTS loans (\n " +
                " media_id INT NOT NULL, \n " +
                " user_id INT NOT NULL, \n" +
                " type TEXT NOT NULL, \n" +
                " title TEXT NOT NULL, \n" +
                " checkout_date TEXT NOT NULL, \n" +
                " expected_return_date TEXT NOT NULL, \n" +
                " date_returned TEXT, \n " +
                " FOREIGN KEY (media_id) REFERENCES media(media_id), \n" +
                " FOREIGN KEY (user_id) REFERENCES user(user_id) \n" +
                " ); ";

        try (Connection conn = DatabaseConnection.getConnection();
             Statement stmt = conn.createStatement()) {
            stmt.execute(sql);
            System.out.println("Loan table created successfully");
        } catch (SQLException e) {
            System.out.println("Loan table could not be created");
            System.out.println(e.getMessage());
        }
    }
}