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

    public List<Word> findWords() {
        List<Word> words = new ArrayList<>();
        for (ElementSentence elementSentence : elementsSentence) {
            if (elementSentence instanceof Word) {
                words.add((Word) elementSentence);
            }
        }
        return words;
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
