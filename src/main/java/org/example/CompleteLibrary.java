package org.example;

import javax.swing.*;

public class CompleteLibrary extends JFrame {

    private JLabel welcomeLB;

    public CompleteLibrary () {
        setTitle("Complete Library App"); // this will be the title of the window
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setSize(700,500);
        setLocationRelativeTo(null);
    }

    public static void main(String[] args) {
        new CompleteLibrary();
    }
}
