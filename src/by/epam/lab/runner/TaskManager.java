/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package by.epam.lab.runner;


import by.epam.lab.command.task.TextProcessor;
import by.epam.lab.fileReader.FileReader;
import by.epam.lab.fileReader.IllegalFileFormatException;
import by.epam.lab.logic.util.Check;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;

/**
 *
 * @author Soldier
 */
public class TaskManager {

    public void Run() throws IllegalFileFormatException, UnsupportedEncodingException, FileNotFoundException, IOException,
            IllegalFileFormatException, IsNotNumberException {


        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        String filename;

        System.out.print("Input file with text for parsing: ");

        filename = bufferedReader.readLine();

        FileReader fileReader = new FileReader(filename);

        String allText;
        allText = fileReader.readAllText();

        String end = "";
        while (!end.equalsIgnoreCase(TaskConstants.INPUT_END)) {

            System.out.println("To sort words by first letter in alphabetic order please  enter 1\n"
                    + "To swap first and last word in sentences  enter 2\n"
                    + "To cut words, which starts of consonant and have a specified length enter 3\n");

            System.out.print("Enter number: ");
            String line = bufferedReader.readLine().trim();

            if (!Check.isNumber(line)) {

                throw new IsNotNumberException("Not a  number!");
            }
            int task = Integer.valueOf(line);

            switch (task) {
                case 1:

                    System.out.println(TextProcessor.sortedWords(allText));
                    break;

                case 2:

                    System.out.println(TextProcessor.swapFirstAndLastWordInSentence(allText));
                    break;

                case 3:

                    System.out.print("Input length: ");
                    line = bufferedReader.readLine().trim();

                    if (!Check.isNumber(line)) {

                        throw new IsNotNumberException("Not a  number!");
                    }

                    int lengthWord = Integer.valueOf(line);
                    System.out.println(TextProcessor.cutWordsWithLength(allText, lengthWord));
                    break;

                default:

                    System.out.println("Unknown operation! ");
            }

            System.out.print("If you want stop enter \"end\": ");

            end = bufferedReader.readLine().trim();

            if (end.equalsIgnoreCase(TaskConstants.INPUT_END)) {
                bufferedReader.close();
            }
        }


    }
}
