package org.example.View;

import org.example.Model.Exceptions.TooYoungException;
import org.example.Model.Users.UserFactory;

import javax.swing.*;
import javax.swing.event.DocumentEvent;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Locale;
import java.util.ResourceBundle;

public class Librarians extends JFrame{

    ResourceBundle rm = ResourceBundle.getBundle("Prog_Patt_Complete_Library_Project.Resources.Resources", Locale.CANADA);
    Locale locale;
    UserFactory userFactory = new UserFactory();

    private JButton addUserButton;
    private JButton addMediaButton;
    private JButton returnItemButton;
    private JButton userSubmitButton;
    private JButton returnSubmitButton;
    private JLabel addNewUserGB;
    private JLabel returnItemLabel;
    private JLabel fnameLabel;
    private JLabel lnameLabel;
    private JLabel dobLabel;
    private JLabel userIdLabel;
    private JLabel mediaIdLabel;
    private JLabel userErrorLabel;
    private JLabel returnErrorLabel;
    private JTextField fnameTB;
    private JTextField lnameTB;
    private JTextField yearTB;
    private JTextField monthTB;
    private JTextField dayTB;
    private JTextField userIdTB;
    private JTextField mediaIdTB;
    private JRadioButton memberRB;
    private JRadioButton librarianRB;

    public Librarians(Locale locale) {
        this.locale = locale;
        initializeComponents();
        setText();
    }

    private void setText() {
        Locale.setDefault(locale);
        rm = ResourceBundle.getBundle("Prog_Patt_Complete_Library_Project.Resources.Resources", locale);

        addUserButton.setText(rm.getString("add_user"));
        addMediaButton.setText(rm.getString("add_media"));
        returnItemButton.setText(rm.getString("return_item"));

        addNewUserGB.setText(rm.getString("add_user"));
        memberRB.setText(rm.getString("member"));
        librarianRB.setText(rm.getString("librarian"));
        fnameLabel.setText(rm.getString("fname"));
        lnameLabel.setText(rm.getString("lname"));
        dobLabel.setText(rm.getString("dob"));
        userSubmitButton.setText(rm.getString("submit"));

        returnItemLabel.setText(rm.getString("return_item"));
        userIdLabel.setText(rm.getString("user_id"));
        mediaIdLabel.setText(rm.getString("media_id"));
        returnSubmitButton.setText(rm.getString("submit"));
    }

    private void initializeComponents() {
        setTitle("Librarians Form");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(400, 400);
        setLayout(null);

        addUserButton = new JButton();
        addUserButton.setBounds(50, 30, 150, 30);
        add(addUserButton);

        addMediaButton = new JButton();
        addMediaButton.setBounds(50, 70, 150, 30);
        add(addMediaButton);

        returnItemButton = new JButton();
        returnItemButton.setBounds(50, 110, 150, 30);
        add(returnItemButton);

        addNewUserGB = new JLabel();
        addNewUserGB.setBounds(50, 150, 200, 20);
        add(addNewUserGB);

        memberRB = new JRadioButton();
        memberRB.setBounds(50, 180, 100, 20);
        add(memberRB);

        librarianRB = new JRadioButton();
        librarianRB.setBounds(150, 180, 100, 20);
        add(librarianRB);

        ButtonGroup group = new ButtonGroup();
        group.add(memberRB);
        group.add(librarianRB);

        fnameLabel = new JLabel();
        fnameLabel.setBounds(50, 210, 100, 20);
        add(fnameLabel);

        fnameTB = new JTextField();
        fnameTB.setBounds(150, 210, 150, 20);
        add(fnameTB);

        lnameLabel = new JLabel();
        lnameLabel.setBounds(50, 240, 100, 20);
        add(lnameLabel);

        lnameTB = new JTextField();
        lnameTB.setBounds(150, 240, 150, 20);
        add(lnameTB);

        dobLabel = new JLabel();
        dobLabel.setBounds(50, 270, 100, 20);
        add(dobLabel);

        yearTB = new JTextField();
        yearTB.setBounds(150, 270, 50, 20);
        add(yearTB);

        monthTB = new JTextField();
        monthTB.setBounds(200, 270, 50, 20);
        add(monthTB);

        dayTB = new JTextField();
        dayTB.setBounds(250, 270, 50, 20);
        add(dayTB);

        userSubmitButton = new JButton();
        userSubmitButton.setBounds(150, 300, 150, 30);
        add(userSubmitButton);

        returnItemLabel = new JLabel();
        returnItemLabel.setBounds(50, 340, 200, 20);
        add(returnItemLabel);

        userIdLabel = new JLabel();
        userIdLabel.setBounds(50, 370, 100, 20);
        add(userIdLabel);

        userIdTB = new JTextField();
        userIdTB.setBounds(150, 370, 150, 20);
        add(userIdTB);

        mediaIdLabel = new JLabel();
        mediaIdLabel.setBounds(50, 400, 100, 20);
        add(mediaIdLabel);

        mediaIdTB = new JTextField();
        mediaIdTB.setBounds(150, 400, 150, 20);
        add(mediaIdTB);

        returnSubmitButton = new JButton();
        returnSubmitButton.setBounds(150, 430, 150, 30);
        add(returnSubmitButton);

        userErrorLabel = new JLabel();
        userErrorLabel.setBounds(50, 460, 300, 20);
        userErrorLabel.setVisible(false);
        add(userErrorLabel);

        returnErrorLabel = new JLabel();
        returnErrorLabel.setBounds(50, 490, 300, 20);
        returnErrorLabel.setVisible(false);
        add(returnErrorLabel);

        addUserButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                showAddUserFields();
            }
        });

        returnItemButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                //showReturnItemFields();
            }
        });

        addMediaButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                //LibrarianAddMedia form = new LibrarianAddMedia(locale);
                LibrarianAddMedia form = new LibrarianAddMedia();
                //form.setVisible(true);
            }
        });

        userSubmitButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    //submitUser();
                    throw new TooYoungException();
                } catch (TooYoungException ex) {
                    userErrorLabel.setText(ex.getMessage());
                    userErrorLabel.setVisible(true);
                }
            }
        });

        returnSubmitButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                //returnItem();
            }
        });

        fnameTB.getDocument().addDocumentListener(new SimpleDocumentListener() {
            @Override
            public void update(DocumentEvent e) {
                userErrorLabel.setVisible(false);
                //validateForm();
            }
        });

        lnameTB.getDocument().addDocumentListener(new SimpleDocumentListener() {
            @Override
            public void update(DocumentEvent e) {
                userErrorLabel.setVisible(false);
                //validateForm();
            }
        });

        yearTB.getDocument().addDocumentListener(new SimpleDocumentListener() {
            @Override
            public void update(DocumentEvent e) {
                userErrorLabel.setVisible(false);
                //validateForm();
            }
        });

        monthTB.getDocument().addDocumentListener(new SimpleDocumentListener() {
            @Override
            public void update(DocumentEvent e) {
                userErrorLabel.setVisible(false);
                //validateForm();
            }
        });

        dayTB.getDocument().addDocumentListener(new SimpleDocumentListener() {
            @Override
            public void update(DocumentEvent e) {
                userErrorLabel.setVisible(false);
                //validateForm();
            }
        });

        userIdTB.getDocument().addDocumentListener(new SimpleDocumentListener() {
            @Override
            public void update(DocumentEvent e) {
                returnErrorLabel.setVisible(false);
                //validateReturnForm();
            }
        });

        mediaIdTB.getDocument().addDocumentListener(new SimpleDocumentListener() {
            @Override
            public void update(DocumentEvent e) {
                returnErrorLabel.setVisible(false);
                //validateReturnForm();
            }
        });

        memberRB.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                userErrorLabel.setVisible(false);
                //validateForm();
            }
        });

        librarianRB.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                //validateForm();
            }
        });

        setVisible(true);
    }

    private void showAddUserFields() {
        addNewUserGB.setVisible(true);
        memberRB.setVisible(true);
        librarianRB.setVisible(true);
        fnameLabel.setVisible(true);
        lnameLabel.setVisible(true);
        dobLabel.setVisible(true);
        userSubmitButton.setVisible(true);
        fnameTB.setVisible(true);
        lnameTB.setVisible(true);
        yearTB.setVisible(true);
        monthTB.setVisible(true);
    }

    private Librarians () {
        //setContentPane(LibrariansPanel);
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
