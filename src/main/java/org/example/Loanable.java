package org.example;

public interface Loanable {
    void Checkout();
    void ReturnItem(char ReturnedCondition);
    void renewLoan();
    boolean isAvailable = true;
    void GiveLateFee();
}
