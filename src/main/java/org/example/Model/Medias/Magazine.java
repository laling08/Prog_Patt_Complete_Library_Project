package org.example.Model.Medias;

import org.example.Model.Enums.Genre;
import org.w3c.dom.ls.LSOutput;

public class Magazine extends Media {
    private String ISSN;
    private String publisher;
    private String publicationMonth;

    // Set the default max checkout length for Magazine
    { maxCheckoutLength = 7; }

    public Magazine(String title, String language, Genre genre, int publicationYear, int ageRestriction,
                    String ISSN, String publisher, String publicationMonth) {
        super(title, language, genre, publicationYear, ageRestriction);
        this.ISSN = ISSN;
        this.publisher = publisher;
        this.publicationMonth = publicationMonth;
    }

    public Magazine(int id, String title, String language, Genre genre, int publicationYear, int ageRestriction,
                    String ISSN, String publisher, String publicationMonth) {
        super(id, title, language, genre, publicationYear, ageRestriction);
        this.ISSN = ISSN;
        this.publisher = publisher;
        this.publicationMonth = publicationMonth;
    }

    public String getISSN() {
        return ISSN;
    }

    public void setISSN(String ISSN) {
        this.ISSN = ISSN;
    }

    public String getPublisher() {
        return publisher;
    }

    public void setPublisher(String publisher) {
        this.publisher = publisher;
    }

    public String getPublicationMonth() {
        return publicationMonth;
    }

    public void setPublicationMonth(String publicationMonth) {
        this.publicationMonth = publicationMonth;
    }

    @Override
    public String toString() {
        return String.format("MAGAZINE\n%sISSN:\t\t\t%s\nPublisher:\t\t%s\nMonth:\t\t\t%s",
                super.toString(), ISSN, publisher, publicationMonth);
    }

    public String toStringFR() {
        return String.format("MAGAZINE\n%sISSN:\t\t%s\nMaison d'édition:\t%s\nMois:\t\t%s\n",
                super.toStringFR(), ISSN, publisher, publicationMonth);
    }
}
