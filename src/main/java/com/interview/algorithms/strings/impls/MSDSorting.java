package com.interview.algorithms.strings.impls;

import java.util.List;
import com.interview.algorithms.strings.IndexCountingSort.StringIndexSort;
import com.interview.algorithms.strings.StrirngSorting;

/**
 * @author: vzou
 * *
 * @since: 6/6/2016.
 */
public class MSDSorting implements StrirngSorting
{
    @Override
    public String[] sort(String[] strings, int length)
    {
        StringIndexSort stringIndexSort = new StringIndexSort(255, strings.length);
        for (int i = 0; i < length; i++){
            stringIndexSort.sort(strings, i);
            int[] counts = stringIndexSort.getCounts();
            // split the counts into sub arrays, then sort the sub-array accordingly.

        }
    }


}
