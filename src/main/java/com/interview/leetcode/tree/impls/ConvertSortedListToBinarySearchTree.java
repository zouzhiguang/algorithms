package com.interview.leetcode.tree.impls;

import com.interview.algorithms.data.structures.impls.Node;
import com.interview.leetcode.tree.ConvertSortedListToBinarySearchTree109;
import com.interview.leetcode.tree.TreeNode;

/**
 * @author: vzou
 * *
 * @since: 7/20/2016.
 */
public class ConvertSortedListToBinarySearchTree implements ConvertSortedListToBinarySearchTree109
{
    private Node<Integer> currentNode = null;
    @Override
    public TreeNode<Integer> sortedListToBST(Node<Integer> head) {
        currentNode = head;
        int size = 0;
        while(head != null){
            size++;
            head = head.next;
        }

        return build(0, size - 1);
    }

    private TreeNode<Integer> build(int low, int high){
        if(low > high){
            return null;
        }

        int mid = low + (high - low) / 2;

        TreeNode<Integer> left = build(low, mid - 1);
        TreeNode<Integer> root = new TreeNode<>(currentNode.value);
        root.left = left;
        currentNode = currentNode.next;
        root.right = build(mid + 1, high);

        return root;
    }
}
