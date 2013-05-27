/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package by.epam.lab.logic.parser;

/**
 *
 * @author Soldier
 */
public interface ParserConstants {

    String CODE_REGEXP = "[\n]+(/|private|public|protected|class|void|String|int|double| final|static).*(\n.*)*[};]+";
    String SENTENCE_REGEXP = "(^|(?<=[.!?;]\\s))(\\d+\\.\\s?)*[А-ЯA-Z][^!?]*?[.!?;](?=\\s*(\\d+\\.\\s)*[А-ЯA-Z]|$)";
    String WORD_REGEXP = "\\b([A-Za-zА-Яа-яёЁ\\d]+)\\b[^\\f\\r\\t\\v]?";
    String SYMBOL_REGEXP = "[a-zA-Zа-яёА-ЯЁ0-9]";
    String PUNCT_REGEXP = "[.,!?\'\";:\\(\\)]";
}
