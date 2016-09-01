package com.interview.algorithms.sorting.impls;

import com.interview.algorithms.data.structures.impls.Node;
import com.interview.algorithms.sorting.Sorting;

/**
 * @see <a href="https://leetcode.com/problems/insertion-sort-list/"> Insertion sort for Linked List<a/>
 */
public class InsertionSortList extends Sorting<Node<Integer>>
{
    @Override
    public void sort(Node<Integer>[] values)
    {
//        insertionSortListVincent(values == null ? null : values[1]);
        insertionSortListRobin(values == null ? null : values[1]);
    }

    public Node<Integer> insertionSortListRobin(Node<Integer> head) {
        if(head == null || head.next == null) return head;

        Node<Integer> dummy = new Node<>(0);
        dummy.next = head;

        Node<Integer> previous = head; // last sorted node
        Node<Integer> current = previous.next;

        while(current != null) {
            Node<Integer> pos = dummy;

            while(pos.next != current && current.value >= pos.next.value) pos = pos.next; // seek for the insertion place
            if(pos.next == current) previous = current; // current is already in right place
            else if(current.value < pos.next.value){ // insert “current” to the right place
                previous.next = current.next;
                current.next = pos.next;
                pos.next = current;
            }
            current = previous.next;
        }
        return dummy.next;
    }

    public Node<Integer> insertionSortListVincent(Node<Integer> head) {
        Node<Integer> dummy = new Node<>(Integer.MIN_VALUE);
        dummy.next = head;
        Node<Integer> i = head, j;
        int length = 0;
        while(i != null){
            length ++;
            i = i.next;
        }

        if(length <= 1){
            return head;
        }

        while(i != dummy){
            for(j = dummy; j.next != i && j.next.next != null; j = j.next){
                if(j.next.value > j.next.next.value) swap(j);
            }
            i = j;
        }

        return dummy.next;
    }

    // given pre node, swap pre.next and pre.next.next, assert pre.next.next != NULL
    private void swap(Node<Integer> pre){
        Node<Integer> tail = pre.next;
        Node<Integer> middle = pre.next.next;
        tail.next = middle.next;
        middle.next = tail;
        pre.next = middle;
    }
}
