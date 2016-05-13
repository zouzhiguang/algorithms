package com.interview.algorithms.sorting.impls;

/**
 * @author: vzou
 * *
 * @since: 5/13/2016.
 */
public class ThreeWayQuickSort<T extends Comparable<T>> extends QuickSort<T>
{
    @Override
    protected void sort(T[] values, int low, int high)
    {
        if (low >= high)
        {
            return;
        }

        int lessThan = low, cursor = low + 1, greaterThan = high;

        T value = values[low];

        while (cursor <= greaterThan)
        {
            int compare = values[cursor].compareTo(value);

            if (compare > 0)
            {
                // cursor element is bigger than the pivot,move to right of greaterThan, move greaterThan leftward
                swap(values, cursor, greaterThan--);
            }
            else if (compare < 0)
            {
                // cursor element is smaller than the pivot, move to the left of lessThan, and move lessThan and cursor rightward
                swap(values, lessThan++, cursor++);
            }
            else
            {
                // cursor element should be kept within left ~ cursor, just simply move cursor rightward
                cursor++;
            }
        }

        // sort low ~ lessThan
        sort(values, low, lessThan - 1);

        // sort greaterThan ~ high
        sort(values, greaterThan + 1, high);
    }
}
