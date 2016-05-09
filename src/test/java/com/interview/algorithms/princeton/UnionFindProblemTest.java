package com.interview.algorithms.princeton;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

/**
 * @author: vzou
 * *
 * @since: 5/9/2016.
 */

public class UnionFindProblemTest extends CommonTest
{
    @Test(dataProvider = "prepareInstance")
    public void testIsConnected(String description, UnionFindProblem solution) throws Exception
    {
        logger.debug(description);

        solution.union(1, 8);
        solution.union(3, 7);
        solution.union(9, 6);
        solution.union(0, 4);
        solution.union(6, 1);
        solution.union(7, 4);

        Assert.assertTrue(solution.isConnected(3, 4));
        Assert.assertTrue(solution.isConnected(9, 8));
        Assert.assertTrue(solution.isConnected(1, 9));
        Assert.assertTrue(solution.isConnected(3, 0));

        Assert.assertFalse(solution.isConnected(9, 4));
        Assert.assertFalse(solution.isConnected(0, 1));
        Assert.assertFalse(solution.isConnected(6, 3));
    }

    @DataProvider
    @Override
    protected Object[][] prepareInstance()
    {
        return new Object[][]{
            {"QuickFind test", new UnionFindProblem.QuickFind(10)},
            {"QuickUnion test", new UnionFindProblem.QuickUnion(10)},
            {"WeightedUnion test", new UnionFindProblem.WeightedUnion(10)},
            {"WeightedUnionWithPathCompression test", new UnionFindProblem.WeightedUnionWithPathCompression(10)}

        };
    }
}
