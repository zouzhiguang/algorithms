package com.interview.algorithms.searching;

/**
 * @author: vzou
 * *
 * @since: 5/18/2016.
 */
public interface SymbolTable<Key, Value>
{
    /**
     * put key-value pair into the table, remove key from table if value is null
     * @param key
     * @param value
     */
    void put(Key key, Value value);

    /**
     * return value paired with key, null if key is absent
     * @param key
     * @return
     */
    Value get(Key key);

    /**
     * remove key (and its value) from table
     * @param key
     * @return
     */
    Value delete(Key key);

    /**
     * is there a value paired with key?
     * @param key
     * @return
     */
    boolean contains(Key key);

    /**
     * is the table empty?
     * @return
     */
    boolean isEmpty();

    /**
     * number of key-value pairs in the table
     * @return
     */
    int size();

    /**
     * all the keys in the table
     * @return
     */
    Iterable<Key> keys();
}
