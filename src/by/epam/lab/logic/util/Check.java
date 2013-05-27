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
/**
 * Check the filename to contains .txt
 * 
 * @param filename name of file, which must be checked
 * @return  if filename contains .txt return true, return false otherwise
 */
    public static boolean isTxtFile(String filename) {
        if (filename.matches(CheckConstants.TXT_REGEXP)) {
            return true;
        } else {
            return false;
        }
    }
/**
 * Check string to contains numbers
 * 
 * @param string tested string
 * @return  if string contains numbers only return true, false otherwise
 */
    public static boolean isNumber(String string) {
        if (string.matches(CheckConstants.NUMBER_REGEXP)) {
            return true;
        } else {
            return false;
        }
    }
}
