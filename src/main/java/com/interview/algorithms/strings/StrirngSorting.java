package com.interview.algorithms.strings;

/**
 * @author: vzou
 * *
 * @since: 6/6/2016.
 */
public interface StrirngSorting
{
    /**
     * Sort the given array with the given word length
     * @param strings
     * @param length how long will compare the word length, and actually this can be optional for some algorithms which can fill null chars with '\0'
     * @return
     */
    String[] sort(String[] strings, int length);
}
