package com.interview.cheating.data.structure.impls;

import com.interview.cheating.data.structure.ListNode;
import com.interview.cheating.data.structure.Stack;

/**
 * Stack Linked List solution.
 */
public class LinkedListStack implements Stack
{
    ListNode head;
    int      count;

    @Override
    public Integer pop()
    {
        if (head == null)
            throw new IndexOutOfBoundsException("Stack is empty!");

        int val = head.getVal();
        head = head.next;
        count--;
        return val;
    }

    @Override
    public void push(Integer num)
    {
        ListNode node = new ListNode(num);
        node.next = head;
        count++;
        head = node;
    }

    @Override
    public boolean isEmpty()
    {
        return size() == 0;
    }

    @Override
    public int size()
    {
        return count;
    }
}
