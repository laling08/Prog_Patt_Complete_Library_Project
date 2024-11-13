package org.example;

public class MovieAdapter implements MediaAdapter{
    private final Movie movie;

    public MovieAdapter(Movie movie) {
        this.movie = movie;
    }

    @Override
    public String getTitle() {
        return movie.getTitle();
    }

    @Override
    public String getLanguage() {
        return movie.getLanguage();
    }

    @Override
    public Genre getGenre() {
        return movie.getGenre();
    }

    @Override
    public int getPublicationYear() {
        return movie.getPublicationYear();
    }

    @Override
    public int getAgeRestriction() {
        return movie.getAgeRestriction();
    }

    @Override
    public int getMaxCheckoutLength() {
        return movie.getMaxCheckoutLength();
    }

    @Override
    public String getMediaInfo() {
        return "Movie Director: " + movie.getDirector() + ", Duration: " + movie.getDuration() + " mins";
    }

    public String getDirector() {
        return movie.getDirector();
    }

    public int getDuration() {
        return movie.getDuration();
    }
}
