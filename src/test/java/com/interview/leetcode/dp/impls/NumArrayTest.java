package com.interview.leetcode.dp.impls;

import com.interview.algorithms.princeton.CommonTest;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;


/**
 * @author: Vincent
 * @since:12:40 PM, 7/8/2016
 */
public class NumArrayTest extends CommonTest {

    @Test(dataProvider = "prepareInstance")
    public void testCanWork(String description, int[] array) {
        logger.debug(description);
        NumArray numArray = new NumArray(array);

        Assert.assertEquals(numArray.getCord(0, 1), 1);
    }

    @DataProvider
    @Override
    protected Object[][] prepareInstance() {
        return new Object[][] {
            {"NumArrayTest", new int[] {-9, 5, 7, 2, -4}}
        };
    }
}
