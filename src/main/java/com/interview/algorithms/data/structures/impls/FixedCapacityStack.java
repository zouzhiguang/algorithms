package com.interview.algorithms.data.structures.impls;

import com.interview.algorithms.data.structures.Stack;

import java.util.Iterator;

/**
 * @author: Vincent
 * @since:9:25 PM, 9/5/16
 */
public class FixedCapacityStack<T> extends Stack<T> {

    protected Object[] values;
    protected int counter;

    public FixedCapacityStack(int maxCapacity) {
        values = new Object[maxCapacity];
        this.counter = 0;
    }

    @Override
    public void push(T item) {
        if (counter >= values.length) {
            throw new IndexOutOfBoundsException("stack is already full");
        }

        values[counter++] = item;
    }

    @Override
    public T pop() {
        if (counter <= 0) {
            return null;
        }
        return (T) values[--counter];
    }

    @Override
    public boolean isEmpty() {
        return counter <= 0;
    }

    @Override
    public int size() {
        return counter;
    }

    @Override
    public Iterator<T> iterator() {
        return null;
    }
}
