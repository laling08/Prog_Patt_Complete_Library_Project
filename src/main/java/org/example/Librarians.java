package org.example;

import javax.swing.*;

public class Librarians extends JFrame{
    private JPanel LibrariansPanel;
    private JTextField memberIdTB;
    private JTextField mediaIDTB;
    private JLabel memberIdLB;
    private JLabel mediaIdLB;
    private JButton viewMemHisBT;
    private JButton viewReportBT;
    private JButton addMediaBT;
    private JButton modifyMediaBT;
    private JButton removeMediaBT;
    private JButton issueMediaBT;
    private JLabel introLB;

    private Librarians () {
        setContentPane(LibrariansPanel);
        setTitle("Librarians Window"); // this will be the title of the window
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setSize(500,500);
        setLocationRelativeTo(null);
        setVisible(true);
    }

    public static void main(String[] args) {
        new Librarians();
    }
}
