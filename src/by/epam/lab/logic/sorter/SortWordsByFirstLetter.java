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
public final class SortWordsByFirstLetter {

    public static List<Word> sort(List<Word> words) {
        ArrayList<Word> wordsList = (ArrayList<Word>) words;
        ArrayList<Word> _list = (ArrayList<Word>) wordsList.clone();
        Collections.sort(_list, new FirstLetterComparator());
        return _list;
    }

    private static class FirstLetterComparator implements Comparator<Word> {

        @Override
        public int compare(Word o1, Word o2) {
            int result = o1.getWord().next().getSymbol().toLowerCase().compareTo(o2.getWord().next().getSymbol().toLowerCase());
            if (result > 0) {
                return 1;
            } else if (result < 0) {
                return -1;
            }
            return 0;
        }
    }
}
