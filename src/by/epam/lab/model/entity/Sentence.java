/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package by.epam.lab.model.entity;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Objects;

/**
 *
 * @author Soldier
 */
public class Sentence implements ElementText {

    private List<ElementSentence> elementsSentence;

    public Sentence(List<ElementSentence> elementsSentence) {
        this.setElementsSentence(elementsSentence);

    }

    public Iterator<ElementSentence> getElementsSentence() {
        return elementsSentence.iterator();
    }

    public void setElementsSentence(List<ElementSentence> elementsSentence) {
        if (elementsSentence != null) {
            this.elementsSentence = elementsSentence;
        }
    }
/**
 * Return collections of Word instance from ElementSentence collection
 * 
 * @return  collection of Word instance
 */
    public List<Word> findWords() {
        List<Word> words = new ArrayList<>();
        for (ElementSentence elementSentence : elementsSentence) {
            if (elementSentence instanceof Word) {
                words.add((Word) elementSentence);
            }
        }
        return words;
    }
    /**
     * Find last Word instance in ElementSentence collection
     * 
     * @return last Word instance from collection of ElementSentence
     */
    public  Word getLastWord() {
          Word word = null;
        for (ElementSentence elementSentence : elementsSentence) {
            if (elementSentence instanceof Word) {
                word = (Word) elementSentence;
            }
        }
        return word;
    }
    /**
     * Find first  Word instance in ElementSentence collection
     * 
     * @return first Word instance from collection of ElementSentence
     */
     public  Word getFirstWord() {
         Word firstWord=null;
         for (Iterator<ElementSentence> iteratorElementSentence = elementsSentence.iterator(); iteratorElementSentence.hasNext();) {
             ElementSentence elementSentence = iteratorElementSentence.next();
             if (elementSentence instanceof Word) {
                 firstWord = (Word) elementSentence;
                 break;
             }
         }
        return firstWord;
    }
/**
 * Find last index of specified word in collection of ElementSentence
 * 
 * @param word Word instance to find in collection
 * @return  last index of specified Word instance in collection of ElementSentence
 */
     public int getLastWordIndex(Word word) {
        ElementSentence elementSentence;
        int lastWordIndex = 0;
        int index = 0;
        for (Iterator<ElementSentence> it = elementsSentence.iterator(); it.hasNext();) {
            elementSentence = it.next();

            if (word.equals(elementSentence)) {
                lastWordIndex = index;
            }
            index++;
        }
        return lastWordIndex;
    }
    @Override
    public int hashCode() {
        int hash = 7;
        hash = 53 * hash + Objects.hashCode(this.elementsSentence);
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
        final Sentence other = (Sentence) obj;
        if (!Objects.equals(this.elementsSentence, other.elementsSentence)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return getClass().getName() + "{elementsSentence=" + elementsSentence + "}\n";
    }

    @Override
    public String getValue() {
        StringBuilder result = new StringBuilder();
        Iterator<ElementSentence> it = elementsSentence.iterator();
        ElementSentence es = it.next();
        for (ElementSentence elementSentence : elementsSentence) {
            result.append(elementSentence.getValue());
            if (it.hasNext() && (es = it.next()) instanceof Word) {
                result.append(" ");
            }

        }
        return String.valueOf(result);
    }
}
