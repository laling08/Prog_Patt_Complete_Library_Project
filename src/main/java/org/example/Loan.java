package org.example;

import java.time.LocalDate;

public class Loan {
    private String mediaType;
    private String title;
    private int userId;
    private int mediaId;
    private LocalDate checkoutDate;
    private LocalDate expectedReturnDate;

    public Loan(Media media, User user) {
        this.mediaType = media.getClass().toString();
        this.title = media.getTitle();
        this.userId = user.getId();
        this.mediaId = media.getId();
        this.checkoutDate = LocalDate.now();
        this.expectedReturnDate = checkoutDate.plusDays(media.getMaxCheckoutLength());
    }

    public Loan(String mediaType, String title, int userId, int mediaId) {
        this.mediaType = mediaType;
        this.title = title;
        this.userId = userId;
        this.mediaId = mediaId;
    }

    public String getMediaType() {
        return mediaType;
    }

    public void setMediaType(String mediaType) {
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
