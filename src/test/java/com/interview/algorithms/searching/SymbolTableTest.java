package com.interview.algorithms.searching;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import com.interview.algorithms.princeton.CommonTest;
import com.interview.algorithms.searching.impls.BinarySearchTable;

/**
 * @author: vzou
 * *
 * @since: 5/19/2016.
 */
public class SymbolTableTest extends CommonTest
{

    @Test(dataProvider = "prepareInstance")
    public void testSymbolTable(String description, SymbolTable<Integer, String> table){
        logger.debug(description);

        Assert.assertTrue(table.isEmpty(), "Table after init should be empty");
        Assert.assertNull(table.get(123));

        table.put(123,"123");
        table.put(456,"456");
        table.put(1,"1");

        // should be not 1, 123, 456,

        Assert.assertEquals(table.get(1), "1");
        Assert.assertEquals(table.size(), 3);
        Assert.assertEquals(table.delete(123), "123");

        Assert.assertNull(table.get(123));

    }

    @DataProvider
    @Override
    protected Object[][] prepareInstance()
    {
        return new Object[][]{
            {"Validating SymbolTable, BinarySearchTable implementation.", new BinarySearchTable<Integer, String>()}
        };
    }
}
