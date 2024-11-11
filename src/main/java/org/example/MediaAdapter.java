package org.example;

public interface MediaAdapter {
    String getTitle();
    String getLanguage();
    Genre getGenre();
    int getPublicationYear();
    int getAgeRestriction();
    int getMaxCheckoutLength();
    String getMediaInfo();
}
