package com.interview.algorithms.sorting.pq.impls;

import com.interview.algorithms.sorting.pq.MaxPQ;

/**
 * Binary Tree Implementation of Priority Queue.
 *
 * @author: vzou
 * *
 * @since: 5/13/2016.
 */
public class HeapPriorityQueue<T extends Comparable<T>> extends MaxPQ<T>
{
    private int counter = 0;
    private static final int ROOT = 1;

    private static final int DEFAULT_SIZE = 8;

    protected T[] values = (T[]) new Comparable[DEFAULT_SIZE];

    public HeapPriorityQueue(T[] values)
    {
        this.values = values;
        this.counter = values.length;
        reorder();
    }

    protected void reorder(){
        for (int i = counter / 2; i >= ROOT; i--){
            sink(i);
        }
    }

    public void sort(){
        while (counter > ROOT){
            // swap last and root, and del last.
            swap(ROOT, counter--);
            sink(ROOT);
        }
    }

    protected void resize(){
        int newLength = values.length * 2;
        T[] tmp = (T[]) new Comparable[newLength];
        System.arraycopy(values, index(ROOT), tmp, index(ROOT), values.length);
        values = tmp;
    }

    @Override
    public T max()
    {
        return values[index(ROOT)];
    }

    @Override
    public T delMax()
    {
        T max = max();
        swap(ROOT, counter);
        values[index(--counter)] = null;
        sink(ROOT);
        return max;
    }

    @Override
    public void insert(T t)
    {
        if(counter >= values.length){
            resize();
        }
        values[index(counter++)] = t;
        swim(counter);
    }

    @Override
    public boolean isEmpty()
    {
        return counter <= 0;
    }

    @Override
    public int size()
    {
        return counter;
    }

    protected int parent(int k)
    {
        return k / 2;
    }

    /**
     * reorder the tree for newly inserted child to ensure the children is smaller than parent (root).
     *
     * @param child
     */
    protected void swim(int child)
    {
        while (child > ROOT && less(parent(child), child))
        {
            swap(parent(child), child);
            child = parent(child);
        }

    }

    protected void sink(int base)
    {
        while (base * 2 <= counter)
        {
            int k = base * 2;
            if (k < counter && less(k, k + 1))
            {
                k++;
            }
            if (!less(base, k))
            {
                break;
            }

            swap(base, k);
            base = k;
        }
    }

    protected boolean less(int first, int second)
    {
        return values[index(first)].compareTo(values[index(second)]) < 0;
    }

    protected int index(int k){
        return k - 1;
    }

    protected void swap(int first, int second){
        swap(values, index(first), index(second));
    }
}
