package com.interview.algorithms.data.structures;

import com.google.common.collect.Lists;
import com.interview.algorithms.data.structures.impls.CombinationSumNoDuplicate040;
import com.interview.algorithms.princeton.CommonTest;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.util.List;

import static com.google.common.collect.Lists.newArrayList;

/**
 * @author: Vincent
 * @since:12:45 PM, 5/7/2016
 */
public class CombinationSumTest extends CommonTest{

    @Test
    public void test(String description, CombinationSum combinationSum, int[] nums, int target, List<List<Integer>> exprected){
        logger.debug(description);

        List<List<Integer>> actual = combinationSum.combinationSum(nums, target);

        Assert.assertEquals(actual.size(), exprected.size(), "size is different");
        Assert.assertTrue(actual.containsAll(exprected));
        Assert.assertTrue(exprected.containsAll(actual));
    }

    @Override
    @DataProvider
    protected Object[][] prepareInstance() {
        return new Object[][]{
            {
                "CombinationSum with no duplicate",
                new CombinationSumNoDuplicate040(),
                new int[]{10, 1, 2, 7, 6, 1, 5},
                8,
                Lists.<List>newArrayList(newArrayList(1, 7), newArrayList(1, 2, 5), newArrayList(1, 1, 6), newArrayList(2, 6))
            }
        };
    }
}
