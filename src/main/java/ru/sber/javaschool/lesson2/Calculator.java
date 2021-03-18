package ru.sber.javaschool.lesson2;

public class Calculator {
    public int addition (int left, int right) {
        return left + right;
    }

    public int subtraction(int left, int right) {
        return left - right;
    }

    public double multiplication(double left, double right) {
        return left * right;
    }

    public double division (double left, double right) {
        return left / right;
    }

    public int getModulus (int value) {
        if (value < 0) {
            return value*(-1);
        }
        else {
            return value;
        }
    }

    public int getMod (int left, int right) {
        int intNumber = left / right;
        return left - right * intNumber;
    }

    public double getPercentValue (int value, int persent) {
        return (value / 100) * persent;
    }
}
