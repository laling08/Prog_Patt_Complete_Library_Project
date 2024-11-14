package org.example;

import java.time.LocalDate;

public class Loan {
    private Media mediaType;
    private String title;
    private int userId;
    private int mediaId;
    private LocalDate checkoutDate;
    private LocalDate expectedReturnDate;



    public Loan(Media mediaType, int userId) {
        this.mediaType = mediaType;
        this.title = mediaType.getTitle();
        this.userId = userId;
        this.mediaId = mediaType.hashCode(); // This can be a unique ID generator instead
        this.checkoutDate = LocalDate.now();
        this.expectedReturnDate = checkoutDate.plusDays(mediaType.getMaxCheckoutLength());
    }

    public Media getMediaType() {
        return mediaType;
    }

    public void setMediaType(Media mediaType) {
        this.mediaType = mediaType;
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

    public int getMediaId() {
        return mediaId;
    }

    public void setMediaId(int mediaId) {
        this.mediaId = mediaId;
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
