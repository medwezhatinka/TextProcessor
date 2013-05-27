/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package by.epam.lab.model.entity;

import java.util.Objects;

/**
 *
 * @author Soldier
 */
public class Punctuation implements ElementSentence {

    private String punctuation;

    public Punctuation(String punctuation) {
        this.setPunctuation(punctuation);
    }

    public String getPunctuation() {
        return punctuation;
    }

    public void setPunctuation(String punctuation) {
        if (!punctuation.isEmpty() && punctuation != null) {
            this.punctuation = punctuation;
        }

    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 97 * hash + Objects.hashCode(this.punctuation);
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
        final Punctuation other = (Punctuation) obj;
        if (!Objects.equals(this.punctuation, other.punctuation)) {
            return false;
        } else {
            return true;
        }
    }

    @Override
    public String toString() {
        return getClass().getName() + "{punctuation=" + punctuation + '}';
    }

    @Override
    public String getValue() {
        return punctuation + " ";
    }
}
