/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package by.epam.lab.fileReader;

import by.epam.lab.logic.util.Check;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.util.Objects;

/**
 *
 * @author Soldier
 */
public class FileReader {

    private File inputFile;

    public FileReader(File inputFile) {
        this.setInputFile(inputFile);
    }

    /**
     * Create new instance of FileReader
     *
     * @param filename string - path to file
     * @throws IllegalFileFormatException if format of file is not .txt throws
     * exception
     */
    public FileReader(String filename) throws IllegalFileFormatException {
        if (Check.isTxtFile(filename)) {
            this.inputFile = new File(filename);
        } else {
            throw new IllegalFileFormatException("Illegal format of file! Must be .txt");
        }

    }

    public File getInputFile() {
        return inputFile;
    }

    public void setInputFile(File inputFile) {
        if (inputFile != null) {
            this.inputFile = inputFile;
        }

    }

    /**
     * Read text from .txt file
     *
     * @return text from file as String
     * @throws UnsupportedEncodingException
     * @throws FileNotFoundException
     * @throws IOException
     */
    public String readAllText() throws UnsupportedEncodingException, FileNotFoundException, IOException {
        FileInputStream fileInputStream = new FileInputStream(inputFile);
        InputStreamReader inputStreamReader = new InputStreamReader(fileInputStream);//"UTF-8");
        StringBuilder text;
        try (BufferedReader bufferedReaderr = new BufferedReader(inputStreamReader)) {
            text = new StringBuilder();
            String line;
            while ((line = bufferedReaderr.readLine()) != null) {
                text.append(line);
                text.append("\n");
            }
        }
        String allText = String.valueOf(text);
        return allText;

    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 37 * hash + Objects.hashCode(this.inputFile);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final FileReader other = (FileReader) obj;
        if (!Objects.equals(this.inputFile, other.inputFile)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return getClass().getName() + "{inputFile=" + inputFile + '}';
    }
}
