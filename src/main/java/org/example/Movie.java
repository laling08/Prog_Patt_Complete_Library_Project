package org.example;

public class Movie extends Media{
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
}
