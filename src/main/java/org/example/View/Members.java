package org.example.View;

import org.example.Model.Medias.Media;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.ResourceBundle;
import java.util.stream.Collectors;

public class Members extends JFrame {

    ResourceBundle rm = ResourceBundle.getBundle("CompleteLibrary_Project.Resources.Resources", Locale.CANADA);
    Locale locale;
    List<Media> results;
    private JComboBox<String> typeSearchCB;
    private JTextField titleSearchTB;
    private JTextArea resultsRTB;
    private JButton searchBT;
    private JButton continueButton;

    public Members(Locale locale) {
        this.locale = locale;
        initializeComponents();
        setText();
        addTypeSearchItems();
    }

    private void setText() {
        Locale.setDefault(locale);
        rm = ResourceBundle.getBundle("Prog_Patt_Complete_Library_Project.Resources.Resources", locale);

        setTitle(rm.getString("search_message"));
        searchBT.setText(rm.getString("search"));
        continueButton.setText(rm.getString("checkout_item"));
    }

    private void initializeComponents() {
        setTitle("Members Search Form");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(400, 400);
        setLayout(null);

        typeSearchCB = new JComboBox<>();
        typeSearchCB.setBounds(50, 30, 150, 30);
        add(typeSearchCB);

        titleSearchTB = new JTextField();
        titleSearchTB.setBounds(50, 70, 150, 30);
        add(titleSearchTB);

        searchBT = new JButton();
        searchBT.setBounds(50, 110, 150, 30);
        add(searchBT);

        resultsRTB = new JTextArea();
        resultsRTB.setBounds(50, 150, 300, 150);
        add(resultsRTB);

        continueButton = new JButton();
        continueButton.setBounds(50, 310, 150, 30);
        continueButton.setEnabled(false);
        add(continueButton);

        searchBT.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                searchMedia();
            }
        });

        continueButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                openMembersMediaForm();
            }
        });

        setVisible(true);
    }

    private void addTypeSearchItems() {
        typeSearchCB.addItem(rm.getString("book"));
        typeSearchCB.addItem(rm.getString("audiobook"));
        typeSearchCB.addItem(rm.getString("movie"));
        typeSearchCB.addItem(rm.getString("magazine"));
    }

    private void searchMedia() {
//        List<Media> medias = new ArrayList<>();
//
//        String selectedType = typeSearchCB.getSelectedItem().toString();
//        if (selectedType.equals(rm.getString("book"))) {
//            medias.addAll(DataAccess.loadAllBooks());
//        } else if (selectedType.equals(rm.getString("movie"))) {
//            medias.addAll(DataAccess.loadAllMovies());
//        } else if (selectedType.equals(rm.getString("audiobook"))) {
//            medias.addAll(DataAccess.loadAllAudiobooks());
//        } else if (selectedType.equals(rm.getString("magazine"))) {
//            medias.addAll(DataAccess.loadAllMagazines());
//        } else {
//            medias.addAll(DataAccess.loadAllBooks());
//        }
//
//        resultsRTB.setText("");
//
//        String query = titleSearchTB.getText().toLowerCase();
//        results = medias.stream()
//                .filter(item -> item.getTitle().toLowerCase().contains(query))
//                .collect(Collectors.toList());
//
//        for (Media result : results) {
//            if (locale.getLanguage().equals("fr")) {
//                resultsRTB.append(result.toStringFR());
//            } else {
//                resultsRTB.append(result.toString());
//            }
//        }
//
//        if (!resultsRTB.getText().isEmpty()) {
//            continueButton.setEnabled(true);
//        } else {
//            resultsRTB.append(rm.getString("null_search"));
//        }
    }

    private void openMembersMediaForm() {
        //MembersMedia form = new MembersMedia(locale, results);
        MembersMedia form = new MembersMedia();
        //form.setVisible(true);
    }

    public static void main(String[] args) {
        new Members(Locale.CANADA);
    }
}
