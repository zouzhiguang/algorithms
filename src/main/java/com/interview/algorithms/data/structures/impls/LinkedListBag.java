package com.interview.algorithms.data.structures.impls;

import java.util.Iterator;
import com.interview.algorithms.data.structures.Bag;

/**
 * @author: vzou
 * *
 * @since: 6/1/2016.
 */
public class LinkedListBag<T> extends Bag<T>
{
    protected Node<T> root, last;
    protected int counter;

    @Override
    public void add(T item)
    {
        if(root == null){
            last = root = new Node<>(item, null);

        }else {
            // add to the last.
            last.next = new Node<>(item, null);
            last = last.next;
        }

        counter ++;
    }

    @Override
    public boolean isEmpty() {
        return root == null;
    }

    @Override
    public int size() {
        return counter;
    }

    @Override
    public Iterator<T> iterator() {
        return new Iterator<T>(){
            private Node<T> node = root;

            @Override
            public boolean hasNext()
            {
                return node != null;
            }

            @Override
            public T next()
            {
                T value = node.value;
                node = node.next;
                return value;
            }
        };
    }
}
