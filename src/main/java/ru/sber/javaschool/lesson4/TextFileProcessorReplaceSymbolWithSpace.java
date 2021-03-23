package ru.sber.javaschool.lesson4;

import java.io.IOException;
import java.io.Reader;

public class TextFileProcessorReplaceSymbolWithSpace extends TextFileProcessorAbstarct{

    private static final char NEW_CHAR = ' ';
    private final char charForReplace;

    public TextFileProcessorReplaceSymbolWithSpace (char charForReplace) {
        this.charForReplace = charForReplace;
    }

    @Override
    public boolean processFile() {
        try {
            String stringForProcessing;
            while ((stringForProcessing = getSource().readLine()) != null) {
                stringForProcessing = stringForProcessing.replace(charForReplace, NEW_CHAR);
                writeDataToTemporaryOutput(stringForProcessing);
            }
        }
        catch (IOException ex) {
            return false;
        }
        return true;
    }
}
