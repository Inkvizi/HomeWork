package ru.sber.javaschool.lesson3.accounts;

import java.awt.*;

public interface Account {
    boolean withdraw(double Amount);
    boolean put(double Amount);
    double getBalance();
}
