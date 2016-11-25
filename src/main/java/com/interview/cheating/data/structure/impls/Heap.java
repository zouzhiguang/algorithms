package com.interview.cheating.data.structure.impls;

public interface Heap<Value>
{
    void add(Value value);

    void remove(Value value);

    Value max();

    Value min();

    int size();

    boolean isEmpty();
}
