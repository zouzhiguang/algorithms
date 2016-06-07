package com.interview.algorithms.strings.impls;

import com.interview.algorithms.strings.StrirngSorting;

/**
 * @author: vzou
 * *
 * @since: 6/6/2016.
 */
public class MSDSorting implements StrirngSorting
{
    private static final int DEFAULT_CUT_OFF = 15; // if string sub-array length is smaller than cut-off, would use insertion sort to sort the elements.
    private static final int R = 256;

    @Override
    public String[] sort(String[] strings, int length)
    {
        // for MSD, the length is not a constraints as it can sort strings with different length.
        return sort(strings);
    }

    private String[] sort(String[] sources)
    {
        sort(sources, 0, sources.length -1, 0, new String[sources.length]);
        return sources;
    }

    private void sort(String[] sources, int low, int high, int digit, String[] aux){
        if(high < low  + DEFAULT_CUT_OFF){
            insertionSort(sources, low, high);
            return;
        }

        // count[0] used for marking of the end of strings,
        // count[1 ~ R+1] is used for position indexing.
        int[] count = new int[R + 2];

        // firstly count
        for(int i = low; i <= high; i++){
            count[charAt(sources[i], digit) + 2]++;
        }

        // add up to index
        for(int i = 1; i < R+2; i++){
            count[i] += count[i-1];
        }

        // insert into aux
        for (int i = low; i <= high; i++ ){
            aux[count[charAt(sources[i], digit)]++] = sources[i];
        }

        // copy back
        for(int i = low; i <= high; i++){
            sources[i] = aux[i];
        }

        // 0 is for null character already, do need to loop again?
        for (int r = 1; r < R; r++){
            sort(sources, low + count[r], low + count[r+1] - 1, digit + 1, aux);
        }
    }

    private int charAt(String s, int digit){
        if(digit >= s.length()){
            // already index out of array, would treat it as -1 to put at the very start of the array.
            return -1;
        }

        return s.charAt(digit);
    }

    private void insertionSort(String[] sources, int low, int high)
    {
        for (int i = low; i <= high; i++)
        {
            for (int j = i; j > low; j--)
            {
                if (sources[j].compareTo(sources[j - 1]) < 0)
                {
                    swap(sources, j, j - 1);
                }
            }
        }
    }

    private void swap(String[] sources, int j, int i)
    {
        String tmp = sources[i];
        sources[i] = sources[j];
        sources[j] = tmp;
    }

}
