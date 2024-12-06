package org.example.View;

import org.example.Controller.DataAccess;
import org.example.Controller.LibrarianController;
import org.example.Model.Medias.Media;
import org.example.Model.Users.Librarian;
import org.example.Model.Users.User;

import javax.swing.*;
import java.util.Locale;
import java.util.ResourceBundle;

public class Librarians extends JFrame{
    private JPanel LibrariansPanel;
    private JTextField memberIdTB;
    private JTextField mediaIDTB;
    private JLabel memberIdLB;
    private JLabel mediaIdLB;
    private JButton viewMemHisBT;
    private JButton viewReportBT;
    private JButton addMediaBT;
    private JButton modifyMediaBT;
    private JButton removeMediaBT;
    private JButton issueMediaBT;
    private JLabel introLB;
    private JButton lateFeeBT;

    private final LibrarianController librarianController;
    private final Librarian librarian;

    public Librarians(Librarian librarian, Locale locale) {
        this.librarian = librarian;
        this.librarianController = new LibrarianController(librarian);

        // Initialize components and set locale-based strings
        setContentPane(LibrariansPanel);
        setTitle("Librarians Window");
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setSize(500, 500);
        setLocationRelativeTo(null);
        setVisible(true);

        // Localize components based on the passed locale
        updateLabels(locale);

        // Event Listeners
        viewMemHisBT.addActionListener(e -> viewMemberHistory());
        viewReportBT.addActionListener(e -> viewReport());
        addMediaBT.addActionListener(e -> addMedia());
        modifyMediaBT.addActionListener(e -> modifyMediaDetails());
        removeMediaBT.addActionListener(e -> removeMedia());
        issueMediaBT.addActionListener(e -> checkOutMedia());
        lateFeeBT.addActionListener(e -> giveLateFee());
    }

    private void updateLabels(Locale locale) {
        // Use ResourceBundle or directly set text according to locale
        ResourceBundle rm = ResourceBundle.getBundle("CompleteLibrary_Project.Resources.Resources", locale);

        // Set text for the UI components based on the locale
        introLB.setText(rm.getString("intro_message"));
        viewMemHisBT.setText(rm.getString("view_member_history"));
        viewReportBT.setText(rm.getString("view_report"));
        addMediaBT.setText(rm.getString("add_media"));
        modifyMediaBT.setText(rm.getString("modify_media"));
        removeMediaBT.setText(rm.getString("remove_media"));
        issueMediaBT.setText(rm.getString("issue_media"));
        lateFeeBT.setText(rm.getString("late_fee"));
    }

    private void viewMemberHistory() {
        try {
            int memberId = Integer.parseInt(memberIdTB.getText());
            User member = DataAccess.getUserById(memberId);
            var loans = librarianController.viewMemberHistory(member);
            displayOutput("Member Loan History", loans.toString());
        } catch (Exception ex) {
            showError("Error fetching member history: " + ex.getMessage());
        }
    }

    private void viewReport() {
        try {
            int mediaId = Integer.parseInt(mediaIDTB.getText());
            Media media = DataAccess.getMediaById(mediaId);
            var loans = librarianController.viewReport(media);
            displayOutput("Media Report", loans.toString());
        } catch (Exception ex) {
            showError("Error fetching report: " + ex.getMessage());
        }
    }

    private void addMedia() {
        try {
            Media newMedia = fetchMediaDetailsFromInput();
            boolean success = librarianController.addMedia(newMedia);
            displayOutput("Add Media", success ? "Media added successfully!" : "Failed to add media.");
        } catch (Exception ex) {
            showError("Error adding media: " + ex.getMessage());
        }
    }

    // to be implemented
    private Media fetchMediaDetailsFromInput() {
        return null;
    }

    private void modifyMediaDetails() {
        try {
            Media updatedMedia = fetchMediaDetailsFromInput();
            boolean success = librarianController.modifyMediaDetails(updatedMedia);
            displayOutput("Modify Media", success ? "Media details updated successfully!" : "Failed to update media details.");
        } catch (Exception ex) {
            showError("Error modifying media details: " + ex.getMessage());
        }
    }

    private void removeMedia() {
        try {
            int mediaId = Integer.parseInt(mediaIDTB.getText());
            Media media = DataAccess.getMediaById(mediaId);
            boolean success = librarianController.removeMedia(media);
            displayOutput("Remove Media", success ? "Media removed successfully!" : "Failed to remove media.");
        } catch (Exception ex) {
            showError("Error removing media: " + ex.getMessage());
        }
    }

    private void checkOutMedia() {
        try {
            int memberId = Integer.parseInt(memberIdTB.getText());
            int mediaId = Integer.parseInt(mediaIDTB.getText());
            User member = DataAccess.getUserById(memberId);
            Media media = DataAccess.getMediaById(mediaId);
            librarianController.checkOut(media, member);
            displayOutput("Check Out Media", "Media checked out successfully!");
        } catch (Exception ex) {
            showError("Error during checkout: " + ex.getMessage());
        }
    }

    private void giveLateFee() {
        try {
            int memberId = Integer.parseInt(memberIdTB.getText());
            User member = DataAccess.getUserById(memberId);
            librarianController.giveLateFee(member);
            displayOutput("Give Late Fee", "Late fee applied for overdue items!");
        } catch (Exception ex) {
            showError("Error applying late fee: " + ex.getMessage());
        }
    }

    private void displayOutput(String title, String message) {
        LibrariansOutput outputWindow = new LibrariansOutput();
        outputWindow.setOutput(title, message);
    }

    private void showError(String message) {
        JOptionPane.showMessageDialog(this, message, "Error", JOptionPane.ERROR_MESSAGE);
    }

    public static void main(String[] args) {
        new Librarians(new Librarian("John", "Doe", java.time.LocalDate.now()), new Locale("en", "CA")); // Example librarian instance with locale
    }
}
