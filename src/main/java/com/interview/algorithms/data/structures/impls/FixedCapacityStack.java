package com.interview.algorithms.data.structures.impls;

import java.util.Iterator;
import com.interview.algorithms.data.structures.Stack;

/**
 * @author: Vincent
 * @since:9:25 PM, 9/5/16
 */
public class FixedCapacityStack<T> extends Stack<T>
{

    protected T[] values;
    protected int counter;

    public FixedCapacityStack(int maxCapacity)
    {
        values = (T[]) new Object[maxCapacity];
        this.counter = 0;
    }

    @Override
    public void push(T item)
    {
        if (counter >= values.length)
        {
            throw new IndexOutOfBoundsException("stack is already full");
        }

        values[counter++] = item;
    }

    @Override
    public T pop()
    {
        if (counter <= 0)
        {
            return null;
        }
        return values[--counter];
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
    public Iterator<T> iterator()
    {
       return new Iterator<T>()
       {
           private int cursor = counter;
           @Override
           public boolean hasNext()
           {
               return cursor > 0;
           }

           @Override
           public T next()
           {
               return values[--cursor];
           }
       };
    }
}
