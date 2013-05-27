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
public class Text {

    private List<ElementText> text;

    public Text(List<ElementText> text) {
        this.setText(text);
    }

    public Iterator<ElementText> getText() {
        return text.iterator();
    }

    public void setText(List<ElementText> text) {
        if (text != null) {
            this.text = text;
        }

    }

    public List<Sentence> findSentences() {
        List<Sentence> se = new ArrayList<>();
        for (ElementText elementText : text) {
            if (elementText instanceof Sentence) {
                se.add((Sentence) elementText);
            }
        }
        return se;
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 97 * hash + Objects.hashCode(this.text);
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
        final Text other = (Text) obj;
        if (!Objects.equals(this.text, other.text)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return getClass().getName() + "{text=" + text + '}';
    }
}
