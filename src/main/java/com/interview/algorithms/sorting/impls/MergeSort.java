package com.interview.algorithms.sorting.impls;

import com.interview.algorithms.sorting.Sorting;

/**
 * Merge sort
 *
 * @author: Vincent
 * @since:10:20 PM, 10/5/16
 */
public class MergeSort<T extends Comparable<T>> extends Sorting<T>
{
    protected T[] cache;
    @Override
    public void sort(T[] values)
    {
        cache = (T[]) new Comparable[values.length];
        sort(values, 0, values.length - 1);
    }

    public void sort(T[] values, int low, int high)
    {
        if (high <= low)
        {
            return;
        }

        int mid =  (high + low) / 2;

        sort(values, low, mid);
        sort(values, mid + 1, high);
        merge(values, low, mid, high);
    }

    public void merge(T[] values, int low, int mid, int high)
    {
        int start1 = low;
        int start2 = mid + 1;

        System.arraycopy(values, low, cache, low, high - low + 1);
        for (int i = low; i <= high; i++)
        {
            if (start1 > mid)
            {
                values[i] = cache[start2++];
            }
            else if (start2 > high)
            {
                values[i] = cache[start1++];
            }
            // must use 'cache' array to fetch values as 'values' array is keeping changing with growth of i, the data would be obsolete if read 'values' array
            else if (cache[start1].compareTo(cache[start2]) < 0)
            {
                values[i] = cache[start1++];
            }
            else
            {
                values[i] = cache[start2++];
            }
        }
    }
}
