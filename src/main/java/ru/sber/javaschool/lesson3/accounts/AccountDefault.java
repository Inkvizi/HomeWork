package ru.sber.javaschool.lesson3.accounts;

public class AccountDefault implements Account {
    private double balance;

    public boolean withdraw(double Amount) {
        if ((Amount >= 0) && (balance >= Amount)) {
            balance -= Amount;
            return true;
        }
        else {
            return false;
        }
    }

    public boolean put(double Amount) {
        if (Amount >= 0) {
            balance += Amount;
            return true;
        }
        else {
            return false;
        }
    }

    public double getBalance() {
        return balance;
    }
}
