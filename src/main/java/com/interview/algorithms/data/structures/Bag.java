package com.interview.algorithms.data.structures;

/**
 * @author: vzou
 * *
 * @since: 5/9/2016.
 */
public abstract class Bag<T> implements Iterable<T>
{
    /**
     * add an item
     *
     * @param item
     */
    public abstract void add(T item);

    /**
     * is the bag empty?
     *
     * @return
     */
    public abstract boolean isEmpty();

    /**
     * number of items in the bag
     *
     * @return
     */
    public abstract int size();
}
