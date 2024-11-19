package org.example.Model.Interfaces;

public interface Loanable {
    void Checkout();
    void ReturnItem(char ReturnedCondition);
    void renewLoan();
    boolean isAvailable = true;
    void GiveLateFee();
}
