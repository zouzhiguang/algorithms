package com.interview.algorithms.data.structures;

/**
 * FIFO queue
 *
 * @author: vzou
 * *
 * @since: 5/9/2016.
 */
public abstract class Queue<T> implements Iterable<T>
{
    /**
     * add an item
     *
     * @param t
     */
    abstract void enqueue(T t);

    /**
     * remove the least recently added item
     *
     * @return
     */
    abstract T dequeue();

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
