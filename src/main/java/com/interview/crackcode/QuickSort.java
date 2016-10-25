package com.interview.crackcode;

import java.util.Arrays;
import com.interview.algorithms.sorting.Sorting;

public final class QuickSort extends Sorting<Integer>
{
    @Override
    public void sort(Integer[] values)
    {
        if (values == null)
        {
            return;
        }

        sort(values, 0, values.length - 1);
    }

    public void sort(Integer[] values, int start, int end)
    {
        if (start > end)
        {
            return;
        }

        int pivot = partition(values, start, end);
        sort(values, start, pivot - 1);
        sort(values, pivot + 1, end);
    }

    public int partition(Integer[] values, int start, int end)
    {
        int val = values[end];
        int i = start - 1;
        for (int j = start; j <= end; j++)
            if (values[j] <= val)
                swap(values, ++i, j);

        return i;
    }

    public static void main(String... args)
    {
        QuickSort quickSort = new QuickSort();
        Integer[] test1 = {5, 4, 3, 2, 1};
        Integer[] test2 = {1, 2, 3, 4, 5};
        Integer[] test3 = {1, 5,1,1,6,4};
        quickSort.sort(test1);
        quickSort.sort(test2);
        quickSort.sort(test3);

        System.out.println(Arrays.toString(test1));
        System.out.println(Arrays.toString(test2));
        System.out.println(Arrays.toString(test3));
    }
}
