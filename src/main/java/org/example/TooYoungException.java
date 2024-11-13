package org.example;

public class TooYoungException extends Exception {
    public TooYoungException() {
        super("You borrowing a book that is not appropriate for your age.");
    }

    public TooYoungException(String message) {
        super(message);
    }

    /**
     * With regards to this exception, should we add a method in the librarian that checks the age of the member using
     * their bday?:
     *
     *
     *
     * public class Loan {
     *
     *     // other methods here ...
     *
     *     public void borrowBook(dob memberBirthday, int bookMinAge) throws TooYoungException {
     *         int memberBirthday = calculateAge(userBirthday);
     *         if (userAge < bookMinAge) {
     *             throw new TooYoungException();
     *         }
     *         // Proceed with the borrowing process if the age is appropriate
     *     }
     *
     *     private int calculateAge(LocalDate birthday) {
     *         LocalDate today = LocalDate.now();
     *         return Period.between(birthday, today).getYears();
     *     }
     * }
     *
     *
     */
}
