package com.interview.algorithms.data.structures.impls;

/**
 * @author: Vincent
 * @since:9:52 PM, 9/5/16
 */
public class Node<T>{
    public Node(T value, Node next) {
        this.value = value;
        this.next = next;
    }

    public T value;
    public Node<T> next;
}
