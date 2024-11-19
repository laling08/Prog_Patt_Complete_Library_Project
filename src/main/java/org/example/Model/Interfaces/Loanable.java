package org.example.Model.Interfaces;

public interface Loanable {
    void Checkout();
    void ReturnItem();
    void renewLoan();
    boolean isAvailable = true;
    void GiveLateFee();
}
