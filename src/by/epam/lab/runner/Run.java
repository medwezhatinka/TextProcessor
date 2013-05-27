/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package by.epam.lab.runner;

import by.epam.lab.fileReader.IllegalFileFormatException;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.UnsupportedEncodingException;

/**
 *
 * @author Soldier
 */
public class Run {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here

        TaskManager tm = new TaskManager();
        try {

            tm.Run();
        } catch (IllegalFileFormatException | IsNotNumberException ex) {
            System.out.println(ex.getMessage());

        } catch (UnsupportedEncodingException ex) {
            System.out.println(ex.getMessage());
            ex.printStackTrace();
        } catch (FileNotFoundException ex) {
            System.out.println("File not found! " + ex.getMessage());
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
            ex.printStackTrace();
        }





    }
}
