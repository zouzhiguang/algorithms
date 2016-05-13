package com.interview.algorithms.sorting.impls;

import com.interview.algorithms.sorting.Sorting;

/**
 * @author: vzou
 * *
 * @since: 5/12/2016.
 */
public class QuickSort<T extends Comparable<T>> extends Sorting<T>
{
    @Override
    public void sort(T[] values)
    {
        sort(values, 0, values.length - 1);
    }

    protected void sort(T[] values, int low, int high)
    {
        if (low >= high)
            return;
        int partition = partition(values, low, high);
        sort(values, low, partition - 1);
        sort(values, partition + 1, high);

    }

    /**
     * find the pivot index and swap the value to ensure all the value left is smaller than it and all values right is bigger or equal to it.
     *
     * @param values the array
     * @param low    the low index
     * @param high   the high index
     * @return pivot index
     */
    protected int partition(T[] values, int low, int high)
    {
        T value = values[low];
        int i = low, j = high + 1;
        while (true)
        {
            while (values[++i].compareTo(value) < 0)
            {
                if (i == high)
                {
                    break;
                }
            }

            while (values[--j].compareTo(value) >= 0)
            {
                if (j <= low)
                {
                    break;
                }
            }

            if (i >= j)
            {
                break;
            }

            swap(values, i, j);
        }

        swap(values, low, j);

        return j;
    }
}
