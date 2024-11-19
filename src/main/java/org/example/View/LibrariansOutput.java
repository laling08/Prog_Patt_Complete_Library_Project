package org.example.View;

import javax.swing.*;

public class LibrariansOutput extends JFrame {

    private JPanel OutputPanel;
    private JLabel OutputLB;
    private JTextArea textArea1;

    public LibrariansOutput () {
        setContentPane(OutputPanel);
        setTitle("Librarians Window"); // this will be the title of the window
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setSize(500,500);
        setLocationRelativeTo(null);
        setVisible(true);
    }
}
