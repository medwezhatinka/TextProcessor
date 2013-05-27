/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package by.epam.lab.fileReader;

/**
 *
 * @author Soldier
 */
public class IllegalFileFormatException extends Exception {

    public IllegalFileFormatException() {
    }

    public IllegalFileFormatException(String message) {
        super(message);
    }

    public IllegalFileFormatException(String message, Throwable cause) {
        super(message, cause);
    }

    public IllegalFileFormatException(Throwable cause) {
        super(cause);
    }
}
