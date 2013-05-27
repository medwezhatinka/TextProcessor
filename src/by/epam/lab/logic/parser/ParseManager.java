/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package by.epam.lab.logic.parser;

import by.epam.lab.model.entity.Sentence;
import by.epam.lab.model.entity.Text;
import by.epam.lab.model.entity.Word;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/**
 *
 * @author Soldier
 */
public final class ParseManager {

    private static ParseManager instance;
    private Text text;

    private ParseManager(String text) {
        this.text = Parser.parseText(text);
    }

    public Text getText() {
        return text;
    }

    public static ParseManager getInstance(String text) {

        if (instance == null) {

            return new ParseManager(text);
        }

        return instance;
    }

    public List<Word> getWords() {
        List<Sentence> sentences = text.findSentences();
        List<Word> words = new ArrayList<>();
        for (Sentence sentence : sentences) {
            words.addAll(sentence.findWords());
        }
        return words;


    }

    public List<Sentence> getSentences() {
        return text.findSentences();
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 89 * hash + Objects.hashCode(this.text);
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
        final ParseManager other = (ParseManager) obj;
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
