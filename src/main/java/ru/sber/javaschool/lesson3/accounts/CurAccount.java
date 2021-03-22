package ru.sber.javaschool.lesson3.accounts;

public class CurAccount extends AccountDefault {
    private String Currency;

    CurAccount(String Currency) {
        super();
        this.Currency = Currency;
    }

    String getCurrency() {
        return Currency;
    }
}
