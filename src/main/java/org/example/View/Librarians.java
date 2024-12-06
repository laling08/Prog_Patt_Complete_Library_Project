package org.example.View;

import org.example.Controller.DataAccess;
import org.example.Controller.LibrarianController;
import org.example.Controller.UserController;
import org.example.Model.Medias.Media;
import org.example.Model.Users.Librarian;
import org.example.Model.Users.User;
import org.example.Model.Users.UserFactory;

import javax.swing.*;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import java.time.LocalDate;
import java.time.format.DateTimeParseException;
import java.util.Locale;
import java.util.ResourceBundle;

import static org.example.Controller.DataAccess.getUserById;

public class Librarians extends JFrame {
    private ResourceBundle rm;
    private static Locale locale;
    UserFactory userFactory = new UserFactory();

    private JPanel LibrariansPanel;
    private JPanel addNewUserGB;
    private JRadioButton librarianRB;
    private JRadioButton memberRB;
    private JButton addUserButton;
    private JButton returnItemButton;
    private JButton addMediaButton;
    private JLabel fnameLabel;
    private JLabel lnameLabel;
    private JLabel dobLabel;
    private JTextField fnameTB;
    private JTextField lnameTB;
    private JTextField yearTB;
    private JButton userSubmitButton;
    private JTextField dayTB;
    private JTextField monthTB;
    private JLabel returnItemLabel;
    private JLabel userIdLabel;
    private JLabel mediaIdLabel;
    private JTextField userIdTB;
    private JTextField mediaIdTB;
    private JButton returnSubmitButton;
    private JTextArea userErrorLabel;
    private JTextArea returnErrorLabel;

    public Librarians(Locale l) {
        this.locale = l;
        rm = ResourceBundle.getBundle("Resources", locale);
        initializeComponents();
        setText();
    }

    private void initializeComponents() {
        LibrariansPanel = new JPanel();
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setSize(800, 450);
        setLocationRelativeTo(null);
        setLayout(null);

        // AddNewUser GroupBox
        addNewUserGB = new JPanel();
        addNewUserGB.setLayout(null);
        addNewUserGB.setBounds(21, 90, 341, 113);
        addNewUserGB.setVisible(false);
        add(addNewUserGB);

        // Librarian RadioButton
        librarianRB = new JRadioButton();
        librarianRB.setBounds(6, 67, 104, 29);
        librarianRB.setVisible(false);
        addNewUserGB.add(librarianRB);

        // Member RadioButton
        memberRB = new JRadioButton();
        memberRB.setBounds(6, 32, 104, 29);
        memberRB.setVisible(false);
        addNewUserGB.add(memberRB);

        // AddUser Button
        addUserButton = new JButton();
        addUserButton.setBounds(73, 32, 160, 47);
        add(addUserButton);

        // ReturnItem Button
        returnItemButton = new JButton();
        returnItemButton.setBounds(513, 32, 180, 47);
        add(returnItemButton);

        // AddMedia Button
        addMediaButton = new JButton();
        addMediaButton.setBounds(282, 32, 179, 47);
        add(addMediaButton);

        // FirstName Label
        fnameLabel = new JLabel();
        fnameLabel.setBounds(21, 238, 127, 25);
        fnameLabel.setVisible(false);
        add(fnameLabel);

        // LastName Label
        lnameLabel = new JLabel();
        lnameLabel.setBounds(21, 282, 133, 25);
        lnameLabel.setVisible(false);
        add(lnameLabel);

        // DateOfBirth Label
        dobLabel = new JLabel();
        dobLabel.setBounds(21, 325, 172, 25);
        dobLabel.setVisible(false);
        add(dobLabel);

        // FirstName TextBox
        fnameTB = new JTextField();
        fnameTB.setBounds(191, 238, 171, 31);
        fnameTB.setVisible(false);
        add(fnameTB);

        // LastName TextBox
        lnameTB = new JTextField();
        lnameTB.setBounds(191, 278, 171, 31);
        lnameTB.setVisible(false);
        add(lnameTB);

        // Year TextBox
        yearTB = new JTextField();
        yearTB.setBounds(191, 328, 65, 31);
        yearTB.setVisible(false);
        add(yearTB);

        // UserSubmit Button
        userSubmitButton = new JButton();
        userSubmitButton.setBounds(244, 377, 119, 33);
        userSubmitButton.setVisible(false);
        add(userSubmitButton);

        // Day TextBox
        dayTB = new JTextField();
        dayTB.setBounds(316, 328, 47, 31);
        dayTB.setVisible(false);
        add(dayTB);

        // Month TextBox
        monthTB = new JTextField();
        monthTB.setBounds(264, 328, 45, 31);
        monthTB.setVisible(false);
        add(monthTB);

        // ReturnItem Label
        returnItemLabel = new JLabel();
        returnItemLabel.setBounds(464, 90, 100, 50);
        returnItemLabel.setVisible(false);
        add(returnItemLabel);

        // UserID Label
        userIdLabel = new JLabel();
        userIdLabel.setBounds(464, 147, 74, 25);
        userIdLabel.setVisible(false);
        add(userIdLabel);

        // MediaID Label
        mediaIdLabel = new JLabel();
        mediaIdLabel.setBounds(464, 192, 88, 25);
        mediaIdLabel.setVisible(false);
        add(mediaIdLabel);

        // UserID TextBox
        userIdTB = new JTextField();
        userIdTB.setBounds(600, 143, 150, 31);
        userIdTB.setVisible(false);
        add(userIdTB);

        // MediaID TextBox
        mediaIdTB = new JTextField();
        mediaIdTB.setBounds(600, 188, 150, 31);
        mediaIdTB.setVisible(false);
        add(mediaIdTB);

        // ReturnSubmit Button
        returnSubmitButton = new JButton();
        returnSubmitButton.setBounds(639, 238, 111, 33);
        returnSubmitButton.setEnabled(false);
        returnSubmitButton.setVisible(false);
        add(returnSubmitButton);

        // UserError Label
        userErrorLabel = new JTextArea();
        userErrorLabel.setLineWrap(true);
        userErrorLabel.setWrapStyleWord(true);
        userErrorLabel.setEditable(false);
        userErrorLabel.setBounds(21, 382, 100, 50);
        userErrorLabel.setVisible(false);
        add(userErrorLabel);

        // ReturnError Label
        returnErrorLabel = new JTextArea();
        returnErrorLabel.setLineWrap(true);
        returnErrorLabel.setWrapStyleWord(true);
        returnErrorLabel.setEditable(false);
        returnErrorLabel.setBounds(464, 278, 70, 50);
        returnErrorLabel.setVisible(false);
        add(returnErrorLabel);

        addUserButton.addActionListener(e -> showAddUserFields());
        returnItemButton.addActionListener(e -> showReturnItemFields());
        addMediaButton.addActionListener(e -> showMediaForm());

        memberRB.addActionListener(e -> {
            userErrorLabel.setVisible(false);
            validateForm();
        });

        librarianRB.addActionListener(e -> {
            validateForm();
        });

        userSubmitButton.addActionListener(e -> submitNewUser());

        returnSubmitButton.addActionListener(e -> submitReturn());


        DocumentListener textChangedListener = new DocumentListener() {
            @Override
            public void insertUpdate(DocumentEvent e) {
                userErrorLabel.setVisible(false);
                validateForm();
            }

            @Override
            public void removeUpdate(DocumentEvent e) {
                userErrorLabel.setVisible(false);
                validateForm();
            }

            @Override
            public void changedUpdate(DocumentEvent e) {
                userErrorLabel.setVisible(false);
                validateForm();
            }
        };

        fnameTB.getDocument().addDocumentListener(textChangedListener);
        lnameTB.getDocument().addDocumentListener(textChangedListener);
        yearTB.getDocument().addDocumentListener(textChangedListener);
        monthTB.getDocument().addDocumentListener(textChangedListener);
        dayTB.getDocument().addDocumentListener(textChangedListener);

    }

    private void setText() {
        addUserButton.setText(rm.getString("add_user"));
        addMediaButton.setText(rm.getString("add_media"));
        returnItemButton.setText(rm.getString("return_item"));
        //addNewUserGB.setText(rm.getString("add_user"));
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
        dayTB.setVisible(true);
    }

    private void showReturnItemFields() {
        returnItemLabel.setVisible(true);
        userIdLabel.setVisible(true);
        mediaIdLabel.setVisible(true);
        returnSubmitButton.setVisible(true);
        userIdTB.setVisible(true);
        mediaIdTB.setVisible(true);
    }

    private void showMediaForm() {
        LibrarianAddMedia form = new LibrarianAddMedia(locale); // locale
        form.setVisible(true);
    }

    private void validateForm() {
        if (!(fnameTB.getText().trim().isEmpty() && lnameTB.getText().trim().isEmpty() &&
                yearTB.getText().trim().isEmpty() && monthTB.getText().trim().isEmpty() &&
                dayTB.getText().trim().isEmpty())) {
            if (!isDateValid()) {
                userErrorLabel.setVisible(true);
                userErrorLabel.setText(rm.getString("date_error"));
                userSubmitButton.setEnabled(false);
            } else {
                userSubmitButton.setEnabled(true);
            }
        }
    }

    private boolean isDateValid() {
        if (yearTB.getText().trim().isEmpty() ||
                monthTB.getText().trim().isEmpty() ||
                dayTB.getText().trim().isEmpty()) {
            return true;
        }

        try {
            int year = Integer.parseInt(yearTB.getText().trim());
            int month = Integer.parseInt(monthTB.getText().trim());
            int day = Integer.parseInt(dayTB.getText().trim());
            LocalDate.of(year, month, day);
            return true;
        } catch (NumberFormatException | DateTimeParseException e) {
            return false;
        }
    }

    private void submitNewUser() {
            if (memberRB.isSelected()) {
                User member = userFactory.getUser("Member", fnameTB.getText(), lnameTB.getText(),
                        LocalDate.of(Integer.parseInt(yearTB.getText()), Integer.parseInt(monthTB.getText()), Integer.parseInt(dayTB.getText())));

                DataAccess.addUser(member);
                userErrorLabel.setText(String.format(rm.getString("member_add"), member.getId()));
                userErrorLabel.setVisible(true);

            } else {
                User librarian = userFactory.getUser("Librarian", fnameTB.getText(), lnameTB.getText(),
                        LocalDate.of(Integer.parseInt(yearTB.getText()), Integer.parseInt(monthTB.getText()), Integer.parseInt(dayTB.getText())));
                DataAccess.addUser(librarian);
                userErrorLabel.setText(String.format(rm.getString("librarian_add"), librarian.getId()));
                userErrorLabel.setVisible(true);
            }
    }

    private void submitReturn() {
        int userId = Integer.parseInt(userIdTB.getText());
        int mediaId = Integer.parseInt(mediaIdTB.getText());

        UserController controller = new UserController(getUserById(userId));
        boolean mediaReturn = controller.returnMedia(mediaId);

        if (mediaReturn) {
            returnErrorLabel.setText(String.format(rm.getString("return"), mediaId));
        } else {
            returnErrorLabel.setText(String.format(rm.getString("invalid_loan")));
        }

        returnErrorLabel.setVisible(true);
    }


    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new Librarians(locale).setVisible(true));
    }
}
