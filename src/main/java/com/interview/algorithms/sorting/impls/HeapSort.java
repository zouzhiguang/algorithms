package com.interview.algorithms.sorting.impls;

import com.interview.algorithms.sorting.Sorting;
import com.interview.algorithms.sorting.pq.impls.HeapPriorityQueue;

/**
 * @author: vzou
 * *
 * @since: 5/16/2016.
 */
public class HeapSort<T extends Comparable<T>> extends Sorting<T>
{
    @Override
    public void sort(T[] values)
    {
       new HeapPriorityQueue<>(values).sort();
    }
}
