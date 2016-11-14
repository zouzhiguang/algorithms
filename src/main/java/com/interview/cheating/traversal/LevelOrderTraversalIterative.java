package com.interview.cheating.traversal;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * level by level
 */
public class LevelOrderTraversalIterative implements Traversal {
    @Override
    public List<Integer> traverse(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        traversalNext(Collections.singletonList(root), result);
        return result;
    }

    public List<TreeNode> traversalNext(List<TreeNode> current, List<Integer> result){
        List<TreeNode> children = new ArrayList<>();
        if(current == null || current.isEmpty()) return children;
        for(TreeNode node : current) {
            if(node == null) continue;
            result.add(node.val);
            if(node.left != null) children.add(node.left);
            if(node.right != null) children.add(node.right);
        }
        return traversalNext(children, result);
    }

}
