package org.example.View;

import org.example.Model.Medias.*;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.ResourceBundle;

import static org.example.Controller.DataAccess.*;

public class Members extends JFrame {
    private ResourceBundle rm;
    private static Locale locale;
    private List<Media> results;

    private JLabel nameLabel;
    private JTextField titleSearchTB;
    private JButton searchBT;
    private JTextArea resultsRTB;
    private JComboBox<String> typeSearchCB;
    private JButton continueButton;

    public Members(Locale locale) {
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

        nameLabel = new JLabel();
        nameLabel.setBounds(12, 9, 555, 25);
        add(nameLabel);

        titleSearchTB = new JTextField();
        titleSearchTB.setBounds(12, 40, 251, 31);
        add(titleSearchTB);

        searchBT = new JButton();
        searchBT.setBounds(457, 40, 112, 34);
        add(searchBT);

        resultsRTB = new JTextArea();
        resultsRTB.setLineWrap(true);
        resultsRTB.setWrapStyleWord(true);

        JScrollPane scrollPane = new JScrollPane(resultsRTB);
        scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);
        scrollPane.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
        scrollPane.setBounds(50, 108, 709, 276);
        add(scrollPane);

        typeSearchCB = new JComboBox<>();
        typeSearchCB.addItem(rm.getString("book"));
        typeSearchCB.addItem(rm.getString("audiobook"));
        typeSearchCB.addItem(rm.getString("movie"));
        typeSearchCB.addItem(rm.getString("magazine"));
        typeSearchCB.setBounds(269, 40, 182, 33);
        add(typeSearchCB);

        continueButton = new JButton();
        continueButton.setBounds(500, 404, 259, 34);
        continueButton.setEnabled(false);
        add(continueButton);

        setVisible(true);

        searchBT.addActionListener(e -> search());
        continueButton.addActionListener(e -> checkoutContinue());
    }

    private void setText() {
        nameLabel.setText(rm.getString("search_message"));
        searchBT.setText(rm.getString("search"));
        continueButton.setText(rm.getString("checkout_item"));
    }

    private void search() {
        List<Media> medias = new ArrayList<>();
        String searchTitle = titleSearchTB.getText();

        String selectedType = (String) typeSearchCB.getSelectedItem();
        if ("Book".equals(selectedType) || "Livre".equals(selectedType)) {
            List<Book> books = findBooks(searchTitle);
            medias.addAll(books);
        } else if ("Movie".equals(selectedType) || "Film".equals(selectedType)) {
            List<Movie> movie = findMovies(searchTitle);
            medias.addAll(movie);
        } else if ("Audiobook".equals(selectedType) || "Livre audio".equals(selectedType)) {
            List<Audiobook> audiobooks = findAudiobooks(searchTitle);
            medias.addAll(audiobooks);
        } else if ("Magazine".equals(selectedType)) {
            List<Magazine> magazines = findMagazines(searchTitle);
            medias.addAll(magazines);
        }

        resultsRTB.setText(""); // Clear the JTextArea

        for (Media result : medias) {
            if (locale.getLanguage().equals("fr")) {
                resultsRTB.append(result.toStringFR());
            } else {
                resultsRTB.append(result.toString());
            }
        }

        if (!resultsRTB.getText().isEmpty()) {
            continueButton.setEnabled(true);
        } else {
            resultsRTB.append(rm.getString("null_search"));
        }

        results = medias;
    }

    private void checkoutContinue() {
        MembersMedia form = new MembersMedia(locale, results);
        form.setVisible(true);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new Members(locale).setVisible(true));
    }
}

