/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package by.epam.lab.logic.util;

/**
 *
 * @author Soldier
 */
public class Check {

    public static boolean isTxtFile(String filename) {
        if (filename.matches(".*\\.txt")) {
            return true;
        } else {
            return false;
        }
    }

    public static boolean isNumber(String string) {
        if (string.matches("[0-9]+")) {
            return true;
        } else {
            return false;
        }
    }
}
