/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package by.epam.lab.logic.sorter;

import by.epam.lab.model.entity.Word;
import java.util.Comparator;

/**
 *
 * @author Soldier
 */
public class FirstLetterComparator implements Comparator<Word>{
    /**
     * Compare two instance of Word by first symbol
     * 
     * @param o1 First Word for compare
     * @param o2 Second Word for compare
     * @return the value 0 if the first symbol of first Word  is equal to the first symbol of second Word; 
     * a value -1 if first symbol of first Word is lexicographically less than the first symbol of second Word;  
     * and a value 1 if first symbol of first Word  is lexicographically greater than the first symbol of second Word.
     */
    
        @Override
        public int compare(Word o1, Word o2) {
            int result = o1.getWord()
                    .next()
                    .getSymbol()
                    .toLowerCase()
                   
                    .compareTo(o2.getWord()
                    .next()
                    .getSymbol()
                    .toLowerCase());
            
            if (result > 0) {
                return 1;
            } else if (result < 0) {
                return -1;
            }
            return 0;
        }
   
}
