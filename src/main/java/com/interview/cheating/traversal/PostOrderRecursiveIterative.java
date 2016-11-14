package com.interview.cheating.traversal;

import java.util.*;

/**
 * Left -> Right -> Root
 */
public class PostOrderRecursiveIterative implements Traversal {

    /**
     *  Non-HashSet based version
     *
     * Given a binary tree, return the postorder traversal of its nodes' values.
     * tracking the last visited node,
     *      if prev.left == node || prev.right == node  traverse down to children, visit left or right (left == null)
     *      if node.left == prev                        traverse back from left, visit right
     *      else                                        traverse back from children, visit itself
     */
    public List<Integer> traverseNonHashSet(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        if(root == null) return result;

        TreeNode prev = null;
        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);

        while(!stack.isEmpty()){
            TreeNode node = stack.peek();
            if(prev == null || node == prev.left || node == prev.right){
                if(node.left != null) stack.push(node.left);
                else if(node.right != null) stack.push(node.right);
            }else if(prev == node.left){
                if(node.right != null) stack.push(node.right);
            }else{
                result.add(node.val);
                stack.pop();
            }

            prev = node;
        }

        return result;
    }

    @Override
    public List<Integer> traverse(TreeNode root) {
        return traverseNonHashSet(root);
    }

    /**
     * Hash set version.
     *
     * Every time to use a hash set to record the added children.
     * if not visited yet, add all it's children.
     * Or else, all its children are visited, and get back to parent. add value to result.
     *
     */
    public List<Integer> raverseHashSet(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        Stack<TreeNode> stack = new Stack<>();
        Set<TreeNode> childrenAdded = new HashSet<>();
        if(root != null) stack.push(root);
        while(!stack.isEmpty()){
            TreeNode node = stack.peek();
            if(!childrenAdded.contains(node)){
                if(node.right != null) stack.add(node.right);
                if(node.left != null) stack.add(node.left);
                childrenAdded.add(node);
            } else {
                stack.pop();
                result.add(node.val);
            }
        }
        return result;
    }
}
