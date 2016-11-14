package com.interview.crackcode._1_string_and_array;

/**
 * Implement an algorithm to determine if a string has all unique characters. What if you can not use additional data structures?
 */
public class _1_UniqueChars
{
    // one time use boolean, K time could use integer[] to counts, same idea
    public boolean isUniq(String source)
    {
        boolean[] counters = new boolean[256];
        counters[0] = true; // SOH header.

        for (char c : source.toCharArray())
        {
            if (counters[c])
                return false;
            counters[c] = true;
        }
        return true;
    }

    public boolean isUniqOnlyLowerLetters(String source)
    {
        int checker = 0;
        for (int i = 0; i < source.length(); i++)
        {
            int hash = 1 << (source.charAt(i) - 'a');
            if ((checker & hash) != 0)
                return false;
            checker |= hash;
        }

        return true;
    }

    public boolean isUniqNoDataStructure(String source)
    {

        char[] array = source.toCharArray();

        quickSort(array);
        Character last = null;
        for (char c : array)
        {
            if (last != null && last == c)
                return false;
            last = c;
        }

        return true;
    }

    private void quickSort(char[] array)
    {
        quickSort(array, 0, array.length - 1);
    }

    private void quickSort(char[] array, int start, int end)
    {
        int partition = partition(array, start, end);

        quickSort(array, start, partition - 1);
        quickSort(array, partition + 1, end);
    }

    private int partition(char[] array, int start, int end)
    {
        if (start >= end)
        {
            return start;
        }

        char pivot = array[end];

        while (start < end)
        {
            if (array[start] > pivot)
                swap(array, start, end--);
            start++;
        }

        return start;
    }

    private void swap(char[] array, int start, int end)
    {
        char tmp = array[start];
        array[start] = array[end];
        array[end] = tmp;
    }

}
