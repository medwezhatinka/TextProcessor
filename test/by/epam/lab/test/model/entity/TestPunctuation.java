/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package by.epam.lab.test.model.entity;

import by.epam.lab.model.entity.Punctuation;
import by.epam.lab.test.dataprovider.Group;
import by.epam.lab.test.dataprovider.TaskDataProvider;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;

/**
 *
 * @author Soldier
 */
public class TestPunctuation  extends TaskDataProvider{
    
   Punctuation punctuation;

   @Test(dataProvider="dataSymbol",groups=Group.NOTVALID_SYMBOL)
   public  void getNullPunctuation(String string){
        punctuation = new Punctuation(string);
        Assert.assertEquals(punctuation.getPunctuation(), null);
   }
   
   @Test(dataProvider="dataSymbol",groups=Group.PUNCTUATION)
   public  void correctPunctuation(String string){
        punctuation = new Punctuation(string);
        Assert.assertEquals(punctuation.getPunctuation(), string);
   }
   
    @AfterMethod
    public void tearDownMethod() throws Exception {
        punctuation = null;
    }
}
