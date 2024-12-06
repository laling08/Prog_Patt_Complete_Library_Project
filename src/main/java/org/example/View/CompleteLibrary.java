package org.example.View;

import org.example.Model.Users.Librarian;

import javax.swing.*;
import java.awt.*;
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
        locale = new Locale("en");
        rm = ResourceBundle.getBundle("Resources", locale);
        initializeComponents();
    }

    private void initializeComponents() {
        CompleteLibraryPanel = new JPanel(new GridBagLayout());
        GridBagConstraints c = new GridBagConstraints();
        c.insets = new Insets(10, 10, 10, 10);

        setContentPane(CompleteLibraryPanel);
        setTitle("Complete Library App");
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setSize(500,500);
        setLocationRelativeTo(null);
        setVisible(true);

        welcomeLB = new JLabel(rm.getString("welcome_message"));
        c.gridx = 1;
        c.gridy = 1;
        c.gridwidth = 2;
        c.anchor = GridBagConstraints.CENTER;
        //welcomeLB.setBounds(50, 30, 300, 20);
        CompleteLibraryPanel.add(welcomeLB, c);

        membersButton = new JButton(rm.getString("members"));
        c.gridx = 1;
        c.gridy = 2;
        c.gridwidth = 1;
        //membersButton.setBounds(50, 80, 150, 30);
        CompleteLibraryPanel.add(membersButton, c);

        librariansButton = new JButton(rm.getString("librarians"));
        c.gridx = 2;
        c.gridy = 2;
        c.anchor = GridBagConstraints.CENTER;
        //librariansButton.setBounds(50, 130, 150, 30);
        CompleteLibraryPanel.add(librariansButton, c);

        languageButton = new JButton(rm.getString("language"));
        c.gridx = 2;
        c.gridy = 0;
        c.anchor = GridBagConstraints.NORTHEAST;
        //languageButton.setBounds(50, 180, 150, 30);
        CompleteLibraryPanel.add(languageButton, c);

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

                Librarians form = new Librarians(locale);
                form.setVisible(true);
            }
        });

        languageButton.addActionListener(e -> {
            switchLanguage();
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