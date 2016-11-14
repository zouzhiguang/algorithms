package com.interview.cheating.linkedlist;

/**
 * @author: Vincent
 * @since:11:05 AM, 13/11/2016
 */
public class LinkedListOps {

    /**
     * Provided a sorted LinkedList, insert the newNode into the list according to the value.
     *
     * @param root    root of original list
     * @param newNode new node to insert
     * @return root of the new list.
     */
    public ListNode insert(ListNode root, ListNode newNode) {
        ListNode dummy = new ListNode(Integer.MIN_VALUE);
        dummy.next = root;

        ListNode cursor = dummy;
        while (cursor.next != null) {
            if (cursor.next.val >= newNode.val) {
                newNode.next = cursor.next;
                cursor.next = newNode;
                return dummy.next;
            }
        }

        // append to the end;
        cursor.next = newNode;
        newNode.next = null;
        return dummy.next;
    }

    /**
     * Provided a sorted list, remove all the value eq to val in the list
     *
     * @param root root of origin
     * @param val  val to delete
     * @return root after deleted
     */
    public ListNode delete(ListNode root, int val) {
        ListNode dummy = new ListNode(Integer.MIN_VALUE);
        dummy.next = root;

        ListNode cursor = dummy;
        while (cursor.next != null) {
            if (cursor.next.val == val) {
                cursor.next = cursor.next.next;
            } else {
                cursor = cursor.next;
            }
        }

        return dummy.next;
    }

    /**
     * Reverse all element in linked list
     *
     * @param root root of origin
     * @return new root after reverse
     */
    public ListNode reverse(ListNode root) {
        if (root == null || root.next == null)
            return root;
        ListNode previous = root, cursor = root.next;
        previous.next = root;

        while (cursor != null) {
            ListNode tmp = cursor.next;
            cursor.next = previous;
            previous = cursor;
            cursor = tmp;
        }

        return previous;

    }

    public ListNode merge(ListNode head1, ListNode head2) {
        ListNode dummy = new ListNode(Integer.MIN_VALUE), cursor = dummy;

        while (head1 != null && head2 != null) {
            if (head1.val >= head2.val) {
                cursor.next = head1;
                head1 = head1.next;
            } else {
                cursor.next = head2;
                head2 = head2.next;
            }

            cursor = cursor.next;
        }

        if (head1 == null) {
            cursor.next = head2;
        } else {
            cursor.next = head1;
        }

        return dummy.next;
    }

    /**
     * Find the middle element of the given linked list
     *
     * @param head head of the original
     * @return middle element
     */
    public ListNode mid(ListNode head) {
        if (head == null || head.next == null || head.next.next == null)
            return head;
        ListNode fast = head.next, slow = head;

        // slow -> 0, fast -> 1
        // slow -> 1, fast -> 3
        // slow -> 2, fast -> 5
        // ......
        // if length = 6, which fast != null but fast.next == null,
        // slow -> 2, fast -> 5 and quit, slow = middle = 2 (all have 6 nodes, return the third node.)
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }

        return slow;
    }

    /**
     * Provided the list has a cycle, find the element that at the start of the cycle.
     * eg, 1 ->  2 -> 3 -> 4 -> 5 -> 6
     *                ^              |
     *                |              v
     *               10 <- 9 <- 8 <- 7
     *
     * @param head head of origin
     * @return the beginning of the cycle
     * @see <a href = "https://leetcode.com/problems/linked-list-cycle-ii/">Linked List Cycle II</>
     */
    public ListNode findCycle(ListNode head) {
        ListNode fast = head, slow = head;

        do {
            if (fast == null || fast.next == null)
                return null;
            fast = fast.next.next;
            slow = slow.next;
        } while (fast != slow);

        fast = head;
        while (fast != slow) {
            fast = fast.next;
            slow = slow.next;
        }

        return fast;
    }

    /**
     * do insertSort to sort the given list.
     * @param node origin head
     * @return new head after sort
     */
    public ListNode insertSort(ListNode node){
        return null;
    }

    /**
     * find the intersection node of given linkedList head1 and head2. If don't have any intersection, return null.
     * @param head1 head for list 1
     * @param head2 head for list 2
     * @return intersection node
     */
    public ListNode intersect(ListNode head1, ListNode head2){
        return null;
    }
}
