package com.interview.cheating.data.structure.impls;

import com.interview.cheating.data.structure.ListNode;

public class LinkedListQueue implements Queue
{
    private ListNode head;
    private ListNode tail;
    private int      count;

    @Override
    public Integer poll()
    {
        if (head == null)
            throw new IndexOutOfBoundsException("Queue is empty");
        int val = head.val;
        head = head.next;
        if (head == null)
        {
            tail = null;
        }
        count--;
        return val;
    }

    @Override
    public void offer(Integer num)
    {
        if (head == null)
        {
            head = tail = new ListNode(num);
        }
        else
        {
            tail.next = new ListNode(num);
            tail = tail.next;
        }

        count++;
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

    public static void main(String... args){

        LinkedListQueue queue = new LinkedListQueue();

        queue.offer(1);
        queue.offer(2);
        if (queue.poll() != 1)
            throw new AssertionError();
        if (queue.poll() != 2)
            throw new AssertionError();
        if (!queue.isEmpty())
            throw new AssertionError();
        queue.offer(1);
        queue.offer(1);
        queue.offer(1);

        if (queue.size() != 3)
            throw new AssertionError();
    }
}
