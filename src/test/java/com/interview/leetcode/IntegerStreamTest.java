package com.interview.leetcode;

import com.interview.algorithms.princeton.CommonTest;
import com.interview.leetcode.impls.IntegerStreamMinHeap;
import com.interview.leetcode.impls.IntegerStreamPriorityQueue;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.util.List;

import static com.google.common.collect.Lists.newArrayList;

/**
 * @author: Vincent
 * @since:11:24 AM, 26/6/2016
 */
public class IntegerStreamTest extends CommonTest {
    private static int GET = Integer.MIN_VALUE;


    @Test(dataProvider = "prepareInstance")
    public void testCanWriteAndGet(String description, IntegerStream stream, List<Integer> data, List<Integer> expected) {
        logger.debug(description);
        List<Integer> result = newArrayList();
        for (Integer i : data) {
            if (i == GET) {
                result.add(stream.get());
            } else {
                stream.write(i);
            }
        }

        Assert.assertEquals(result, expected, "Un-Matching result, actual is:<" + result + "> while expecting:<" + expected + ">.");
    }

    @DataProvider
    @Override
    protected Object[][] prepareInstance() {
        return new Object[][] {
            {"IntegerStream, IntegerStreamPriorityQueue implementation test 1", new IntegerStreamPriorityQueue(3), newArrayList(1, 2, 3, 4, 5, GET, 6, GET, 6, 6, GET), newArrayList(3, 4, 6)},
            {"IntegerStream, IntegerStreamMinHeap implementation test 1", new IntegerStreamMinHeap(3), newArrayList(1, 2, 3, 4, 5, GET, 6, GET, 6, 6, GET), newArrayList(3, 4, 6)}
        };
    }
}
