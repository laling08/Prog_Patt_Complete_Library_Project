package org.example;

public class AudiobookAdapter implements MediaAdapter{
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
}
