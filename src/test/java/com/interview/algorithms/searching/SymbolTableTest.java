package com.interview.algorithms.searching;

import com.google.common.collect.ContiguousSet;
import com.google.common.collect.DiscreteDomain;
import com.google.common.collect.Lists;
import com.google.common.collect.Range;
import com.interview.algorithms.searching.impls.BlackRedBinarySearchTree;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import com.interview.algorithms.princeton.CommonTest;
import com.interview.algorithms.searching.impls.BinarySearchTable;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * @author: vzou
 * *
 * @since: 5/19/2016.
 */
public class SymbolTableTest extends CommonTest {

    @Test(dataProvider = "prepareInstance")
    public void testSymbolTable(String description, SymbolTable<Integer, String> table) {
        logger.debug(description);

        Assert.assertTrue(table.isEmpty(), "Table after init should be empty");
        Assert.assertNull(table.get(123));

        ContiguousSet<Integer> integers = ContiguousSet.create(Range.open(0, 100), DiscreteDomain.integers());

        List<Integer> test = Lists.newArrayList(integers);

        Collections.shuffle(test);

        test.forEach(i -> table.put(i, String.valueOf(i)));

        Assert.assertEquals(table.get(1), "1");
        Assert.assertEquals(table.size(), test.size());
//        Assert.assertEquals(table.delete(88), "88");

//        Assert.assertNull(table.get(88));

        List<Integer> result = Lists.newArrayList(table.keys());
        for (int i = 1; i < 100; i++){
            Assert.assertTrue(result.get(i-1) == i, i + "th element should be same with that in the list, however, it's: " + result.get(i-1));
        }
    }

    @DataProvider
    @Override
    protected Object[][] prepareInstance() {
        return new Object[][] {
            {"Validating SymbolTable, BinarySearchTable implementation.", new BinarySearchTable<Integer, String>()},
            {"Validating BST, BlackRedBinarySearchTree implementation.", new BlackRedBinarySearchTree<Integer, String>()}
        };
    }
}
