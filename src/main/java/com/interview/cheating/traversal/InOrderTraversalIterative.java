package com.interview.cheating.traversal;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * In-Order traversal, iterative. Left -> Root-> Right
 */
public class InOrderTraversalIterative implements Traversal {
    @Override
    public List<Integer> traverse(TreeNode root) {
        List<Integer> nodes = new ArrayList<>();
        TreeNode current = root;
        Stack<TreeNode> stack = new Stack<>();
        while(current != null || stack.size() > 0){
            while(current != null) {
                stack.push(current);
                current = current.left;
            }
            if (!stack.isEmpty()) {
                current = stack.pop();
                nodes.add(current.val);
                current = current.right;
            }
        }
        return nodes;
    }


}
