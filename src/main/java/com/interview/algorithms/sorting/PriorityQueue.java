package com.interview.algorithms.sorting;

/**
 * @author: vzou
 * *
 * @since: 5/13/2016.
 */
public abstract class PriorityQueue<Key extends Comparable<Key>>
{
    /**
     * insert a key into the priority queue
     *
     * @param key
     */
    public abstract void insert(Key key);

    /**
     * is the priority queue empty?
     *
     * @return
     */
    public abstract boolean isEmpty();

    /**
     * number of keys in the priority queue
     *
     * @return
     */
    public abstract int size();

}
