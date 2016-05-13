package com.interview.algorithms.sorting.impls;

import com.interview.algorithms.sorting.Sorting;

/**
 * @author: Vincent
 * @since:1:13 PM, 10/5/16
 */
public class ShellSort<T extends Comparable<T>> extends Sorting<T> {
    @Override
    public void sort(T[] values) {
        int length = values.length;

        // set incremental
        int h = 1;
        while (h < length/3){
            h = 3 * h + 1;
        }

        for(; h >= 1; h/=3 ){
            for(int i =h; i< length; i++ ){
                for (int j = i; j >= h && (values[j].compareTo(values[j-h]) < 0); j-=h){
                    swap(values, j, j-h);
                }
            }
        }
    }
}
