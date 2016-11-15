package com.interview.cheating.data.structure.impls;

import com.interview.cheating.data.structure.Stack;

public class ArrayListStack implements Stack
{
    private static final int INIT_SIZE = 16;

    private int[] entries;
    private int   counter;
    private int   size;

    public ArrayListStack()
    {
        entries = new int[INIT_SIZE];
        size = INIT_SIZE;
        counter = -1;
    }

    @Override
    public Integer pop()
    {
        if (counter < 0)
            throw new IndexOutOfBoundsException("Stack is empty!");
        return entries[counter--];
    }

    @Override
    public void push(Integer num)
    {
        if (counter >= size - 1)
        {
            resize();
        }

        entries[++counter] = num;
    }

    // only realloc the double of current size, not implement shrink here.
    private void resize()
    {
        int[] tmp = new int[2 * size];
        System.arraycopy(entries, 0, tmp, 0, size);
        entries = tmp;
    }

    @Override
    public boolean isEmpty()
    {
        return counter < 0;
    }

    @Override
    public int size()
    {
        return counter + 1;
    }
}
