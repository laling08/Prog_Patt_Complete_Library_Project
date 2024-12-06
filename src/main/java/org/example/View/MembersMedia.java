package org.example.View;

import org.example.Controller.UserController;
import org.example.Model.Exceptions.TooYoungException;
import org.example.Model.Medias.Media;
import org.example.Model.Users.User;

import javax.swing.*;
import java.awt.event.ActionListener;
import java.util.List;
import java.util.Locale;

import javax.swing.*;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.util.ResourceBundle;

import static org.example.Controller.DataAccess.getUser;

public class MembersMedia extends JFrame {
    private ResourceBundle rm;
    private static Locale locale;
    private static List<Media> results;
    private User member;
    private Media item;

    private JTable queriedMediaLV;
    private JLabel selectLabel;
    private JLabel userIdLabel;
    private JTextField userIdTB;
    private JLabel idErrorLabel;
    private JButton borrowButton;
    private JButton holdButton;
    private JTextArea completedLabel;

    public MembersMedia(Locale locale, List<Media> mediaList) {
        this.locale = locale;
        this.results = mediaList;
        rm = ResourceBundle.getBundle("Resources", locale);
        initializeComponents();
        setText();
    }

    private void initializeComponents() {
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setSize(800, 550);
        setLayout(null);
        setLocationRelativeTo(null);

        // Define columns
        String[] columnNames = {rm.getString("title"), rm.getString("status"), rm.getString("language1"), "ID"};
        DefaultTableModel model = new DefaultTableModel(columnNames, 0);
        queriedMediaLV = new JTable(model);
        queriedMediaLV.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);

        JScrollPane scrollPane = new JScrollPane(queriedMediaLV);
        scrollPane.setBounds(60, 139, 672, 220);
        add(scrollPane);

        selectLabel = new JLabel();
        selectLabel.setBounds(60, 94, 236, 25);
        add(selectLabel);

        userIdLabel = new JLabel();
        userIdLabel.setBounds(60, 45, 149, 25);
        add(userIdLabel);

        userIdTB = new JTextField();
        userIdTB.setBounds(350, 42, 150, 31);
        add(userIdTB);

        idErrorLabel = new JLabel();
        idErrorLabel.setBounds(506, 48, 163, 25);
        idErrorLabel.setVisible(false);
        add(idErrorLabel);

        borrowButton = new JButton();
        borrowButton.setBounds(620, 404, 112, 34);
        borrowButton.setEnabled(false);
        add(borrowButton);

        holdButton = new JButton();
        holdButton.setBounds(407, 404, 178, 34);
        holdButton.setEnabled(false);
        add(holdButton);

        completedLabel = new JTextArea();
        completedLabel.setLineWrap(true);
        completedLabel.setWrapStyleWord(true); // Wrap at word boundaries
        completedLabel.setBounds(60, 362, 150, 50);

        completedLabel.setVisible(false);
        add(completedLabel);

        setVisible(true);

        userIdTB.getDocument().addDocumentListener(new DocumentListener() {
            @Override public void insertUpdate(DocumentEvent e) {
                userIdTextChanged();
            }
            @Override public void removeUpdate(DocumentEvent e) {
                userIdTextChanged();
            }
            @Override public void changedUpdate(DocumentEvent e) {
                userIdTextChanged(); }
        });

        queriedMediaLV.getSelectionModel().addListSelectionListener(new ListSelectionListener() {
            @Override
            public void valueChanged(ListSelectionEvent e) {
                queriedMediaLVSelectionChanged(e);
            }
        });

        borrowButton.addActionListener(e -> borrow());
        holdButton.addActionListener(e -> hold());
    }

    private void setText() {
        userIdLabel.setText(rm.getString("enter_id"));
        idErrorLabel.setText(rm.getString("id_error"));
        selectLabel.setText(rm.getString("select_following"));
        holdButton.setText(rm.getString("hold"));
        borrowButton.setText(rm.getString("borrow"));

        DefaultTableModel model = (DefaultTableModel) queriedMediaLV.getModel();
        model.setRowCount(0);

        for (Media media : results) {
            Object[] rowData = {
                    media.getTitle(),
                    media.getStatus(),
                    media.getLanguage(),
                    media.getId()
            };
            model.addRow(rowData);
        }
    }

    private boolean userIdTextChanged() {
        String id = userIdTB.getText();
        boolean validUserFound = false;
        if (id == null || id.isEmpty()) {
            idErrorLabel.setVisible(true);
            return false;
        }
        for (char c : id.toCharArray()) {
            if (!Character.isDigit(c)) {
                idErrorLabel.setVisible(true);
                return false;
            }
        }
        User user = getUser(Integer.parseInt(id));
        if (user != null) {
            idErrorLabel.setVisible(false);
            member = user;
        }

        updateButtonStates(validUserFound);
        return validUserFound;
    }

    private void queriedMediaLVSelectionChanged(ListSelectionEvent e) {
        if (!e.getValueIsAdjusting() && queriedMediaLV.getSelectedRow() != -1) {
            boolean validUserFound = member != null;
            int selectedIndex = queriedMediaLV.getSelectedRow();
            Media selectedMedia = results.get(selectedIndex);
            item = selectedMedia;

            updateButtonStates(validUserFound);
        }
    }

    private void updateButtonStates(boolean validUserFound) {
        boolean isItemSelected = queriedMediaLV.getSelectedRow() != -1;
        holdButton.setEnabled(isItemSelected && validUserFound);
        borrowButton.setEnabled(isItemSelected && validUserFound);
    }

    private void borrow() {
        UserController controller = new UserController(getUser(Integer.parseInt(userIdTB.getText())));
        try {
            if (controller.checkout(item.getId())) {
                completedLabel.setVisible(true);
                completedLabel.setText(String.format(rm.getString("successful_checkout"), item.getTitle(), item.getMaxCheckoutLength()));
            } else {
                completedLabel.setVisible(true);
                completedLabel.setText(String.format(rm.getString("unsuccessful_checkout"), item.getTitle()));
            }
        } catch (TooYoungException tye) {
            completedLabel.setVisible(true);
            completedLabel.setText(rm.getString("too_young_exception"));
        }
    }

        private void hold() {
            UserController controller = new UserController(member);
            try {
                if (controller.placeHold(item.getId())) {
                    completedLabel.setVisible(true);
                    completedLabel.setText(String.format(rm.getString("successful_hold"), item.getTitle()));
                } else {
                    completedLabel.setVisible(true);
                    completedLabel.setText(String.format(rm.getString("unsuccessful_hold"), item.getTitle()));
                }
            } catch (TooYoungException tye) {
                completedLabel.setVisible(true);
                completedLabel.setText(rm.getString("too_young_exception"));
            }
        }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new MembersMedia(locale, results).setVisible(true));
    }
}

