package org.example;

import javax.imageio.stream.ImageInputStream;
import javax.swing.*;

public class Members extends JFrame {
    private JLabel searchLB;
    private JLabel titleLB;
    private JLabel mediaTypeLB;
    private JTextField titleTB;
    private JTextField mediaTypeTB;
    private JList resultListBox;
    private JButton searchBT;
    private JPanel MembersPanel;

    public Members () {

        setContentPane(MembersPanel);
        setTitle("Members Window");
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setSize(650, 500);
        setLocationRelativeTo(null);
        setVisible(true);

    }

    public static void main(String[] args) {
        new Members();
    }
}
