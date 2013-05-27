/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package by.epam.lab.logic.util;

import by.epam.lab.model.entity.ElementSentence;
import by.epam.lab.model.entity.Word;
import java.util.Iterator;

/**
 *
 * @author Soldier
 */
public class Helper {

    public static ElementSentence getLastWord(Iterator<ElementSentence> iterator) {
        ElementSentence t;
        Word w = null;
        for (Iterator<ElementSentence> it = iterator; it.hasNext();) {
            t = it.next();
            if (t instanceof Word) {
                w = (Word) t;
            }
        }
        return w;
    }

    public static int getLastWordIndexW(Word word, Iterator<ElementSentence> iterator) {
        ElementSentence t;
        int w = 0;
        int i = 0;
        for (Iterator<ElementSentence> it = iterator; it.hasNext();) {
            t = it.next();

            if (word.equals(t)) {
                w = i;
            }
            i++;
        }
        return w;
    }
}
