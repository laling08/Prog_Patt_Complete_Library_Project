package org.example;

public class Magazine extends Media{
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
    public void Checkout() {

    }

    @Override
    public void ReturnItem(char ReturnedCondition) {

    }

    @Override
    public void renewLoan() {

    }

    @Override
    public void GiveLateFee() {

    }

}
