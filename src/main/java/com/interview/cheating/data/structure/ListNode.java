package com.interview.cheating.data.structure;

public class ListNode
{
    public ListNode next;
    public final int val;

    public ListNode(int val)
    {
        this.val = val;
    }

    public ListNode getNext()
    {
        return next;
    }

    public void setNext(ListNode next)
    {
        this.next = next;
    }

    public int getVal()
    {
        return val;
    }
}
