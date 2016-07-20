package com.interview.leetcode.tree.impls;

import com.interview.leetcode.tree.ConvertSortedArrayToBinarySearchTree108;
import com.interview.leetcode.tree.TreeNode;

/**
 * @author: vzou
 * *
 * @since: 7/20/2016.
 */
public class ConvertSortedArrayToBinarySearchTree implements ConvertSortedArrayToBinarySearchTree108
{
    @Override
    public TreeNode<Integer> sortedArrayToBST(int[] nums)
    {
        return build(nums, 0, nums.length - 1);
    }

    private TreeNode<Integer> build(int[] nums, int low, int high)
    {
        if (low > high)
        {
            return null;
        }

        int mid = low + (high - low) / 2;

        TreeNode<Integer> root = new TreeNode<>(nums[mid]);
        root.left = build(nums, low, mid - 1);
        root.right = build(nums, mid + 1, high);

        return root;
    }
}
