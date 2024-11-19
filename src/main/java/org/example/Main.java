package org.example;

import org.example.Controller.DataAccess;
import org.example.Controller.DatabaseSetup;
import org.example.Model.Enums.Genre;
import org.example.Model.Medias.Book;
import org.example.Model.Users.Member;
import org.example.Model.Users.User;

public class Main {
    /**
     * This is the start of our Complete Library.
     */
    public static void main(String[] args) {
         DatabaseSetup.createTables();
         Book b = new Book("Le petit prince", "French", Genre.OTHER, 1920, 0, "23467-29364", "Prince", "Penguin", "Artist", 3);

         DataAccess db = new DataAccess();
         db.addBook(b);

        System.out.println(db.getBook(1));

    }
}