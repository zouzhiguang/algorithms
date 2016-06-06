package com.interview.algorithms.strings;

/**
 * This implement the R-Way Index Counting Sort algorithms
 *
 * @author: vzou
 * *
 * @since: 6/6/2016.
 */
public abstract class IndexCountingSort<T>
{
    private final int   length;
    private final int   R;
    private       int[] counts;
    private       T[]   aux;

    public IndexCountingSort(int R, int length)
    {
        this.length = length;
        this.R = R;
        // counts from index [0~R]
        counts = new int[R + 1];
        // aux array to copy the sorted array
        aux = (T[]) new Object[length];
    }

    public void sort(T[] sources, int digit)
    {
        // firstly counts
        for (int i = 0; i < length; i++)
        {
            counts[valueOf(sources[i], digit)]++;
        }
        // secondly recompute the count array to add-up the counts to convert it into array of new position index for new array
        for (int i = 1; i <= R; i++)
        {
            counts[i] += counts[i - 1];
        }
        // thirdly fill new aux array with the index setup in count array
        for (int i = 0; i < R; i++)
        {
            aux[counts[valueOf(sources[i], digit)]++] = sources[i];
        }
        // lastly, copy the aux back to source array
        System.arraycopy(aux, 0, sources, 0, length);
    }

    // get the count array of last sort.
    public int[] getCounts()
    {
        return counts;
    }

    /**
     * turn object T into value of [1~R).
     *
     * @param t
     * @return
     */
    public abstract int valueOf(T t, int digit);


    public static class StringIndexSort extends IndexCountingSort<String>
    {

        public StringIndexSort(int R, int length)
        {
            super(R, length);
        }

        @Override
        public int valueOf(String s, int digit)
        {
            return s.charAt(digit);
        }
    }
}
