package org.example;

import java.time.LocalDate;

public class Member extends User{

    public Member(String fname, String lname) {
        super(fname, lname);
        this.dob = dob;
    }

}
