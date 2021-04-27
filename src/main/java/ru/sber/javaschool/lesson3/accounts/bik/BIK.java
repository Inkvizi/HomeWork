package ru.sber.javaschool.lesson3.accounts.bik;

import lombok.Getter;

@Getter
public class BIK {

    private String bikValue;

    public BIK(String bikValue) {
        this.bikValue = bikValue;
    }

    public Boolean check() {
        if (bikValue.isEmpty()) {
            return false;
        }
        else {
            return true;
        }
    }
}
