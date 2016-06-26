package com.interview.leetcode;

/**
 * a smart integer stream that returns the Kth largest value in O(1) time complexity.
 *
 * @author: Vincent
 * @since:11:21 AM, 26/6/2016
 */
public interface IntegerStream {

    /**
     * A client program writes int value
     * into the stream use this method
     */
    void write(int value);

    int get();
}
