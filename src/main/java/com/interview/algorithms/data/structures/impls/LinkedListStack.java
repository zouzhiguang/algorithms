package com.interview.algorithms.data.structures.impls;

import java.util.Iterator;
import java.util.Spliterator;
import java.util.function.Consumer;
import com.interview.algorithms.data.structures.Stack;

/**
 *
 * LIFO
 *
 * @author: Vincent
 * @since:8:55 PM, 9/5/16
 */
public class LinkedListStack<T extends Comparable<T>> extends Stack<T> {

    private Node<T> firstNode;
    private int counter = 0;

    @Override
    public Iterator<T> iterator() {

        return new Iterator<T>() {
            private Node<T> currentNode = firstNode;

            @Override
            public boolean hasNext() {
                return currentNode != null;
            }

            @Override
            public T next() {
                T result = currentNode.value;
                currentNode = currentNode.next;
                return result;
            }
        };
    }

    @Override
    public void forEach(Consumer<? super T> action) {
        iterator().forEachRemaining(action);
    }

    @Override
    public Spliterator<T> spliterator() {
        throw new UnsupportedOperationException("split iterator not supported");
    }

    @Override
    public void push(T item) {
        firstNode = new Node<T>(item, firstNode);
        counter ++;
    }

    @Override
    public T pop() {
        if(isEmpty()){
            return null;
        }

        T value = firstNode.value;
        firstNode = firstNode.next;
        counter --;
        return value;
    }

    @Override
    public boolean isEmpty() {
        return firstNode == null;
    }

    @Override
    public int size() {
        return counter;
    }
}
