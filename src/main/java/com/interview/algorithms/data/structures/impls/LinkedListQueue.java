package com.interview.algorithms.data.structures.impls;

import java.util.Iterator;
import com.interview.algorithms.data.structures.Queue;

/**
 * FIFO queue.
 *
 * @author: Vincent
 * @since:9:51 PM, 9/5/16
 */
public class LinkedListQueue<T extends Comparable<T>> extends Queue<T> {

    protected Node<T> first, last;
    protected int counter;

    @Override
    public void enqueue(T t) {

        counter ++;
        if(isEmpty()){
            first = last = new Node<T>(t, null);
            return;
        }
        Node<T> oldLast = last;
        oldLast.next = new Node<T>(t, null);
        last = oldLast.next;
    }

    @Override
    public T dequeue() {
        if(isEmpty()){
            return null;
        }

        T value = first.value;
        // first move back one node

        // end of queue already
        if(first == last){
            first = last = null;
        }else {
            first = first.next;
        }

        counter--;

        return value;
    }

    @Override
    public boolean isEmpty() {
        return first == null;
    }

    @Override
    public int size() {
        return counter;
    }

    @Override
    public Iterator<T> iterator() {
        return new Iterator<T>(){
            private Node<T> node = first;

            @Override
            public boolean hasNext()
            {
                return node != null;
            }

            @Override
            public T next()
            {
                return node.value;
            }
        };
    }
}
