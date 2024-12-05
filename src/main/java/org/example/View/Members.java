package org.example.View;

import javax.swing.*;
import java.util.Locale;
import java.util.ResourceBundle;

public class Members extends JFrame {
    private JLabel searchLB;
    private JLabel titleLB;
    private JLabel mediaTypeLB;
    private JTextField titleTB;
    private JTextField mediaTypeTB;
    private JList resultListBox;
    private JButton searchBT;
    private JPanel MembersPanel;
    //private ResourceBundle bundle;



    public Members () {

        //bundle = ResourceBundle.getBundle("org.example.Resources.Resources", Locale.getDefault());
        setContentPane(MembersPanel);
        setTitle("Members Window");
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setSize(650, 500);
        setLocationRelativeTo(null);
        setVisible(true);

    }

//    private void updateText () {
//        titleLB.setText(bundle.getString("title"));
//        mediaTypeLB.setText(bundle.getString("mediaType"));
//        searchBT.setText(bundle.getString("search"));
//    }

    public static void main(String[] args) {
        new Members();
    }
}
