/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package by.epam.lab.logic.parser;

import by.epam.lab.model.entity.Code;
import by.epam.lab.model.entity.ElementSentence;
import by.epam.lab.model.entity.ElementText;
import by.epam.lab.model.entity.Punctuation;
import by.epam.lab.model.entity.Sentence;
import by.epam.lab.model.entity.Symbol;
import by.epam.lab.model.entity.Text;
import by.epam.lab.model.entity.Word;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 *
 * @author Soldier
 */
public class Parser {

    /**
     * Parse string to instance of Text
     *
     * @param allText text for parsing as String
     * @return Text instance
     */
    public static Text parseText(String allText) {
        //compile patterns
        Pattern patternSentence = Pattern.compile(ParserConstants.SENTENCE_REGEXP, Pattern.MULTILINE);
        Pattern patternCode = Pattern.compile(ParserConstants.CODE_REGEXP, Pattern.MULTILINE);
        Pattern patternWord = Pattern.compile(ParserConstants.WORD_REGEXP, Pattern.MULTILINE);
        Pattern patternPunctuation = Pattern.compile(ParserConstants.PUNCT_REGEXP, Pattern.MULTILINE);
        Pattern patternSymbol = Pattern.compile(ParserConstants.SYMBOL_REGEXP, Pattern.MULTILINE);
        //collection of results text elemenents (Sentence and Code)
        List<ElementText> elementsText = new ArrayList<>();
        //parse text to sentences
        List<String> elementText = parseByPattern(allText, patternSentence);
        // cut code from all sentences
        for (String textElement : elementText) {
            //find code
            List<String> code = parseByPattern(textElement, patternCode);
            // find sentences without code
            String[] sentence = patternCode.split(textElement);
            // iterator of code collection
            Iterator<String> it = code.iterator();
            //collection of sentence elements (Word and Punctuation)
            List<ElementSentence> elementsSentence = new ArrayList<>();
            //create instance of Sentence and Code 
            for (int i = 0; i < sentence.length; i++) {
                //parse sentences to words with punctuation
                List<String> sentenceElements = parseByPattern(sentence[i], patternWord);
                //cut punctuations from words
                for (String sentenceElement : sentenceElements) {
                    //find punctuations
                    List<String> punctuations = parseByPattern(sentenceElement, patternPunctuation);
                    //find words without punctuations
                    String[] word = patternPunctuation.split(sentenceElement);
                    //create instances of Word and Punctuation
                    for (int j = 0; j < word.length; j++) {
                        //collection of symbols
                        List<Symbol> symbols = new ArrayList<>();
                        //find symbols
                        List<String> symbolsList = parseByPattern(word[j], patternSymbol);
                        //create instance of Symbol
                        for (String simbol1 : symbolsList) {
                            Symbol s = new Symbol(simbol1);
                            symbols.add(s);
                        }
                        //create and add Word from collection of Symbol to Sentence
                        ElementSentence se = new Word(symbols);
                        elementsSentence.add(se);

                        Iterator<String> itpunct = punctuations.iterator();
                        //create Punctuation and add to Sentence
                        if (itpunct.hasNext()) {
                            ElementSentence p = new Punctuation(itpunct.next());
                            elementsSentence.add(p);
                        }
                    }
                }

                //Create Sentence from Words and Punctuations and add to result text
                ElementText s = new Sentence(elementsSentence);
                elementsText.add(s);
                //Create Code and add to result text
                if (it.hasNext()) {
                    ElementText c = new Code(it.next());
                    elementsText.add(c);
                }
            }

        }
        //create result instance of Text
        Text text = new Text(elementsText);
        return text;
    }

    /**
     * Parse text with a specified pattern
     *
     * @param text String for parsing
     * @param pattern Pattern for parse string
     * @return Ordered collection of elements parsed text
     */
    private static List<String> parseByPattern(String text, Pattern pattern) {
        List<String> result = new ArrayList<>();
        Matcher matcher = pattern.matcher(text);
        while (matcher.find()) {
            result.add(matcher.group());
        }

        return result;
    }
}
