package com.interview.algorithms.searching;

/**
 * @author: vzou
 * *
 * @since: 5/18/2016.
 */
public interface OrderedSymbolTable<Key extends Comparable<Key>, Value> extends SymbolTable<Key, Value>
{
    /**
     * smallest key
     * @return
     */
    Key min();

    /**
     * largest key
     * @return
     */
    Key max();

    /**
     * largest key less than or equal to key
     * @param key
     * @return
     */
    Key floor(Key key);

    /**
     * smallest key greater than or equal to key
     * @param key
     * @return
     */
    Key ceiling(Key key);

    /**
     * number of keys less than key
     * @param key
     * @return
     */
    int rank(Key key);

    /**
     * key of rank k
     * @param k
     * @return
     */
    Key select(int k);

    /**
     * delete smallest key
     * @return
     */
    Value deleteMin();

    /**
     * delete largest key
     * @return
     */
    Value deleteMax();

    /**
     * keys in [low..high], in sorted order
     * @param low
     * @param high
     * @return
     */
    Iterable<Key> keys(Key low, Key high);
}
