package com.interview.data.struture;

import java.util.Arrays;
import java.util.Collection;
import java.util.Locale;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

public class SimpleHashMap<Key, Value> implements Map<Key, Value>
{
    private int   capacity;
    private float loadFactor;
    private int   threshold;
    private transient int   size;
    private transient Entry<Key, Value>[] table;

    public SimpleHashMap(int capacity, float loadFactor)
    {
        if (capacity < 0 || Float.isNaN(loadFactor) || loadFactor < 0)
            throw new IllegalArgumentException(
                String.format(Locale.getDefault(), "Invalid argument for initialization for SimpleMap: expect capacity is positive integer while is %d, factor is positive float while is %f", capacity, loadFactor));
        this.loadFactor = loadFactor;
        this.capacity = capacity;
        threshold = (int) (capacity * loadFactor);
        table = new Entry[capacity];
    }

    @Override
    public int size()
    {
        return size;
    }

    @Override
    public boolean isEmpty()
    {
        return size == 0;
    }

    @Override
    public boolean containsKey(Object key)
    {
        return get(key) != null;
    }

    @Override
    public boolean containsValue(Object value)
    {
        return false;
    }

    @Override
    public synchronized Value get(Object key)
    {
        return null;
    }

    @Override
    public synchronized Value put(Key key, Value value)
    {
        return null;
    }

    @Override
    public Value remove(Object key)
    {
        return null;
    }

    @Override
    public void putAll(Map<? extends Key, ? extends Value> m)
    {
        m.entrySet().forEach(entry -> put(entry.getKey(), entry.getValue()));

    }

    @Override
    public void clear()
    {
        size = 0;
        table = new Entry[capacity];
    }

    @Override
    public Set<Key> keySet()
    {
        return Arrays.stream(table).map(Entry::getKey).collect(Collectors.toSet());
    }

    @Override
    public Collection<Value> values()
    {
        return Arrays.stream(table).map(Entry::getValue).collect(Collectors.toSet());
    }

    @Override
    public Set<Entry<Key, Value>> entrySet()
    {
        return Arrays.stream(table).collect(Collectors.toSet());
    }
}
