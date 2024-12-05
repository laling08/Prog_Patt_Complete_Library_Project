package org.example.Controller;

import org.example.Model.Medias.Audiobook;

import org.example.Model.Medias.Audiobook;

import java.util.ArrayList;
import java.util.List;

public class AudiobookController {
    private final List<Audiobook> audiobooks;

    public AudiobookController() {
        audiobooks = new ArrayList<>();
    }

    // Add a new audiobook to the library
    public void addAudiobook(Audiobook audiobook) {
        audiobooks.add(audiobook);
        System.out.println("Added audiobook: " + audiobook.getTitle());
    }

    // List all available audiobooks
    public void listAudiobooks() {
        System.out.println("Listing all audiobooks:");
        for (Audiobook audiobook : audiobooks) {
            System.out.println("Title: " + audiobook.getTitle() + ", Author: " + audiobook.getAuthor() + ", ISBN: " + audiobook.getISBN());
        }
    }

    // Find an audiobook by title
    public Audiobook findAudiobookByTitle(String title) {
        for (Audiobook audiobook : audiobooks) {
            if (audiobook.getTitle().equalsIgnoreCase(title)) {
                return audiobook;
            }
        }
        System.out.println("No audiobook found with the title: " + title);
        return null;
    }

    // Check out an audiobook
    public void checkoutAudiobook(String title) {
        Audiobook audiobook = findAudiobookByTitle(title);
        if (audiobook != null) {
            audiobook.Checkout();
        }
    }

    // Return an audiobook
    public void returnAudiobook(String title) {
        Audiobook audiobook = findAudiobookByTitle(title);
        if (audiobook != null) {
            audiobook.ReturnItem();
        }
    }

    // Renew an audiobook
    public void renewAudiobook(String title) {
        Audiobook audiobook = findAudiobookByTitle(title);
        if (audiobook != null) {
            audiobook.renewLoan();
        }
    }

    // Apply a late fee
    public void applyLateFee(String title) {
        Audiobook audiobook = findAudiobookByTitle(title);
        if (audiobook != null) {
            audiobook.GiveLateFee();
        }
    }
}
