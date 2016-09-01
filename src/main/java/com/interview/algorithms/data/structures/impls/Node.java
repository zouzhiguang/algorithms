package com.interview.algorithms.data.structures.impls;

/**
 * @author: Vincent
 * @since:9:52 PM, 9/5/16
 */
public class Node<T extends Comparable<T>> implements Comparable<Node<T>>{
    public Node(T value, Node<T> next) {
        this.value = value;
        this.next = next;
    }

    public Node(T value) {
        this.value = value;
    }

    public T value;
    public Node<T> next;

    @Override
    public int compareTo(Node<T> o)
    {
        return value == null ? 1 : (o == null || o.value == null ? -1 : value.compareTo(o.value));
    }
}
