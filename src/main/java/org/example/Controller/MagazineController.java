package org.example.Controller;

import org.example.Model.Medias.Magazine;

import java.util.ArrayList;
import java.util.List;

public class MagazineController {
    private final List<Magazine> magazines;

    public MagazineController() {
        magazines = new ArrayList<>();
    }

    // Add a new magazine to the collection
    public void addMagazine(Magazine magazine) {
        magazines.add(magazine);
        System.out.println("Added magazine: " + magazine.getTitle());
    }

    // List all magazines in the collection
    public void listMagazines() {
        System.out.println("Listing all magazines:");
        for (Magazine magazine : magazines) {
            System.out.println("Title: " + magazine.getTitle() + ", ISSN: " + magazine.getISSN() + ", Publisher: " + magazine.getPublisher());
        }
    }

    // Find a magazine by title
    public Magazine findMagazineByTitle(String title) {
        for (Magazine magazine : magazines) {
            if (magazine.getTitle().equalsIgnoreCase(title)) {
                return magazine;
            }
        }
        System.out.println("No magazine found with the title: " + title);
        return null;
    }

    // Check out a magazine
    public void checkoutMagazine(String title) {
        Magazine magazine = findMagazineByTitle(title);
        if (magazine != null) {
            magazine.Checkout();
        }
    }

    // Return a magazine
    public void returnMagazine(String title) {
        Magazine magazine = findMagazineByTitle(title);
        if (magazine != null) {
            magazine.ReturnItem();
        }
    }

    // Renew a magazine loan
    public void renewMagazine(String title) {
        Magazine magazine = findMagazineByTitle(title);
        if (magazine != null) {
            magazine.renewLoan();
        }
    }

    // Apply a late fee to a magazine
    public void applyLateFee(String title) {
        Magazine magazine = findMagazineByTitle(title);
        if (magazine != null) {
            magazine.GiveLateFee();
        }
    }
}
