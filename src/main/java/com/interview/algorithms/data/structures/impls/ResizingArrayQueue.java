package com.interview.algorithms.data.structures.impls;

import com.interview.algorithms.data.structures.Queue;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Iterator;
import java.util.NoSuchElementException;

/**
 * @author: Vincent
 * @since:10:29 AM, 10/5/16
 */
public class ResizingArrayQueue<T> extends Queue<T> {

    private Logger logger = LoggerFactory.getLogger(getClass());

    private static final int DEFAULT_SIZE = 8;
    protected T[] values;
    private int firstIndex;
    private int lastIndex;
    private int counter;


    public ResizingArrayQueue() {
        this.values = (T[]) new Object[DEFAULT_SIZE];
        this.lastIndex = firstIndex = 0;
    }

    @Override
    public void enqueue(T t) {
        if (counter >= values.length)
            resize(2 * values.length);

        values[lastIndex++] = t;
        if (lastIndex == values.length)
            lastIndex = 0;
        counter++;
    }

    @Override
    public T dequeue() {
        if (isEmpty())
            throw new NoSuchElementException("Queue is empty");

        T value = values[firstIndex];
        values[firstIndex++] = null;
        counter--;

        if (firstIndex >= values.length)
            firstIndex = 0;

        if (counter > 0 && counter < values.length / 4)
            resize(values.length / 2);

        return value;
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
        throw new UnsupportedOperationException("not supported at the moment");
    }

    protected void resize(int length) {
        // as element only be added when call enqueue, so the elements should be left-aligned when resize,
        // because this can input from end and out in the front. no need to keep space for front.
        logger.debug("resizing array from {} to {}, current element count is {}", values.length, length, counter);
        // or else would drop item or index out of bound exception
        assert length >= counter;

        T[] copy = (T[]) new Object[length];

        for (int i = 0; i <= counter; i++) {
            copy[i] = values[(i + firstIndex) % values.length];
        }

        values = copy;
        this.firstIndex = 0;
        this.lastIndex = counter;
    }
}
