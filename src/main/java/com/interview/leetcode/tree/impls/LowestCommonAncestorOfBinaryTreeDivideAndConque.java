package com.interview.leetcode.tree.impls;

import com.interview.leetcode.tree.LowestCommonAncestorOfBinaryTree236;
import com.interview.leetcode.tree.TreeNode;

/**
 * @author: vzou
 * *
 * @since: 7/19/2016.
 */
public class LowestCommonAncestorOfBinaryTreeDivideAndConque implements LowestCommonAncestorOfBinaryTree236
{
    @Override
    public TreeNode<Integer> lowestCommonAncestor(TreeNode<Integer> root, TreeNode<Integer> p, TreeNode<Integer> q)
    {
        if(root == null || root == p || root ==q){
            return root;
        }

        TreeNode<Integer> left = lowestCommonAncestor(root.left, p, q);
        TreeNode<Integer> right = lowestCommonAncestor(root.right, p, q);

        if(left != null && right != null){
            return root;
        }else{
            return left == null ? right : left;
        }
    }
}
