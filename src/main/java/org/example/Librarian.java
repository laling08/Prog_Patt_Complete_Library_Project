package org.example;

public class Librarian extends User{

    public Librarian(String fname, String lname) {
        super(fname, lname);
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
