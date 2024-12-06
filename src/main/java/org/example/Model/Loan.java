package org.example.Model;

import org.example.Model.Medias.Media;

import java.time.LocalDate;

public class Loan {
    private Media media;
    private String title;
    private int userId;
    private LocalDate checkoutDate;
    private LocalDate expectedReturnDate;

    public Loan(Media media, int userId) {
        this.media = media;
        this.title = media.getTitle();
        this.userId = userId;
        this.checkoutDate = LocalDate.now();
        this.expectedReturnDate = checkoutDate.plusDays(media.getMaxCheckoutLength());
    }

    public Media getMedia() {
        return media;
    }

    public void setMedia(Media media) {
        this.media = media;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public LocalDate getCheckoutDate() {
        return checkoutDate;
    }

    public void setCheckoutDate(LocalDate checkoutDate) {
        this.checkoutDate = checkoutDate;
    }

    public LocalDate getExpectedReturnDate() {
        return expectedReturnDate;
    }

    public void setExpectedReturnDate(LocalDate expectedReturnDate) {
        this.expectedReturnDate = expectedReturnDate;
    }

}
