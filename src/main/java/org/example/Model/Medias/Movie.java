package org.example.Model.Medias;

import org.example.Model.Enums.Genre;

public class Movie extends Media {
    private String director;
    private int duration;

    // Set the default max checkout length for Movie
    { maxCheckoutLength = 7; }

    public Movie(String title, String language, Genre genre, int publicationYear, int ageRestriction,
                 String director, int duration) {
        super(title, language, genre, publicationYear, ageRestriction);
        this.director = director;
        this.duration = duration;
    }

    public Movie(int id, String title, String language, Genre genre, int publicationYear, int ageRestriction,
                 String director, int duration) {
        super(id, title, language, genre, publicationYear, ageRestriction);
        this.director = director;
        this.duration = duration;
    }

    public String getDirector() {
        return director;
    }

    public void setDirector(String director) {
        this.director = director;
    }

    public int getDuration() {
        return duration;
    }

    public void setDuration(int duration) {
        this.duration = duration;
    }

    @Override
    public String toString() {
        String baseToString = super.toString();

        return String.format("MOVIE\n%sDirector:\t\t\t%s\nDuration:\t\t\t%s",
                baseToString, director, duration);
    }

    public String toStringFR() {
        String baseToString = super.toStringFR();

        return String.format("FILM\n%sRéalisateur(trice):\t%s\nLongeur:\t\t%s",
                baseToString, director, duration);
    }
}
