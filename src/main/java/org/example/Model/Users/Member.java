package org.example.Model.Users;

import java.time.LocalDate;

public class Member extends User {

    public Member(String fname, String lname, LocalDate dob) {
        super(fname, lname, dob);
    }

    public Member(int id, String fname, String lname, LocalDate dob) {
        super(id, fname, lname, dob);
    }

}
