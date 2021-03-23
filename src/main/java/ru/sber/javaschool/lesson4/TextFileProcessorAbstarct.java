package ru.sber.javaschool.lesson4;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.StandardCopyOption;

public abstract class TextFileProcessorAbstarct implements TextFileProcessor{
    private BufferedReader source;
    private BufferedWriter temporaryDestination;
    private String temporaryFileName;


    public boolean loadFile(String fileName) {
        try {
            InputStream sourceStream = new FileInputStream(fileName);
            InputStreamReader sourceReader = new InputStreamReader(sourceStream);
            source = new BufferedReader(sourceReader);
        }
        catch (FileNotFoundException ex) {
            return false;
        }
        try {
            temporaryFileName = createTemporaryFileAndGetName();
            OutputStream temporaryStream = new FileOutputStream(temporaryFileName);
            OutputStreamWriter temporaryWriter = new OutputStreamWriter(temporaryStream);
            temporaryDestination = new BufferedWriter(temporaryWriter);
        }
        catch (IOException ex) {
            return false;
        }
        return true;
    }

    public abstract boolean processFile();

    public boolean saveToFIle(String fileName) {
        try {
            source.close();
            temporaryDestination.flush();
            temporaryDestination.close();

            Files.copy(
                    (new File(temporaryFileName)).toPath(),
                    (new File(fileName)).toPath(),
                    StandardCopyOption.REPLACE_EXISTING);
        }
        catch (IOException ex) {
            return false;
        }
        return true;
    }

    protected BufferedReader getSource() {
        return source;
    }

    protected void writeDataToTemporaryOutput(String stringAfterProcess) throws IOException {
        temporaryDestination.write(stringAfterProcess + "\n");
    }

    private String createTemporaryFileAndGetName() throws IOException{
        File f = File.createTempFile("~file","processor");
        return f.getName();
    }
}
