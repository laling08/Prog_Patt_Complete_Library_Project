package org.example.Model.Users;

import org.example.Model.Enums.Genre;
import org.example.Model.Exceptions.TooYoungException;
import org.example.Model.Hold;
import org.example.Model.Loan;
import org.example.Model.Medias.*;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.example.Controller.DataAccess.*;

public abstract class User {
    protected String fname;
    protected String lname;
    protected int id;
    protected LocalDate dob;
    private static int count = 1;

    public User(String fname, String lname, LocalDate dob) {
        this.fname = fname;
        this.lname = lname;
        this.dob = dob;
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
}
