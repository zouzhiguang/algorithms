package com.interview.algorithms.data.structures;

/**
 * @author: vzou
 * *
 * @since: 5/9/2016.
 */
public abstract class Stack<T> implements Iterable<T>
{
    /**
     * add an item
     *
     * @param item
     */
    abstract void push(T item);

    /**
     * remove the most recently added item
     *
     * @return
     */
    abstract T pop();

    /**
     * is the bag empty?
     *
     * @return
     */
    abstract boolean isEmpty();

    /**
     * number of items in the bag
     *
     * @return
     */
    abstract int size();
}
