package com.interview.cheating.data.structure;

import java.util.Set;

public interface Map<Key, Value>
{
    void put(Key key, Value value);

    Value get(Key key);

    Value remove(Key key);

    boolean containsKey(Key key);

    Set<Key> keys();

    Set<Value> values();

    boolean isEmpty();

    Set<Entry<Key, Value>> entrySet();

    class Entry<Key, Value>{
        public final Key key;
        public Value value;
        public Entry<Key, Value> next;

        public Entry(Key key, Value value)
        {
            this.key = key;
            this.value = value;
        }

        public Key getKey()
        {
            return key;
        }

        public Value getValue()
        {
            return value;
        }

        public void setValue(Value value)
        {
            this.value = value;
        }

        public Entry<Key, Value> getNext()
        {
            return next;
        }

        public void setNext(Entry<Key, Value> next)
        {
            this.next = next;
        }
    }
}
