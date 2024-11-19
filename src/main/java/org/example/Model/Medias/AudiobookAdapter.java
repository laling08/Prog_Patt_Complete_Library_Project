package org.example.Model.Medias;

import org.example.Model.Enums.Genre;
import org.example.Model.Interfaces.MediaAdapter;

public class AudiobookAdapter implements MediaAdapter {
    private final Audiobook audiobook;

    public AudiobookAdapter(Audiobook audiobook) {
        this.audiobook = audiobook;
    }

    @Override
    public String getTitle() {
        return audiobook.getTitle();
    }

    @Override
    public String getLanguage() {
        return audiobook.getLanguage();
    }

    @Override
    public Genre getGenre() {
        return audiobook.getGenre();
    }

    @Override
    public int getPublicationYear() {
        return audiobook.getPublicationYear();
    }

    @Override
    public int getAgeRestriction() {
        return audiobook.getAgeRestriction();
    }

    @Override
    public int getMaxCheckoutLength() {
        return audiobook.getMaxCheckoutLength();
    }

    @Override
    public String getMediaInfo() {
        return "Audiobook ISBN: " + audiobook.getISBN() + ", Narrator: " + audiobook.getNarrator() + ", Duration: " + audiobook.getDuration() + " mins";
    }

    public String getISBN() {
        return audiobook.getISBN();
    }

    public String getAuthor() {
        return audiobook.getAuthor();
    }

    public String getPublisher() {
        return audiobook.getPublisher();
    }

    public String getNarrator() {
        return audiobook.getNarrator();
    }

    public int getEdition() {
        return audiobook.getEdition();
    }

    public int getDuration() {
        return audiobook.getDuration();
    }
}
