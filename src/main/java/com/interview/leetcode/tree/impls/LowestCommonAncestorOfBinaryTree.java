package com.interview.leetcode.tree.impls;

import java.util.ArrayList;
import java.util.List;
import com.interview.leetcode.tree.LowestCommonAncestorOfBinaryTree236;
import com.interview.leetcode.tree.TreeNode;

/**
 * @author: vzou
 * *
 * @since: 7/19/2016.
 */
public class LowestCommonAncestorOfBinaryTree implements LowestCommonAncestorOfBinaryTree236
{
    @Override
    public TreeNode<Integer> lowestCommonAncestor(TreeNode<Integer> root, TreeNode<Integer> p, TreeNode<Integer> q)
    {
        List<TreeNode<Integer>> pathOfP = new ArrayList<>();
        List<TreeNode<Integer>> pathOfQ = new ArrayList<>();

        findPath(root, p, pathOfP);
        findPath(root, q, pathOfQ);
        int size = Math.min(pathOfP.size(), pathOfQ.size());
        for(int i = 0; i<size; i++){
            if(pathOfP.get(i) != pathOfQ.get(i)){
                return pathOfP.get(i-1);
            }
        }

        return pathOfP.get(size - 1);
    }

    private boolean findPath(TreeNode<Integer> root, TreeNode<Integer> p, List<TreeNode<Integer>> path){
        if(root == null){
            return false;
        }

        if(root == p){
            path.add(root);
            return true;
        }

        boolean left_found = findPath(root.left, p, path);
        boolean right_found = findPath(root.right, p, path);
        if(left_found || right_found){
            path.add(0, root);
            return true;
        }

        return false;

    }
}
