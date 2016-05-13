package com.interview.algorithms.sorting.pq;

import com.interview.algorithms.sorting.PriorityQueue;

/**
 * @author: vzou
 * *
 * @since: 5/13/2016.
 */
public abstract class MaxPQ<T extends Comparable<T>> extends PriorityQueue<T>
{
    /**
     * return the largest key
     *
     * @return
     */
    public abstract T max();

    /**
     * return and remove the largest key
     *
     * @return
     */
    public abstract T delMax();
}
