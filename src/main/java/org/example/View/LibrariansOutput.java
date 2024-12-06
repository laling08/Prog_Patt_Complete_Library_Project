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

    public void setOutput(String title, String message) {
        // Set the title on the label
        OutputLB.setText(title);

        // Append the message to the JTextArea
        textArea1.setText(message);  // Clear previous message and set new message
        textArea1.setCaretPosition(0);  // Scroll to the top if necessary
    }
}
