package com.interview.leetcode;

import com.google.common.collect.Lists;
import com.interview.algorithms.princeton.CommonTest;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.util.List;

import static com.google.common.collect.Lists.newArrayList;
import static org.testng.Assert.*;

/**
 * @author: Vincent
 * @since:12:18 PM, 26/6/2016
 */
public class ThreeSumTargetNumberTest extends CommonTest{
    ThreeSumTargetNumber threeSumTargetNumber = new ThreeSumTargetNumber();

    @Test(dataProvider = "prepareInstance")
    public void testCanSumTarget(String description, int[] nums, int target, List<List<Integer>> expected){
        logger.debug(description);

        List<List<Integer>> result = threeSumTargetNumber.threeSum(nums, target);

        Assert.assertEquals(result.size(), expected.size(), "size is different");

        Assert.assertTrue(result.containsAll(expected));
        Assert.assertTrue(expected.containsAll(result));

    }


    @DataProvider
    @Override
    protected Object[][] prepareInstance() {
        return new Object[][]{
            {"ThreeSumTargetNumber test 1", new int[]{1,1,2,3,4}, 6, newArrayList(newArrayList(1,2,3), newArrayList(1,1,4))}
        };
    }
}
