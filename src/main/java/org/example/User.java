package org.example;

import java.time.LocalDate;

public class User {
    protected String fname;
    protected String lname;
    protected int id;
    protected LocalDate dob;
    private static int count = 1;

    private Media[] currentCheckouts;
    private Media[] currentHolds;

    public User(String fname, String lname) {
        this.fname = fname;
        this.lname = lname;
        this.id = count++;
    }

    public String getFname() {
        return fname;
    }

    public void setFname(String fname) {
        this.fname = fname;
    }

    public String getLname() {
        return lname;
    }

    public void setLname(String lname) {
        this.lname = lname;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public LocalDate getDob() {
        return dob;
    }

    public void setDob(LocalDate dob) {
        this.dob = dob;
    }

    public boolean ReturnMedia (Media media) {
        return true;
    }

    public boolean PlaceHold (Media media) {
        return true;
    }

    public Media SearchByGenre (Genre genre) {
        return null;
    }

    public Media SearchByType(String type) {
        return null;
    }

    public Media SearchByTitle (String title) {
        return null;
    }

    public Media SearchByAuthor (String author) {
        return null;
    }

    public Media SearchByIdentifier (String identifier) {
        return null;
    }

    public boolean PayFee (double amount) {
        return true;
    }

    public Loan ViewPersonalHistory() {
        return null;
    }

}
