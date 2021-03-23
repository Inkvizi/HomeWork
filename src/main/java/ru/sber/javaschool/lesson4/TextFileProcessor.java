package ru.sber.javaschool.lesson4;

public interface TextFileProcessor {
    boolean loadFile(String fileName);
    boolean processFile();
    boolean saveToFIle(String filename);
}
