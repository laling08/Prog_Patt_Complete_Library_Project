package org.example.View;

import org.example.Model.Users.Librarian;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Locale;
import java.util.ResourceBundle;

public class CompleteLibrary extends JFrame {
    private ResourceBundle rm;
    private Locale locale;

    private JButton membersButton;
    private JButton librariansButton;
    private JButton languageButton;
    private JLabel welcomeLB;
    private JPanel CompleteLibraryPanel;

    public CompleteLibrary() {
        locale = new Locale("fr");
        rm = ResourceBundle.getBundle("Resources", locale);
        initializeComponents();
    }

    private void initializeComponents() {
        CompleteLibraryPanel = new JPanel();
        CompleteLibraryPanel.setLayout(null);

        setContentPane(CompleteLibraryPanel);
        setTitle("Complete Library App");
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setSize(500,500);
        setLocationRelativeTo(null);
        setVisible(true);

        welcomeLB = new JLabel(rm.getString("welcome_message"));
        welcomeLB.setBounds(50, 30, 300, 20);
        CompleteLibraryPanel.add(welcomeLB);

        membersButton = new JButton(rm.getString("members"));
        membersButton.setBounds(50, 80, 150, 30);
        CompleteLibraryPanel.add(membersButton);

        librariansButton = new JButton(rm.getString("librarians"));
        librariansButton.setBounds(50, 130, 150, 30);
        CompleteLibraryPanel.add(librariansButton);

        languageButton = new JButton(rm.getString("language"));
        languageButton.setBounds(50, 180, 150, 30);
        CompleteLibraryPanel.add(languageButton);

        Librarian librarian = new Librarian("John", "Doe", java.time.LocalDate.now()); // Example librarian instance

        membersButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                //Members form = new Members(locale);
                //form.setVisible(true);
            }
        });

        librariansButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                Librarians form = new Librarians(librarian, locale);
                form.setVisible(true);
            }
        });

        languageButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                switchLanguage();
            }
        });

        setVisible(true);
    }

    private void switchLanguage() {
        if (locale.equals(new Locale("en", "CA"))) {
            locale = new Locale("fr", "CA");
        } else {
            locale = new Locale("en", "CA");
        }

        rm = ResourceBundle.getBundle("Resources", locale);

        welcomeLB.setText(rm.getString("welcome_message"));
        librariansButton.setText(rm.getString("librarians"));
        membersButton.setText(rm.getString("members"));
        languageButton.setText(rm.getString("language"));

        Locale.setDefault(locale);
    }

    public static void main(String[] args) {
        new CompleteLibrary();
    }
}