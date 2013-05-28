/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package by.epam.lab.test.model.entity;

import by.epam.lab.model.entity.Symbol;
import by.epam.lab.test.dataprovider.Group;
import by.epam.lab.test.dataprovider.TaskDataProvider;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;

/**
 *
 * @author Soldier
 */
public class TestSymbol extends TaskDataProvider {

    Symbol symbol;

    @Test(groups = Group.NOTVALID_SYMBOL, dataProvider = "dataSymbol")
    public void notValidSymbol(String string) {
        symbol = new Symbol(string);
        Assert.assertEquals(symbol.getSymbol(), null);
    }

    @Test(groups = {Group.VOWEL_SYMBOL, Group.NOTVALID_SYMBOL}, dataProvider = "dataSymbol")
    public void isNotConsonant(String string) {
        symbol = new Symbol(string);
        Assert.assertFalse(symbol.isConsonant());
    }

    @Test(groups = Group.CONSONANT_SYMBOL, dataProvider = "dataSymbol")
    public void isConsonant(String string) {
        symbol = new Symbol(string);
        Assert.assertTrue(symbol.isConsonant());
    }

    @AfterMethod
    public void tearDownMethod() throws Exception {
        symbol = null;
    }
}
