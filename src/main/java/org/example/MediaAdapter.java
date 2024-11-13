package org.example;

public interface MediaAdapter {
    public String getTitle();
    public String getLanguage();
    public Genre getGenre();
    public int getPublicationYear();
    public int getAgeRestriction();
    public int getMaxCheckoutLength();
    public String getMediaInfo();
}
