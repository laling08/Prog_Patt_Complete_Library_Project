package org.example.Controller;

import org.example.Model.Exceptions.TooYoungException;
import org.example.Model.Users.User;

import static org.example.Controller.DataAccess.*;

public class UserController {
    private final User user;

    public UserController(User user) {
        this.user = user;
    }

    /**
     * When a user returns an item, it removes it from the user's CurrentCheckouts,
     * updates the item's status, and removes the loan from the loan file.
     * @param mediaId the media item being returned
     * @return true if the return process is successful
     */
    public boolean returnMedia(int mediaId) {
        int userId = user.getId();
        returnLoan(userId, mediaId);

        String itemType = findMediaType(mediaId);
        switch (itemType) {
            case "Book":
                BookController bookController = new BookController(getBook(mediaId));
                return bookController.returnBook(user);
            case "Movie":
                MovieController movieController = new MovieController(getMovie(mediaId));
                return movieController.returnMovie(user);
            case "Audiobook":
                AudiobookController audiobookController = new AudiobookController(getAudiobook(mediaId));
                return audiobookController.returnAudiobook(user);
            case "Magazine":
                MagazineController magazineController = new MagazineController(getMagazine(mediaId));
                return magazineController.returnMagazine(user);
            default:
                return false;
        }
    }

    /**
     * Checkouts a book by changing its status and adding a new loan
     * @param mediaId   ID of media being taken out
     * @return          whether the operation was successful
     * @throws TooYoungException
     */
    public boolean checkout(int mediaId) throws TooYoungException {
        String itemType = findMediaType(mediaId);

        switch (itemType) {
            case "book":
                BookController bookController = new BookController(getBook(mediaId));
                return bookController.checkoutBook(user);
            case "movie":
                MovieController movieController = new MovieController(getMovie(mediaId));
                return movieController.checkoutMovie(user);
            case "audiobook":
                AudiobookController audiobookController = new AudiobookController(getAudiobook(mediaId));
                return audiobookController.checkoutAudiobook(user);
            case "magazine":
                MagazineController magazineController = new MagazineController(getMagazine(mediaId));
                return magazineController.checkoutMagazine(user);
            default:
                return false;
        }
    }

    /**
     * Places a hold on an item by changing its status and creating a hold
     * @param mediaId   id of item to put on hold
     * @return          whether the operation was successful
     * @throws TooYoungException
     */
    public boolean placeHold(int mediaId) throws TooYoungException {
        int userId = user.getId();
        String itemType = findMediaType(mediaId);

        switch (itemType) {
            case "Book":
                BookController bookController = new BookController(getBook(mediaId));
                return bookController.placeBookHold(user);
            case "Movie":
                MovieController movieController = new MovieController(getMovie(mediaId));
                return movieController.placeMovieHold(user);
            case "Audiobook":
                AudiobookController audiobookController = new AudiobookController(getAudiobook(mediaId));
                return audiobookController.placeAudiobookHold(user);
            case "Magazine":
                MagazineController magazineController = new MagazineController(getMagazine(mediaId));
                return magazineController.placeMagazineHold(user);
            default:
                return false;
        }
    }
}
