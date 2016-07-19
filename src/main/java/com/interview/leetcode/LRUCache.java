package com.interview.leetcode;

public class LRUCache {

    // create a linked list and a array list.
    // linked list is saving the cached node
    // array list is saving the reference to the node
    private Node head = new Node(Integer.MIN_VALUE, Integer.MIN_VALUE);
    private Node tail = new Node(Integer.MIN_VALUE, Integer.MIN_VALUE);
    public class Node{
        int key;
        int val;
        Node next;

        public Node(int key, int val){
            this.key = key;
            this.val = val;
        }
    }

    private Node[] nodes;
    private int count = 0;
    private final int capacity;
    public LRUCache(int capacity) {
        nodes = new Node[capacity];
        this.capacity = capacity;
        tail.next = head;
    }

    public int get(int key) {
        for(int i = 0; i < count; i ++){
            if(nodes[i].key == key){
                return nodes[i].val;
            }
        }

        return -1;
    }

    public void set(int key, int value) {
        for(int i = 0; i < count; i ++){
            if(nodes[i].key == key){
                nodes[i].val = value;
                return;
            }
        }

        Node node = new Node(key, value);
        if(count >= capacity){
            Node lru = head.next;
            head.next= lru.next;
            for(int i=0; i<capacity; i++){
                if(nodes[i].key == lru.key){
                    nodes[i] = node;
                    break;
                }
            }
        }else{
            nodes[count++] = node;
        }

        tail.next.next = node;
        tail.next = node;
    }
}
