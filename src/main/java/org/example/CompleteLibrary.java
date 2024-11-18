package org.example;

import javax.swing.*;

public class CompleteLibrary extends JFrame {

    public CompleteLibrary () {

        setTitle ("Complete Library App"); // will be the title of the window
        setDefaultCloseOperation(EXIT_ON_CLOSE); // when you close you window, it will exit your project
        setSize(700, 500);
        setLocationRelativeTo(null); //
        setVisible(true);
    }

    public static void main(String[] args) {
        new CompleteLibrary();
    }
}
