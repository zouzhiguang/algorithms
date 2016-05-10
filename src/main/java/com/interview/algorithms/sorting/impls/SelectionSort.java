package com.interview.algorithms.sorting.impls;

import com.interview.algorithms.sorting.Sorting;

/**
 * always select the minimum and swap to the head for each loop
 *
 * @author: Vincent
 * @since:12:10 PM, 10/5/16
 */
public class SelectionSort<T extends Comparable> extends Sorting<T> {

    @Override
    public void sort(T[] values) {
        for (int i = 0; i < values.length; i ++){
            int minimum = i;
            for(int j=i; j < values.length; j++){
                // find the minimum
                if(values[j].compareTo(values[minimum]) < 0){
                    minimum = j;
                }
            }
            if(minimum != i){
                swap(values, i, minimum);
            }
        }
    }
}
