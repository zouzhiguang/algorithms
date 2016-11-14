package com.interview.cheating.linkedlist;

/**
 * @author: Vincent
 * @since:11:04 AM, 13/11/2016
 */
public class ListNode {
    public final int val;
    public ListNode next;
    public ListNode(int val){
        this.val = val;
    }

    public int getVal() {
        return val;
    }

    public ListNode getNext() {
        return next;
    }

    public void setNext(ListNode next) {
        this.next = next;
    }
}
