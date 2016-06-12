package com.interview.leetcode;

import com.google.common.collect.Lists;
import com.interview.algorithms.princeton.CommonTest;
import com.interview.leetcode.impls.MinimalHeightTreesDetachLeafSolution;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.util.List;

/**
 * @author: Vincent
 * @since:11:01 AM, 11/6/2016
 */
public class MinimalHeightTrees310Test extends CommonTest {

    @Test(dataProvider = "prepareInstance")
    public void testFindMinHeightTrees(String description, MinimalHeightTrees310 solution, int n, int[][] edges, List<Integer> results) throws Exception {
        logger.debug(description);

        List<Integer> integers =  solution.findMinHeightTrees(n, edges);

        Assert.assertTrue(results.containsAll(integers));
        Assert.assertTrue(integers.containsAll(results));
    }

    @DataProvider
    @Override
    protected Object[][] prepareInstance() {
        return new Object[][]{
            {"MinimalHeightTrees310Test detach leaf implementation test 1", new MinimalHeightTreesDetachLeafSolution(), 1, new int[][]{}, Lists.newArrayList(0)},
            {"MinimalHeightTrees310Test detach leaf implementation test 1", new MinimalHeightTreesDetachLeafSolution(), 2, new int[][]{{1, 0}}, Lists.newArrayList(0, 1)},
            {"MinimalHeightTrees310Test detach leaf implementation test 1", new MinimalHeightTreesDetachLeafSolution(), 4, new int[][]{{1, 0}, {1, 2}, {1, 3}}, Lists.newArrayList(1)},
            {"MinimalHeightTrees310Test detach leaf implementation test 2", new MinimalHeightTreesDetachLeafSolution(), 6, new int[][]{{0, 3}, {1, 3}, {2, 3}, {4, 3}, {5, 4}}, Lists.newArrayList(3,4)},
//            {"MinimalHeightTrees310Test dfs implementation test 2", new MinimalHeightTreesDetailLeafSolution(), 100, generateContiniousLargeLinkTree(100), Lists.newArrayList(49,50)},
//            {"MinimalHeightTrees310Test dfs implementation test 2", new MinimalHeightTreesDetailLeafSolution(), 5000, generateContiniousLargeLinkTree(5000), Lists.newArrayList(2499,2500)},
//            {"MinimalHeightTrees310Test dfs implementation test 2", new MinimalHeightTreesDetailLeafSolution(), 5001, generateContiniousLargeLinkTree(5001), Lists.newArrayList(2500)}
        };
    }

//    private static int[][] generateContiniousLargeLinkTree(int n){
//        int[][] result = new int[2][n-1];
//
//        for(int i=0;  i<n-1; i++){
//            result[i] = new int[]{i, i+1};
//        }
//
//        return result;
//    }
}
