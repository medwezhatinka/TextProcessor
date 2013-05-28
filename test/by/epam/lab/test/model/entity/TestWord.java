/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package by.epam.lab.test.model.entity;

import by.epam.lab.model.entity.Symbol;
import by.epam.lab.model.entity.Word;
import by.epam.lab.runner.TaskConstants;
import by.epam.lab.test.dataprovider.Group;
import by.epam.lab.test.dataprovider.TaskDataProvider;
import java.util.Iterator;
import java.util.List;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;

/**
 *
 * @author Soldier
 */
public class TestWord extends TaskDataProvider{
    Word word;
    
    @Test(dataProvider="dataWord", groups=Group.NULL_WORD)
    public  void getNullValue(List<Symbol> list) {
        word = new Word(list);
          Assert.assertNull(word.getWord());
    }
@Test(dataProvider="dataWord", groups=Group.NULL_WORD)
    public  void getNullValueString(List<Symbol> list) {
        word = new Word(list);
        Assert.assertEquals(word.getValue(), TaskConstants.EMPTY_STRING);
    }
@Test(dataProvider="dataWord", groups=Group.NULL_WORD)
    public  void getNullLength(List<Symbol> list) {
        word = new Word(list);
          Assert.assertEquals(word.length(),0);
    }
 @Test(dataProvider="dataWord", groups=Group.POSITIVE_WORD)
    public  void correctWord(List<Symbol> list) {
        word = new Word(list);
        Iterator<Symbol> iterator = list.iterator();
      Iterator<Symbol> iteratorWord =word.getWord();
        for (Iterator<Symbol> it = list.iterator(); it.hasNext();) {
         Symbol symbol = it.next();
         Assert.assertEquals(iteratorWord.next(),symbol);
     }
        
    }

    @AfterMethod
    public void tearDownMethod() throws Exception {
        word = null;
    }
}
