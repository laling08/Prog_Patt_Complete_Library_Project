package org.example.Model.Users;

import java.time.LocalDate;

abstract class AbstractFactory {
    public abstract User getUser(String user, String fname, String lname, LocalDate dob);
}


public class UserFactory extends AbstractFactory {
    @Override
    public User getUser(String user, String fname, String lname, LocalDate dob) {
        if ("Member".equals(user)) {
            return new Member(fname, lname, dob);
        } else if ("Librarian".equals(user)) {
            return new Librarian(fname, lname, dob);
        } else {
            return null;
        }
    }
}
