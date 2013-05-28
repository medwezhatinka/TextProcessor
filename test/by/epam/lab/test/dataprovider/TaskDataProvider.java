/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package by.epam.lab.test.dataprovider;

import by.epam.lab.model.entity.Symbol;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.ResourceBundle;
import java.util.Set;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

/**
 *
 * @author Soldier
 */
public class TaskDataProvider {

    @DataProvider(name = "dataSymbol")
    public Object[][] getData(Method m) {
        Object data[][] = null;
        Set<String> keySet;
        int size;
        ArrayList<String> list = new ArrayList<>();
        String[] groups = m.getAnnotation(Test.class).groups();
        for (String group : groups) {
            switch (group) {
                case Group.VOWEL_SYMBOL:
                    String value;
                    ResourceBundle resourceBundleVowel = ResourceBundle.getBundle("resources.vowel");
                    keySet = resourceBundleVowel.keySet();
                    for (String key : keySet) {
                        value = resourceBundleVowel.getString(key);
                        if (value.equalsIgnoreCase("null")) {
                            value = null;
                        }
                        list.add(value);
                    }
                    size = list.size();
                    data = new Object[size][1];
                    for (int i = 0; i < size; i++) {
                        data[i][0] = list.get(i);
                    }
                    break;
                case Group.CONSONANT_SYMBOL:
                    ResourceBundle resourceBundleConsonant = ResourceBundle.getBundle("resources.consonant");
                    keySet = resourceBundleConsonant.keySet();
                    for (String key : keySet) {
                        list.add(resourceBundleConsonant.getString(key));
                    }
                    break;
                case Group.NOTVALID_SYMBOL:
                    ResourceBundle resourceBundleNotValidSymbol = ResourceBundle.getBundle("resources.notvalidsymbol");
                    keySet = resourceBundleNotValidSymbol.keySet();
                    for (String key : keySet) {
                        value = resourceBundleNotValidSymbol.getString(key);
                        if (value.equalsIgnoreCase("null")) {
                            value = null;
                        }
                        list.add(value);
                    }
                    break;
                case Group.PUNCTUATION:
                      ResourceBundle resourceBundlePunct = ResourceBundle.getBundle("resources.punctuation");
                    keySet = resourceBundlePunct.keySet();
                    for (String key : keySet) {
                        value = resourceBundlePunct.getString(key);
                        if (value.equalsIgnoreCase("null")) {
                            value = null;
                        }
                        list.add(value);
                    }
                    break;
            }
        }

        size = list.size();
        data = new Object[size][1];
        for (int i = 0; i < size; i++) {

            data[i][0] = list.get(i);
        }
        return data;


    }

    @DataProvider(name = "dataWord")
    public Object[][] getDataWord(Method m) {
        Object data[][] = null;
        Set<String> keySet;
        int size;
        String value ;
        Symbol symbol;
        ResourceBundle resourceBundle;
        ArrayList<Symbol> list = new ArrayList<>();
        String[] groups = m.getAnnotation(Test.class).groups();
        for (String group : groups) {
            switch (group) {
                case Group.NULL_WORD:

                    resourceBundle = ResourceBundle.getBundle("resources.null");
                    keySet = resourceBundle.keySet();
                    for (String key : keySet) {
                        value = resourceBundle.getString(key);

                        if (value.equalsIgnoreCase("null")) {
                            symbol = null;
                        } else {
                            symbol = new Symbol(value);
                        }
                        list.add(symbol);
                    }
                    size = list.size();
                    data = new Object[size][1];
                    for (int i = 0; i < size; i++) {

                        data[i][0] = list.get(i);
                    }
                    break;
                case Group.POSITIVE_WORD:
                    ArrayList<ArrayList<Symbol>> listSymbols = new ArrayList<>();
                    resourceBundle = ResourceBundle.getBundle("resources.positiveword");
                    keySet = resourceBundle.keySet();
                    for (String key : keySet) {
                        value = resourceBundle.getString(key);
                        String[] split = value.split(" ");
                        for (int i = 0; i < split.length; i++) {
                            if (!split[i].isEmpty()) {
                                symbol = new Symbol(split[i]);
                                list.add(symbol);
                            }

                        }

                        listSymbols.add(list);
                    }
                    size = listSymbols.size();
                    data = new Object[size][1];
                    for (int i = 0; i < size; i++) {

                        data[i][0] = listSymbols.get(i);
                    }
                    break;
            }
        }
        return data;

    }
    
    
}
