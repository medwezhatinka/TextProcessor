/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package by.epam.lab.logic.sorter;

import by.epam.lab.model.entity.Word;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/**
 *
 * @author Soldier
 */
public final class SortWords {
/**
 * Sort collection with specified comparator
 * 
 * @param words collection of Word instance for sort
 * @param comparator comparator for sort
 * @return sorted collection by specified comparator
 */
    public static List<Word> sort(List<Word> words, Comparator<Word> comparator) {
        ArrayList<Word> wordsList = (ArrayList<Word>) words;
        ArrayList<Word> _list = (ArrayList<Word>) wordsList.clone();
        Collections.sort(_list, comparator);
        return _list;
    }

    
}
