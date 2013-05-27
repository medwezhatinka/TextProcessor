/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package by.epam.lab.command.task;

import by.epam.lab.logic.parser.ParseManager;
import by.epam.lab.logic.sorter.SortWordsByFirstLetter;
import by.epam.lab.logic.util.Helper;
import by.epam.lab.model.entity.ElementSentence;
import by.epam.lab.model.entity.Sentence;
import by.epam.lab.model.entity.Word;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 *
 * @author Soldier
 */
public class TextProcessor {
    
    
    /**
     * Swap first and last word in all sentences
     *
     * @param allText
     * @return text, where first and last words in sentences are swap as String
     */
    public static String swapFirstAndLastWordInSentence(String allText) {

        List<Sentence> sentences = ParseManager.getInstance(allText).getSentences();
        List<Sentence> newSentences = new ArrayList<>();
        Word first;
        Word last;

        for (Sentence sentence : sentences) {
            List<ElementSentence> e = new ArrayList<>();
            first = (Word) sentence.getElementsSentence().next();
            last = (Word) Helper.getLastWord(sentence.getElementsSentence());
            int i = 0;
            int lastindex = Helper.getLastWordIndexW(last, sentence.getElementsSentence());

            for (Iterator<ElementSentence> it = sentence.getElementsSentence(); it.hasNext();) {
                ElementSentence els = it.next();

                if (i == 0) {
                    els = last;
                } else if (i == lastindex) {
                    els = first;

                }
                i++;
                e.add(els);
            }
            newSentences.add(new Sentence(e));
        }

        StringBuilder sb = new StringBuilder();

        for (Sentence sentence : newSentences) {
            sb.append(sentence.getValue());
            sb.append(" \n");
        }

        return String.valueOf(sb);
    }

    /**
     * Cuts words, which have a specified length, from all sentences
     *
     * @param allText text as string
     * @param length length of words to cuts
     * @return text without cut words as String
     */
    public static String cutWordsWithLength(String allText, int length) {
        StringBuilder result = new StringBuilder();
        Word word;

        List<Sentence> sentences = ParseManager.getInstance(allText).getSentences();
        List<Sentence> newSentences = new ArrayList<>();

        for (Sentence sentence : sentences) {
            List<ElementSentence> e = new ArrayList<>();

            for (Iterator<ElementSentence> it = sentence.getElementsSentence(); it.hasNext();) {
                ElementSentence els = it.next();

                if (els instanceof Word) {
                    word = (Word) els;

                    if (word.length() == length && word.getWord().next().isConsonant()) {

                        continue;
                    }
                }
                e.add(els);
            }
            newSentences.add(new Sentence(e));
        }

        StringBuilder sb = new StringBuilder();

        for (Sentence sentence : newSentences) {
            sb.append(sentence.getValue());
            sb.append(" \n");
        }

        return String.valueOf(sb);
    
    }
     /**
     * Sort all words by first letter in alphabetic order and return them as
     * string. Words, which begins from other letter separated by \n
     *
     * @param allText text as String
     * @return String of words by groups, separated by \n. Words starts from
     * same letter consists the same group.
     */
    public static String sortedWords(String allText) {

        List<Word> words = ParseManager.getInstance(allText).getWords();
        List<Word> wordList = SortWordsByFirstLetter.sort(words);

        StringBuilder result = new StringBuilder();
        Iterator<Word> it = wordList.iterator();
        Word next;

        if (it.hasNext()) {
            next = it.next();

        }

        for (Word word : wordList) {
            result.append(word.getValue());
            result.append("\n");

            if (it.hasNext()) {
                next = it.next();

                if (!word.getWord()
                        .next()
                        .getSymbol()
                        .toLowerCase()
                        .equals(next.getWord()
                        .next()
                        .getSymbol()
                        .toLowerCase())) {
                    result.append("\n");
                }
            }
        }

        return String.valueOf(result);


    }
}
