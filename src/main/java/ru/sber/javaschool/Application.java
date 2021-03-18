package ru.sber.javaschool;

public class Application {
    public static void main(String[] args) {
        String s = "Hello world!";

        String[] os = s.split("o");

        for (String o : os) {
            System.out.println(o);
        }


    }
}
