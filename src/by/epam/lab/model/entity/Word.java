/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package by.epam.lab.model.entity;

import by.epam.lab.runner.TaskConstants;
import java.util.Iterator;
import java.util.List;
import java.util.Objects;

/**
 *
 * @author Soldier
 */
public class Word implements ElementSentence {

    private List<Symbol> word;

    public Word(List<Symbol> word) {
        this.setWord(word);
    }

    public Iterator<Symbol> getWord() {
        if (word != null) {
            return word.iterator();
        } else {
            return null;
        }
    }

    public void setWord(List<Symbol> word) {
        if (word != null) {
            this.word = word;
        }

    }

    @Override
    public String getValue() {
        StringBuilder result = new StringBuilder();
        if (word != null) {

            for (Symbol symbol : word) {
                result.append(symbol.getSymbol());
            }
        }
        return String.valueOf(result);
    }

    /**
     * Length of Word
     *
     * @return count of symbols in word
     */
    public int length() {
        if (word != null) {
            return word.size();
        } else {
            return 0;
        }

    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 59 * hash + Objects.hashCode(this.word);
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
        final Word other = (Word) obj;
        if (!Objects.equals(this.word, other.word)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return getClass().getName() + "{word=" + word + "}\n";
    }
}
