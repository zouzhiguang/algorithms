package com.interview.algorithms.searching.impls;

import java.util.Arrays;
import java.util.Collections;
import com.interview.algorithms.searching.OrderedSymbolTable;

/**
 * @author: vzou
 * *
 * @since: 5/18/2016.
 */
public class BinarySearchTable<Key extends Comparable<Key>, Value> implements OrderedSymbolTable<Key, Value>
{
    private static final int DEFAULT_SIZE = 16;
    private Key[] keys;
    private Value[] values;
    private int counter = 0;

    public BinarySearchTable()
    {
        keys = (Key[]) new Comparable[DEFAULT_SIZE];
        values = (Value[]) new Object[DEFAULT_SIZE];
    }

    protected void resize(){
        int newSize = keys.length * 2;

        Key[] tmpKeys = (Key[]) new Comparable[newSize];
        Value[] tmpValues = (Value[]) new Object[newSize];

        System.arraycopy(keys, 0, tmpKeys, 0, keys.length);
        System.arraycopy(values, 0, tmpValues, 0, values.length);

        keys = tmpKeys;
        values = tmpValues;
    }

    private int index(int n){
        return n - 1;
    }

    @Override
    public Key min()
    {
        if(counter <= 0){
            return null;
        }
        return keys[index(counter)];
    }

    @Override
    public Key max()
    {
        if(counter <= 0){
            return null;
        }
        return keys[0];
    }

    @Override
    public Key floor(Key key)
    {
        int rank = rank(key);
        if(rank + 1 >= counter){
            return null;
        }

        return keys[rank + 1];
    }

    @Override
    public Key ceiling(Key key)
    {
        int rank = rank(key);
        if(rank < 1){
            return null;
        }
        return keys[rank - 1];
    }

    @Override
    public int rank(Key key)
    {
        if(isEmpty()){
            return 0;
        }

        int low = 0, high = counter - 1;
        while (low <= high){
            int middle = (low + high) / 2;
            int compare = key.compareTo(keys[middle]);

            if(compare < 0) low = middle + 1;
            else if (compare > 0) high = middle - 1;
            else return middle;
        }

        return low;
    }

    @Override
    public Key select(int k)
    {
        if(k > counter || k <= 0){
            return null;
        }

        return keys[k];
    }

    @Override
    public Value deleteMin()
    {
        keys[--counter] = null;
        Value value = values[counter];
        values[counter] = null;
        return value;
    }

    @Override
    public Value deleteMax()
    {
        if(isEmpty()){
            return null;
        }

        Value value = values[0];

        if(counter == 1){
            return deleteMin();
        }

        for(int i = 1; i < counter; i++){
            keys[i - 1] = keys[i];
            values[i - 1] = values[i];
        }

        keys[--counter] = null;
        values[counter] = null;
        return value;
    }

    @Override
    public Iterable<Key> keys(Key low, Key high)
    {
        if(isEmpty()){
            return Collections.emptyList();
        }

        int rankHigh = rank(high);
        int rankLow = rank(low);
        return Arrays.asList(Arrays.copyOfRange(keys, rankHigh, rankLow));
    }

    @Override
    public void put(Key key, Value value)
    {
        if(value == null && contains(key)){
            delete(key);
            return;
        }

        if(counter >= keys.length){
            resize();
        }

        int rank = rank(key);

        if (!isEmpty() && rank < counter && keys[rank].compareTo(key) == 0){
            // previous key exist, update column
            values[rank] = value;
            return;
        }

        for (int j = counter; j > rank; j--){
            keys[j] = keys[j - 1];
            values[j] = values[j - 1];
        }

        keys[rank] = key;
        values[rank] = value;
        counter++;
    }

    @Override
    public Value get(Key key)
    {
        int rank = rank(key);

        if(!isEmpty() && rank < counter && keys[rank].compareTo(key) == 0) {
            return values[rank];
        }

        return null;
    }

    @Override
    public Value delete(Key key)
    {
        if(!contains(key)){
            return null;
        }

        int rank = rank(key);
        Value value = values[rank];

        for(int i = rank; i + 1 < counter; i++){
            keys[i] = keys[i + 1];
            values[i] = values[i + 1];
        }

        keys[--counter] = null;
        values[counter] = null;

        return value;
    }

    @Override
    public boolean contains(Key key)
    {
        int rank = rank(key);
        return rank > 0 && keys[rank].compareTo(key) == 0;
    }

    @Override
    public boolean isEmpty()
    {
        return counter <= 0;
    }

    @Override
    public int size()
    {
        return counter;
    }

    @Override
    public Iterable<Key> keys()
    {
        return Arrays.asList(keys);
    }
}
