package org.example.Model.Users;

import org.example.Model.Loan;
import org.example.Model.Medias.Media;

import java.time.LocalDate;

public class Librarian extends User {

    public Librarian(String fname, String lname, LocalDate dob) {
        super(fname, lname, dob);
    }

    public Librarian(int id, String fname, String lname, LocalDate dob) {
        super(id, fname, lname, dob);
    }

    public Media ViewMemberHistory (User member) {
        return null;
    }

    public Loan ViewReport (Media media) {
        return null;
    }

    public boolean AddMedia (Media media) {
        return true;
    }

    public boolean ModifyMediaDetails (Media media) {
        return true;
    }

    public boolean RemoveMedia (Media media) {
        return true;
    }

    public boolean IssueMedia (Media media) {
        return true;
    }
}
