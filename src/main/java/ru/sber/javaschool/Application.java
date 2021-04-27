package ru.sber.javaschool;

import ru.sber.javaschool.lesson4.TextFileProcessor;
import ru.sber.javaschool.lesson4.TextFileProcessorReplaceSymbolWithSpace;

public class Application {
    public static void main(String[] args) {
        TextFileProcessor processor = new TextFileProcessorReplaceSymbolWithSpace('o');
        boolean isValidOperation = processor.loadFile("README.md");
        if (!isValidOperation) {
            System.out.println("can't read file");
        }
        isValidOperation = processor.processFile();
        if (!isValidOperation) {
            System.out.println("can't process file");
        }
        isValidOperation = processor.saveToFIle("README_PROCESSED.md");
        if (!isValidOperation) {
            System.out.println("cant't save file");
        }
    }
}
