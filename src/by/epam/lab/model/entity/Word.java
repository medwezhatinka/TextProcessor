/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package by.epam.lab.model.entity;

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
        return word.iterator();
    }

    public void setWord(List<Symbol> word) {
        if (word != null) {
            this.word = word;
        }

    }

    @Override
    public String getValue() {
        StringBuilder result = new StringBuilder();
        for (Symbol symbol : word) {
            result.append(symbol.getSymbol());

        }
        return String.valueOf(result);
    }

    public int length() {
        return word.size();
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
