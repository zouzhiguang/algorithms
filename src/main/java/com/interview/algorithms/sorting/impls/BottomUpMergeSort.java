package com.interview.algorithms.sorting.impls;

/**
 * @author: vzou
 * *
 * @since: 5/12/2016.
 */
public class BottomUpMergeSort<T extends Comparable<T>> extends MergeSort<T>
{
    @Override
    public void sort(T[] values)
    {
        int  length = values.length;
        cache = (T[]) new Comparable[length];
        for (int size = 1; size < length; size+= size){
            // to iteratively merge 2/4/8/..../2^n which is 2^n+1 > length.
            // as 2^n+1 > length, so it would externally loop log2 Length + 1 times, which is O(lgN).
            // for length = 16, size = 1, it should be (0~1,2~3) , ... (22~13, 14~15);
            for(int low = 0; low < length - size; low += size * 2){
                // need to ensure low + size - 1 < length, and right part have at least one element to merge (or else it's insertion sort),
                // so either 1. (low + size -1 < low + size * 2 - 1) or 2. (low + size -1 < length -1) always be true.
                // 1. is always true as size > 0, for statement 2, low < length - size should always true.
                merge(values, low, low + size - 1, Math.min((low + size * 2 - 1), length - 1));
            }
        }
    }
}
