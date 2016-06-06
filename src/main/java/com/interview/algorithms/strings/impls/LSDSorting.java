package com.interview.algorithms.strings.impls;

import com.interview.algorithms.strings.IndexCountingSort.StringIndexSort;
import com.interview.algorithms.strings.StrirngSorting;

/**
 * Implements the String sorting using least significant digit radix sorts.
 *
 * @author: vzou
 * *
 * @since: 6/6/2016.
 */
public class LSDSorting implements StrirngSorting
{
    @Override
    public String[] sort(String[] strings, int length)
    {
        StringIndexSort indexCountingSort = new StringIndexSort(255, strings.length);
        for (int i = length - 1; i >= 0; i--)
        {
            indexCountingSort.sort(strings, i);
        }

        return strings;
    }
}
