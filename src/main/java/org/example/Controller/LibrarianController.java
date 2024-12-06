package org.example.Controller;

import org.example.Model.Loan;
import org.example.Model.Medias.Media;
import org.example.Model.Users.Librarian;
import org.example.Model.Users.User;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class LibrarianController {
    private final Librarian librarian;
    private final List<Media> mediaCollection;
    private final List<Loan> loanHistory;

    public LibrarianController(Librarian librarian) {
        this.librarian = librarian;
        this.mediaCollection = new ArrayList<>();
        this.loanHistory = new ArrayList<>();
    }

    // Unified operation handler using a switch case
    public void handleOperation(String operation, Object... params) {
        switch (operation.toLowerCase()) {
            case "viewmemberhistory":
                if (params.length > 0 && params[0] instanceof User) {
                    User member = (User) params[0];
                    List<Loan> memberHistory = viewMemberHistory(member);
                    memberHistory.forEach(loan -> System.out.println("Loan: " + loan.getTitle()));
                } else {
                    System.out.println("Invalid parameters for ViewMemberHistory.");
                }
                break;

            case "viewreport":
                if (params.length > 0 && params[0] instanceof Media) {
                    Media media = (Media) params[0];
                    List<Loan> mediaReport = viewReport(media);
                    mediaReport.forEach(loan -> System.out.println("Loan: " + loan.getTitle()));
                } else {
                    System.out.println("Invalid parameters for ViewReport.");
                }
                break;

            case "addmedia":
                if (params.length > 0 && params[0] instanceof Media) {
                    Media media = (Media) params[0];
                    addMedia(media);
                } else {
                    System.out.println("Invalid parameters for AddMedia.");
                }
                break;

            case "modifymediadetails":
                if (params.length > 0 && params[0] instanceof Media) {
                    Media updatedMedia = (Media) params[0];
                    modifyMediaDetails(updatedMedia);
                } else {
                    System.out.println("Invalid parameters for ModifyMediaDetails.");
                }
                break;

            case "removemedia":
                if (params.length > 0 && params[0] instanceof Media) {
                    Media media = (Media) params[0];
                    removeMedia(media);
                } else {
                    System.out.println("Invalid parameters for RemoveMedia.");
                }
                break;

            case "checkout":
                if (params.length > 1 && params[0] instanceof Media && params[1] instanceof User) {
                    Media media = (Media) params[0];
                    User member = (User) params[1];
                    checkOut(media, member);
                } else {
                    System.out.println("Invalid parameters for CheckOut.");
                }
                break;

            case "givelatefee":
                if (params.length > 0 && params[0] instanceof User) {
                    User member = (User) params[0];
                    giveLateFee(member);
                } else {
                    System.out.println("Invalid parameters for GiveLateFee.");
                }
                break;

            case "listmediacollection":
                listMediaCollection();
                break;

            case "listloanhistory":
                listLoanHistory();
                break;

            default:
                System.out.println("Invalid operation.");
        }
    }

    // Methods for managing loans
    public void checkOut(Media media, User member) {
        if (mediaCollection.contains(media) && !isMediaCheckedOut(media)) {
            Loan loan = new Loan(media, member.getId());
            loanHistory.add(loan);
            System.out.println("Media checked out successfully: " + media.getTitle() + " to Member ID: " + member.getId());
        } else {
            System.out.println("Cannot check out media. Either it is already checked out or not available.");
        }
    }

    private boolean isMediaCheckedOut(Media media) {
        return loanHistory.stream().anyMatch(loan -> loan.getMedia().equals(media) && loan.getExpectedReturnDate().isAfter(LocalDate.now()));
    }

    public void giveLateFee(User member) {
        LocalDate now = LocalDate.now();
        for (Loan loan : loanHistory) {
            if (loan.getUserId() == member.getId() && loan.getExpectedReturnDate().isBefore(now)) {
                Media media = loan.getMedia();
                System.out.println("Late fee applied for media: " + media.getTitle() + " (Member ID: " + member.getId() + ")");
            }
        }
    }

    public List<Loan> viewMemberHistory(User member) {
        List<Loan> memberLoans = new ArrayList<>();
        for (Loan loan : loanHistory) {
            if (loan.getUserId() == member.getId()) {
                memberLoans.add(loan);
            }
        }
        return memberLoans;
    }

    public List<Loan> viewReport(Media media) {
        List<Loan> mediaLoans = new ArrayList<>();
        for (Loan loan : loanHistory) {
            if (loan.getMedia().equals(media)) {
                mediaLoans.add(loan);
            }
        }
        return mediaLoans;
    }

    public boolean addMedia(Media media) {
        if (media != null && !mediaCollection.contains(media)) {
            mediaCollection.add(media);
            System.out.println("Media added successfully: " + media.getTitle());
            return true;
        }
        return false;
    }

    public boolean modifyMediaDetails(Media updatedMedia) {
        for (int i = 0; i < mediaCollection.size(); i++) {
            Media media = mediaCollection.get(i);
            if (media.getId() == updatedMedia.getId()) {
                mediaCollection.set(i, updatedMedia);
                return true;
            }
        }
        return false;
    }

    public boolean removeMedia(Media media) {
        return mediaCollection.remove(media);
    }

    public void listMediaCollection() {
        for (Media media : mediaCollection) {
            System.out.println("Media: " + media.getTitle());
        }
    }

    public void listLoanHistory() {
        for (Loan loan : loanHistory) {
            System.out.println("Loan: " + loan.getTitle() + " to Member ID: " + loan.getUserId());
        }
    }
}
