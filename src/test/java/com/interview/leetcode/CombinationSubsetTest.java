package com.interview.leetcode;

import com.google.common.collect.Lists;
import com.interview.algorithms.princeton.CommonTest;
import com.interview.leetcode.impls.CombinationSubSetNoDup;
import com.interview.leetcode.impls.CombinationSubSetWithDup;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.util.List;

/**
 * @author: Vincent
 * @since:11:44 PM, 8/7/2016
 */
public class CombinationSubsetTest extends CommonTest {

    @Test(dataProvider = "prepareInstance")
    public void test(String description, CombinationSubset combinationSubset, int[] A, int K, List<List<Integer>> expected) {
        logger.debug(description);
        List<List<Integer>> lists = combinationSubset.combinationSub(A, K);

        Assert.assertEquals(lists.size(), expected.size(), "size should be same");
        Assert.assertTrue(lists.containsAll(expected));
        Assert.assertTrue(expected.containsAll(lists));
    }

    @Override
    @DataProvider
    protected Object[][] prepareInstance() {
        return new Object[][] {
            {"CombinationSubset with CombinationSubSetNoDup", new CombinationSubSetNoDup(), new int[] {}, 0, Lists.newArrayList()},
            {"CombinationSubset with CombinationSubSetNoDup", new CombinationSubSetNoDup(), new int[] {1, 2, 3, 4, 5}, 4,
                Lists.<List>newArrayList(Lists.newArrayList(1, 2, 3, 4), Lists.newArrayList(1, 2, 3, 5), Lists.newArrayList(2, 3, 4, 5), Lists.newArrayList(1, 3, 4, 5), Lists.newArrayList(1, 2, 4, 5))},
            {"CombinationSubset with CombinationSubSetWithDup", new CombinationSubSetWithDup(), new int[] {}, 0, Lists.newArrayList()},
//            {"CombinationSubset with CombinationSubSetWithDup", new CombinationSubSetWithDup(), new int[] {1, 1, 2, 3, 4, 5}, 4,
//                Lists.<List>newArrayList(
//                    Lists.newArrayList(1, 1, 2, 3),
//                    Lists.newArrayList(1, 1, 2, 4),
//                    Lists.newArrayList(1, 1, 2, 5),
//                    Lists.newArrayList(1, 1, 3, 4),
//                    Lists.newArrayList(1, 1, 3, 5),
//                    Lists.newArrayList(1, 1, 4, 5),
//                    Lists.newArrayList(1, 2, 3, 4),
//                    Lists.newArrayList(1, 2, 3, 5),
//                    Lists.newArrayList(2, 3, 4, 5),
//                    Lists.newArrayList(1, 3, 4, 5),
//                    Lists.newArrayList(1, 2, 4, 5)
//                )
//            }
            {"CombinationSubset with CombinationSubSetWithDup", new CombinationSubSetWithDup(), new int[] {1,1,1,1}, 3, Lists.<List>newArrayList(Lists.newArrayList(1, 1, 1),Lists.newArrayList(1, 1, 1))},
        };
    }
}
