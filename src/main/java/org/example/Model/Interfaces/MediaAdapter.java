package org.example.Model.Interfaces;

import org.example.Model.Enums.Genre;

public interface MediaAdapter {
    public String getTitle();
    public String getLanguage();
    public Genre getGenre();
    public int getPublicationYear();
    public int getAgeRestriction();
    public int getMaxCheckoutLength();
    public String getMediaInfo();
}
