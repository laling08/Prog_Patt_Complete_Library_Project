package org.example;

public class MagazineAdapter implements MediaAdapter{
    private final Magazine magazine;

    public MagazineAdapter(Magazine magazine) {
        this.magazine = magazine;
    }

    @Override
    public String getTitle() {
        return magazine.getTitle();
    }

    @Override
    public String getLanguage() {
        return magazine.getLanguage();
    }

    @Override
    public Genre getGenre() {
        return magazine.getGenre();
    }

    @Override
    public int getPublicationYear() {
        return magazine.getPublicationYear();
    }

    @Override
    public int getAgeRestriction() {
        return magazine.getAgeRestriction();
    }

    @Override
    public int getMaxCheckoutLength() {
        return magazine.getMaxCheckoutLength();
    }

    @Override
    public String getMediaInfo() {
        return "Magazine ISSN: " + magazine.getISSN() + ", Publisher: " + magazine.getPublisher();
    }
}
