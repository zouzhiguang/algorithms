package com.interview.algorithms.sorting;

/**
 * @author: Vincent
 * @since:12:09 PM, 10/5/16
 */
public abstract class Sorting<T extends Comparable> {
    public abstract void sort(T[] values);

    protected void swap(T[] values, int indexA, int indexB){
        T tmp = values[indexA];
        values[indexA] = values[indexB];
        values[indexB] = tmp;
    }
}
