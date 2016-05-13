package com.interview.algorithms.sorting.impls;

import com.interview.algorithms.sorting.Sorting;

/**
 * @author: Vincent
 * @since:12:24 PM, 10/5/16
 */
public class InsertionSort<T extends Comparable<T>> extends Sorting<T> {

    @Override
    public void sort(T[] values) {
        for (int i=0; i < values.length; i ++){
            for (int j = i; j > 0; j--){
                if(values[j].compareTo(values[j-1]) < 0){
                    swap(values,j,j-1 );
                    continue;
                }
                break;
            }
        }
    }
}
