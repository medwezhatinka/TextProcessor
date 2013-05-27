/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package by.epam.lab.command.task;

import by.epam.lab.logic.parser.ParseManager;
import by.epam.lab.logic.sorter.FirstLetterComparator;
import by.epam.lab.logic.sorter.SortWords;
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
            List<ElementSentence> newElementSentences = new ArrayList<>();
            first = sentence.getFirstWord();
            last = sentence.getLastWord();
            int i = 0;
            int lastindex = sentence.getLastWordIndex(last);

            for (Iterator<ElementSentence> it = sentence.getElementsSentence(); it.hasNext();) {
                ElementSentence elementSentence = it.next();

                if (i == 0) {
                    elementSentence = last;
                } else if (i == lastindex) {
                    elementSentence = first;

                }
                i++;
                newElementSentences.add(elementSentence);
            }
            newSentences.add(new Sentence(newElementSentences));
        }

        StringBuilder result = new StringBuilder();

        for (Sentence sentence : newSentences) {
            result.append(sentence.getValue());
            result.append(" \n");
        }

        return String.valueOf(result);
    }

    /**
     * Cuts words, which have a specified length, from all sentences
     *
     * @param allText text as string
     * @param length length of words to cuts
     * @return text without cut words as String
     */
    public static String cutWordsWithLength(String allText, int length) {
       
        Word word;

        List<Sentence> sentences = ParseManager.getInstance(allText).getSentences();
        List<Sentence> newSentences = new ArrayList<>();

        for (Sentence sentence : sentences) {
            List<ElementSentence> elementSentences = new ArrayList<>();

            for (Iterator<ElementSentence> it = sentence.getElementsSentence(); it.hasNext();) {
                ElementSentence elementSentence = it.next();

                if (elementSentence instanceof Word) {
                    word = (Word) elementSentence;

                    if (word.length() == length && word.getWord().next().isConsonant()) {

                        continue;
                    }
                }
                elementSentences.add(elementSentence);
            }
            newSentences.add(new Sentence(elementSentences));
        }

        StringBuilder result = new StringBuilder();

        for (Sentence sentence : newSentences) {
            result.append(sentence.getValue());
            result.append(" \n");
        }

        return String.valueOf(result);
    
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
        List<Word> wordList = SortWords.sort(words, new FirstLetterComparator());

        StringBuilder result = new StringBuilder();
        Iterator<Word> it = wordList.iterator();
        Word nextWord;

        if (it.hasNext()) {
            nextWord = it.next();

        }

        for (Word word : wordList) {
            result.append(word.getValue());
            result.append("\n");

            if (it.hasNext()) {
                nextWord = it.next();

                if (!word.getWord()
                        .next()
                        .getSymbol()
                        .toLowerCase()
                        .equals(nextWord.getWord()
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
