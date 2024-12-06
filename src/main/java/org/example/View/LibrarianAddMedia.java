package org.example.View;

import org.example.Controller.AudiobookController;
import org.example.Controller.BookController;
import org.example.Controller.MagazineController;
import org.example.Controller.MovieController;
import org.example.Model.Enums.Genre;
import org.example.Model.Medias.Audiobook;
import org.example.Model.Medias.Book;
import org.example.Model.Medias.Magazine;
import org.example.Model.Medias.Movie;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;
import java.util.Locale;
import java.util.ResourceBundle;

public class LibrarianAddMedia extends JFrame {
    private ResourceBundle rm;
    private static Locale locale;

    private JPanel LibrarianAddMediaPanel;
    private JPanel mediaTypeGB;
    private JRadioButton magazineRB;
    private JRadioButton audiobookRB;
    private JRadioButton movieRB;
    private JRadioButton bookRB;
    private JLabel titleLabel;
    private JLabel languageLabel;
    private JLabel publicationYearLabel;
    private JLabel ageRestrictionLabel;
    private JComboBox<Genre> genreCB;
    private JTextField titleTB;
    private JTextField languageTB;
    private JTextField publicationYearTB;
    private JTextField ageRestrictionTB;
    private JLabel isbnLabel;
    private JLabel monthLabel;
    private JLabel publisherLabel;
    private JLabel illustratorLabel;
    private JLabel editionLabel;
    private JTextField isbnTB;
    private JTextField monthTB;
    private JTextField publisherTB;
    private JTextField illustratorTB;
    private JTextField editionTB;
    private JLabel narratorLabel;
    private JLabel durationLabel;
    private JLabel directorLabel;
    private JTextField narratorTB;
    private JTextField durationTB;
    private JTextField directorTB;
    private JLabel authorLabel;
    private JTextField authorTB;
    private JButton submitButton;
    private JTextArea errorLabel;

    public LibrarianAddMedia(Locale locale) {
        this.locale = locale;
        rm = ResourceBundle.getBundle("Resources", locale);
        initializeComponents();
        setText();
    }

    private void initializeComponents() {
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setSize(800, 500);
        setLocationRelativeTo(null);
        setLayout(null);

        // MediaType GroupBox
        mediaTypeGB = new JPanel();
        mediaTypeGB.setBorder(BorderFactory.createTitledBorder("Media Type"));
        mediaTypeGB.setLayout(null);
        mediaTypeGB.setBounds(12, 3, 300, 101);
        add(mediaTypeGB);

        // Magazine RadioButton
        magazineRB = new JRadioButton("Magazine");
        magazineRB.setBounds(159, 65, 113, 29);
        mediaTypeGB.add(magazineRB);

        // Audiobook RadioButton
        audiobookRB = new JRadioButton("Audiobook");
        audiobookRB.setBounds(159, 30, 127, 29);
        mediaTypeGB.add(audiobookRB);

        // Movie RadioButton
        movieRB = new JRadioButton("Movie");
        movieRB.setBounds(6, 65, 86, 29);
        mediaTypeGB.add(movieRB);

        // Book RadioButton
        bookRB = new JRadioButton("Book");
        bookRB.setBounds(6, 30, 78, 29);
        mediaTypeGB.add(bookRB);

        // Labels and TextBoxes
        titleLabel = new JLabel("Title");
        titleLabel.setBounds(18, 113, 44, 25);
        add(titleLabel);

        titleTB = new JTextField();
        titleTB.setBounds(206, 107, 150, 31);
        add(titleTB);

        languageLabel = new JLabel("Language");
        languageLabel.setBounds(18, 165, 89, 25);
        add(languageLabel);

        languageTB = new JTextField();
        languageTB.setBounds(206, 159, 150, 31);
        add(languageTB);

        publicationYearLabel = new JLabel("Publication Year");
        publicationYearLabel.setBounds(18, 219, 137, 25);
        add(publicationYearLabel);

        publicationYearTB = new JTextField();
        publicationYearTB.setBounds(206, 213, 150, 31);
        add(publicationYearTB);

        ageRestrictionLabel = new JLabel("Age Restriction");
        ageRestrictionLabel.setBounds(18, 268, 127, 25);
        add(ageRestrictionLabel);

        ageRestrictionTB = new JTextField();
        ageRestrictionTB.setBounds(206, 265, 150, 31);
        add(ageRestrictionTB);

        genreCB = new JComboBox<>();
        genreCB.setBounds(18, 318, 338, 33);
        for (Genre genre : Genre.values()) {
            genreCB.addItem(genre);
        }
        add(genreCB);

        isbnLabel = new JLabel("ISBN");
        isbnLabel.setBounds(383, 261, 95, 25);
        add(isbnLabel);

        isbnTB = new JTextField();
        isbnTB.setEnabled(false);
        isbnTB.setBounds(601, 258, 150, 31);
        add(isbnTB);

        monthLabel = new JLabel("Month");
        monthLabel.setBounds(383, 312, 157, 25);
        monthLabel.setEnabled(false);
        add(monthLabel);

        monthTB = new JTextField();
        monthTB.setEnabled(false);
        monthTB.setBounds(601, 309, 150, 31);
        add(monthTB);

        publisherLabel = new JLabel("Publisher");
        publisherLabel.setBounds(383, 364, 84, 25);
        publisherLabel.setEnabled(false);
        add(publisherLabel);

        publisherTB = new JTextField();
        publisherTB.setEnabled(false);
        publisherTB.setBounds(601, 361, 150, 31);
        add(publisherTB);

        illustratorLabel = new JLabel("Illustrator");
        illustratorLabel.setBounds(383, 417, 150, 25);
        illustratorLabel.setEnabled(false);
        add(illustratorLabel);

        illustratorTB = new JTextField();
        illustratorTB.setEnabled(false);
        illustratorTB.setBounds(601, 414, 150, 31);
        add(illustratorTB);

        editionLabel = new JLabel("Edition");
        editionLabel.setBounds(18, 416, 67, 25);
        editionLabel.setEnabled(false);
        add(editionLabel);

        editionTB = new JTextField();
        editionTB.setEnabled(false);
        editionTB.setBounds(206, 413, 150, 31);
        add(editionTB);

        narratorLabel = new JLabel("Narrator");
        narratorLabel.setBounds(383, 209, 150, 25);
        narratorLabel.setEnabled(false);
        add(narratorLabel);

        narratorTB = new JTextField();
        narratorTB.setEnabled(false);
        narratorTB.setBounds(601, 206, 150, 31);
        add(narratorTB);

        durationLabel = new JLabel("Duration");
        durationLabel.setBounds(383, 162, 81, 25);
        durationLabel.setEnabled(false);
        add(durationLabel);

        durationTB = new JTextField();
        durationTB.setEnabled(false);
        durationTB.setBounds(601, 159, 150, 31);
        add(durationTB);

        directorLabel = new JLabel("Director");
        directorLabel.setBounds(383, 113, 75, 25);
        directorLabel.setEnabled(false);
        add(directorLabel);

        directorTB = new JTextField();
        directorTB.setEnabled(false);
        directorTB.setBounds(601, 110, 150, 31);
        add(directorTB);

        authorLabel = new JLabel("Author");
        authorLabel.setBounds(18, 365, 67, 25);
        authorLabel.setEnabled(false);
        add(authorLabel);

        authorTB = new JTextField();
        authorTB.setEnabled(false);
        authorTB.setBounds(206, 365, 150, 31);
        add(authorTB);

        submitButton = new JButton("Submit");
        submitButton.setBounds(643, 12, 145, 34);
        add(submitButton);

        errorLabel = new JTextArea();
        errorLabel.setLineWrap(true);
        errorLabel.setWrapStyleWord(true);
        errorLabel.setBounds(318, 12, 150, 75);
        errorLabel.setVisible(false);
        add(errorLabel);

        bookRB.addActionListener(e -> bookRBActionPerformed());
        movieRB.addActionListener(e -> movieRBActionPerformed());
        audiobookRB.addActionListener(e -> audiobookRBActionPerformed());
        magazineRB.addActionListener(e -> magazineRBActionPerformed());
        submitButton.addActionListener(e -> submitMedia());
    }

    private void setText() {
        mediaTypeGB.setBorder(BorderFactory.createTitledBorder(rm.getString("media_selection")));
        bookRB.setText(rm.getString("book"));
        movieRB.setText(rm.getString("movie"));
        audiobookRB.setText(rm.getString("audiobook"));
        magazineRB.setText(rm.getString("magazine"));
        submitButton.setText(rm.getString("submit"));

        titleLabel.setText(rm.getString("title"));
        languageLabel.setText(rm.getString("language1"));
        publicationYearLabel.setText(rm.getString("publication_year"));
        ageRestrictionLabel.setText(rm.getString("age_restriction"));
        genreCB.setSelectedItem("Genre");
        authorLabel.setText(rm.getString("author"));
        directorLabel.setText(rm.getString("director"));
        durationLabel.setText(rm.getString("duration"));
        narratorLabel.setText(rm.getString("narrator"));
        isbnLabel.setText("ISBN/ISSN");
        monthLabel.setText(rm.getString("publication_month"));
        publisherLabel.setText(rm.getString("publisher"));
        illustratorLabel.setText(rm.getString("illustrator"));
        editionLabel.setText(rm.getString("edition"));
    }

    private void bookRBActionPerformed() {
        authorLabel.setEnabled(true);
        isbnLabel.setEnabled(true);
        publisherLabel.setEnabled(true);
        illustratorLabel.setEnabled(true);
        editionLabel.setEnabled(true);
        authorTB.setEnabled(true);
        isbnTB.setEnabled(true);
        publisherTB.setEnabled(true);
        illustratorTB.setEnabled(true);
        editionTB.setEnabled(true);

        directorLabel.setEnabled(false);
        durationLabel.setEnabled(false);
        narratorLabel.setEnabled(false);
        monthLabel.setEnabled(false);
        directorTB.setEnabled(false);
        durationTB.setEnabled(false);
        narratorTB.setEnabled(false);
        monthTB.setEnabled(false);
        submitButton.setEnabled(true);
    }

    private void movieRBActionPerformed() {
        durationLabel.setEnabled(true);
        directorLabel.setEnabled(true);
        durationTB.setEnabled(true);
        directorTB.setEnabled(true);

        authorLabel.setEnabled(false);
        isbnLabel.setEnabled(false);
        publisherLabel.setEnabled(false);
        illustratorLabel.setEnabled(false);
        editionLabel.setEnabled(false);
        narratorLabel.setEnabled(false);
        monthLabel.setEnabled(false);
        authorTB.setEnabled(false);
        isbnTB.setEnabled(false);
        publisherTB.setEnabled(false);
        illustratorTB.setEnabled(false);
        editionTB.setEnabled(false);
        narratorTB.setEnabled(false);
        monthTB.setEnabled(false);
    }

    private void audiobookRBActionPerformed() {
        authorLabel.setEnabled(true);
        isbnLabel.setEnabled(true);
        publisherLabel.setEnabled(true);
        editionLabel.setEnabled(true);
        durationLabel.setEnabled(true);
        narratorLabel.setEnabled(true);
        authorTB.setEnabled(true);
        isbnTB.setEnabled(true);
        publisherTB.setEnabled(true);
        editionTB.setEnabled(true);
        durationTB.setEnabled(true);
        narratorTB.setEnabled(true);

        directorLabel.setEnabled(false);
        monthLabel.setEnabled(false);
        illustratorLabel.setEnabled(false);
        directorTB.setEnabled(false);
        monthTB.setEnabled(false);
        illustratorTB.setEnabled(false);
    }

    private void magazineRBActionPerformed() {
        isbnLabel.setEnabled(true);
        publisherLabel.setEnabled(true);
        monthLabel.setEnabled(true);
        isbnTB.setEnabled(true);
        publisherTB.setEnabled(true);
        monthTB.setEnabled(true);

        editionLabel.setEnabled(false);
        durationLabel.setEnabled(false);
        narratorLabel.setEnabled(false);
        authorLabel.setEnabled(false);
        directorLabel.setEnabled(false);
        illustratorLabel.setEnabled(false);
        editionTB.setEnabled(false);
        durationTB.setEnabled(false);
        narratorTB.setEnabled(false);
        authorTB.setEnabled(false);
        directorTB.setEnabled(false);
        illustratorTB.setEnabled(false);
    }

    private void submitMedia() {
        if (bookRB.isSelected()) {
            addBook();
        } else if (movieRB.isSelected()) {
            addMovie();
        } else if (audiobookRB.isSelected()) {
            addAudiobook();
        } else if (magazineRB.isSelected()) {
            addMagazine();
        }
    }

    private void addBook() {
        String title = titleTB.getText();
        String language = languageTB.getText();
        int year;
        int ageRestriction;
        Genre genre;
        String author = authorTB.getText();
        String publisher = publisherTB.getText();
        String isbn = isbnTB.getText();
        String illustrator = illustratorTB.getText();
        int edition;

        if (genreCB.getSelectedItem() == null) {
            genre = Genre.OTHER;
        } else {
            genre = (Genre) genreCB.getSelectedItem();
        }

        try {
            year = Integer.parseInt(publicationYearTB.getText());
            ageRestriction = Integer.parseInt(ageRestrictionTB.getText());
            edition = Integer.parseInt(editionTB.getText());

            BookController bookController = new BookController(new Book(title, language, genre, year, ageRestriction, isbn, author, publisher, illustrator, edition));
            bookController.addBook();
            errorLabel.setText(String.format(rm.getString("media_insert"), bookController.getId()));
            errorLabel.setVisible(true);
        } catch (NumberFormatException e) {
            errorLabel.setText(rm.getString("int_error"));
            errorLabel.setVisible(true);
        }
    }

    private void addMovie() {
        String title = titleTB.getText();
        String language = languageTB.getText();
        int year;
        int ageRestriction;
        Genre genre;
        String director = directorTB.getText();
        int duration;

        if (genreCB.getSelectedItem() == null) {
            genre = Genre.OTHER;
        } else {
            genre = (Genre) genreCB.getSelectedItem();
        }

        try {
            year = Integer.parseInt(publicationYearTB.getText());
            ageRestriction = Integer.parseInt(ageRestrictionTB.getText());
            duration = Integer.parseInt(durationTB.getText());

            MovieController movieController = new MovieController(new Movie(title, language, genre, year, ageRestriction, director, duration));
            movieController.addMovie();
            errorLabel.setText(String.format(rm.getString("media_insert"), movieController.getId()));
            errorLabel.setVisible(true);
        } catch (NumberFormatException e) {
            errorLabel.setText(rm.getString("int_error"));
            errorLabel.setVisible(true);
        }
    }

    private void addAudiobook() {
        String title = titleTB.getText();
        String language = languageTB.getText();
        int year;
        int ageRestriction;
        Genre genre;
        String author = authorTB.getText();
        String publisher = publisherTB.getText();
        String isbn = isbnTB.getText();
        String narrator = narratorTB.getText();
        int duration;
        int edition;

        if (genreCB.getSelectedItem() == null) {
            genre = Genre.OTHER;
        } else {
            genre = (Genre) genreCB.getSelectedItem();
        }

        try {
            year = Integer.parseInt(publicationYearTB.getText());
            ageRestriction = Integer.parseInt(ageRestrictionTB.getText());
            edition = Integer.parseInt(editionTB.getText());
            duration = Integer.parseInt(durationTB.getText());

            AudiobookController audiobookController = new AudiobookController( new Audiobook(title, language, genre, year, ageRestriction, isbn, author, publisher, narrator, edition, duration));
            audiobookController.addAudiobook();
            errorLabel.setText(String.format(rm.getString("media_insert"), audiobookController.getId()));
            errorLabel.setVisible(true);
        } catch (NumberFormatException e) {
            errorLabel.setText(rm.getString("int_error"));
            errorLabel.setVisible(true);
        }
    }

    private void addMagazine() {
        String title = titleTB.getText();
        String language = languageTB.getText();
        int year;
        int ageRestriction;
        Genre genre;
        String issn = isbnTB.getText();
        String publicationMonth = monthTB.getText();
        String publisher = publisherTB.getText();

        if (genreCB.getSelectedItem() == null) {
            genre = Genre.OTHER;
        } else {
            genre = (Genre) genreCB.getSelectedItem();
        }

        try {
            year = Integer.parseInt(publicationYearTB.getText());
            ageRestriction = Integer.parseInt(ageRestrictionTB.getText());

            MagazineController magazineController = new MagazineController(new Magazine(title, language, genre, year, ageRestriction, issn, publisher, publicationMonth));
            magazineController.addMagazine();
            errorLabel.setText(String.format(rm.getString("media_insert"), magazineController.getId()));
            errorLabel.setVisible(true);
        } catch (NumberFormatException e) {
            errorLabel.setText(rm.getString("int_error"));
            errorLabel.setVisible(true);
        }
    }


    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new LibrarianAddMedia(locale).setVisible(true));
    }
}

