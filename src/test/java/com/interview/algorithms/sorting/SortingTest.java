package com.interview.algorithms.sorting;

import java.util.Collections;
import java.util.List;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import com.google.common.base.Joiner;
import com.google.common.collect.ContiguousSet;
import com.google.common.collect.DiscreteDomain;
import com.google.common.collect.Lists;
import com.google.common.collect.Range;
import com.interview.algorithms.princeton.CommonTest;
import com.interview.algorithms.sorting.impls.BottomUpMergeSort;
import com.interview.algorithms.sorting.impls.InsertionSort;
import com.interview.algorithms.sorting.impls.MergeSort;
import com.interview.algorithms.sorting.impls.QuickSort;
import com.interview.algorithms.sorting.impls.SelectionSort;
import com.interview.algorithms.sorting.impls.ShellSort;
import com.interview.algorithms.sorting.impls.ThreeWayQuickSort;

/**
 * @author: Vincent
 * @since:10:21 PM, 10/5/16
 */
public class SortingTest extends CommonTest {

    @Test(dataProvider = "prepareInstance")
    public void testSort(String description, Sorting<Integer> sorting) throws Exception {
        logger.debug(description);
        List<Integer> integers = Lists.newArrayList(ContiguousSet.create(Range.closed(0,40000), DiscreteDomain.integers()).asList());
        Collections.shuffle(integers);
        Integer[] values = integers.toArray(new Integer[0]);
        logger.debug("Before: {}", Joiner.on(',').join(values).substring(0,100));
        long startTime = System.nanoTime();
        sorting.sort(values);
        long endTime = System.nanoTime();
        logger.debug("After: {}", Joiner.on(',').join(values).substring(0,100));
        logger.debug("{} takes {} millis to sort 40000 integers.", sorting.getClass().getSimpleName(), (endTime - startTime) / 1000000);

        for(int i = 0; i < integers.size(); i++){
            Assert.assertEquals(values[i].intValue(), i);
        }
    }

    @DataProvider
    @Override
    protected Object[][] prepareInstance() {
        return new Object[][]{
            {"Sorting algorithms, Selection Sort", new SelectionSort<Integer>()},
            {"Sorting algorithms, Insertion Sort", new InsertionSort<Integer>()},
            {"Sorting algorithms, Shell Sort with 3-sort", new ShellSort<Integer>()},
            {"Sorting algorithms, Merge Sort", new MergeSort<Integer>()},
            {"Sorting algorithms, Bottom Up Merge Sort", new BottomUpMergeSort<Integer>()},
            {"Sorting algorithms, Random Quick Sort", new QuickSort<Integer>()},
            {"Sorting algorithms, 3-Way Quick Sort", new ThreeWayQuickSort<Integer>()}
        };
    }
}
