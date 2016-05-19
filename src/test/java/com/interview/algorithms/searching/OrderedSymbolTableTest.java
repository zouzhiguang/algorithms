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
public class OrderedSymbolTableTest extends CommonTest
{

    @Test(dataProvider = "prepareInstance")
    public void testOrderedSymbolTable(String description, OrderedSymbolTable<Integer, String> table){
        logger.debug(description);

        Assert.assertTrue(table.isEmpty(), "Table after init should be empty");
        Assert.assertNull(table.get(123));

        table.put(123,"123");
        table.put(456,"456");
        table.put(1,"1");
        table.put(2,"2");
        table.put(3,"3");
        table.put(4,"4");
        table.put(5,"5");

        // table should be 456, 123, 5, 4, 3, 2, 1


        Assert.assertEquals(table.ceiling(3).intValue(), 4);
        Assert.assertEquals(table.floor(4).intValue(), 3);
        Assert.assertEquals(table.rank(5), 2);
        Assert.assertEquals(table.select(2).intValue(), 5);
        Assert.assertTrue(table.contains(123));
        Assert.assertFalse(table.contains(345));

        Assert.assertEquals(table.max().intValue(), 456, "max key should be 456");
        Assert.assertEquals(table.min().intValue(), 1, "min key should be 1");
        Assert.assertEquals(table.size(), 7);

        Assert.assertEquals(table.deleteMax(), "456");
        Assert.assertEquals(table.size(), 6);
        Assert.assertEquals(table.max().intValue(), 123, "max key should be 123 after delete 456");


        Assert.assertEquals(table.deleteMin(), "1");
        Assert.assertEquals(table.size(), 5);
        Assert.assertEquals(table.min().intValue(), 2, "min key should be 2 after delete 1");


        Assert.assertNotNull(table.get(4));
        Assert.assertEquals(table.delete(4), "4");
        Assert.assertEquals(table.size(), 4);
        Assert.assertNull(table.get(4));
    }



    @DataProvider
    @Override
    protected Object[][] prepareInstance()
    {
        return new Object[][]{
            {"Validating OrderedSymbolTable, BinarySearchTable implementation.", new BinarySearchTable<Integer, String>()}
        };
    }
}
