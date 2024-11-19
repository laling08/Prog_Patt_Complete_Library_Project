package org.example;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class CompleteLibrary extends JFrame {
    private JLabel welcomeLB;
    private JButton librarianBT;
    private JButton memberBT;
    private JButton compLibLanguageBT;
    private JPanel CompleteLibraryPanel;

    public CompleteLibrary () {

        setContentPane(CompleteLibraryPanel);
        setTitle("Complete Library App"); // this will be the title of the window
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setSize(500,500);
        setLocationRelativeTo(null);
        setVisible(true);

        librarianBT.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // add the even listener here for librarian button
            }
        });
        memberBT.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // add the event listener for member button
            }
        });
        compLibLanguageBT.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // add the event listener for Complete Library Language Button
            }
        });
    }

    public static void main(String[] args) {
        new CompleteLibrary();
    }
}
