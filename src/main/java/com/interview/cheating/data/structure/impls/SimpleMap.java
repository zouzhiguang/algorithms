package com.interview.cheating.data.structure.impls;

import java.util.Set;
import com.interview.cheating.data.structure.Map;

public class SimpleMap implements Map<Integer, String>
{
    public static final int   DEFAULT_CAPACITY = 100_000;
    public static final float DEFAULT_FACTOR   = 0.75F;
    public static final int mask = 0x7FFFFFFF;

    private int                      capacity;
    private float                    factor;
    private int                      threshhold;
    private int                      size;
    private Entry<Integer, String>[] tables;

    public SimpleMap()
    {
        this(DEFAULT_CAPACITY, DEFAULT_FACTOR);
    }

    public SimpleMap(int initSize, float factor)
    {
        capacity = initSize;
        this.factor = factor;
        threshhold = (int) (initSize * factor);
        tables = new Entry[capacity];
    }

    @Override
    public synchronized void put(Integer key, String value)
    {
        if(key == null) throw new IllegalArgumentException("Null Key");

        int index = key.hashCode() & mask % capacity;
        if(tables[index] == null) {
            tables[index] = new Entry<>(key, value);
        }else {
            Entry<Integer, String> entry = tables[index];
            while (entry.next != null){
                if(entry.getKey().compareTo(key) == 0){
                    entry.setValue(value);
                    return;
                }

                entry = entry.next;
            }

            if(size > threshhold){
                resize();
            }
            entry.setNext(new Entry<>(key, value));
            size++;
        }
    }

    private synchronized void resize()
    {
        int newCapacity = capacity * 2;
        Entry<Integer, String>[] tmp = new Entry[newCapacity];
        for (Entry<Integer, String> entry : entrySet())
        {
            int index = entry.getKey() & mask % newCapacity;


        }

    }

    @Override
    public synchronized String get(Integer key)
    {

        return null;
    }

    @Override
    public synchronized String remove(Integer integer)
    {
        return null;
    }

    @Override
    public boolean containsKey(Integer key)
    {
        return false;
    }

    @Override
    public Set<Integer> keys()
    {
        return null;
    }

    @Override
    public Set<String> values()
    {
        return null;
    }

    @Override
    public boolean isEmpty()
    {
        return false;
    }

    @Override
    public Set<Entry<Integer, String>> entrySet()
    {
        return null;
    }

    private void rehash()
    {

    }
}
