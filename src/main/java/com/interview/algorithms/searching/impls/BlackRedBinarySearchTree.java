package com.interview.algorithms.searching.impls;

import com.interview.algorithms.data.structures.Queue;
import com.interview.algorithms.data.structures.impls.LinkedListQueue;
import com.interview.algorithms.data.structures.impls.ResizingArrayQueue;
import com.interview.algorithms.searching.OrderedSymbolTable;
import com.interview.algorithms.searching.TreeNode;
import com.sun.org.apache.regexp.internal.RE;

import java.util.LinkedList;
import java.util.List;

import static com.interview.algorithms.searching.TreeNode.BLACK;
import static com.interview.algorithms.searching.TreeNode.RED;
import static com.interview.algorithms.searching.TreeNode.isRed;

/**
 * @author: vzou
 * *
 * @since: 5/23/2016.
 */
public class BlackRedBinarySearchTree<Key extends Comparable<Key>, Value> implements OrderedSymbolTable<Key, Value> {
    public TreeNode<Key, Value> root;

    @Override
    public Key min() {
        TreeNode<Key, Value> node = root;
        while (node != null) {
            if (node.left == null) {
                return node.key;
            }
            node = node.left;
        }

        return null;
    }

    @Override
    public Key max() {
        TreeNode<Key, Value> node = root;
        while (node != null) {
            if (node.right == null) {
                return node.key;
            }
            node = node.right;
        }

        return null;
    }

    @Override
    public Key floor(Key key) {
        return null;
    }

    @Override
    public Key ceiling(Key key) {
        return null;
    }

    @Override
    public int rank(Key key) {
        return 0;
    }

    @Override
    public Key select(int k) {
        return null;
    }

    @Override
    public Value deleteMin() {
        return null;
    }

    @Override
    public Value deleteMax() {
        return null;
    }

    @Override
    public Iterable<Key> keys(Key low, Key high) {
        return null;
    }

    @Override
    public void put(Key key, Value value) {
        if (key == null)
            throw new NullPointerException("Key can not be null!");
        if (value == null) {
            delete(key);
            return;
        }
        root = put(root, key, value);
        root.color = BLACK;
    }

    // insert Key and Value to given node root and return the root after the insert operation
    private TreeNode<Key, Value> put(TreeNode<Key, Value> root, Key key, Value value) {
        // if null, it means it's first node and should directly return it.
        if (root == null)
            return new TreeNode<>(key, value, RED, 1);

        int compare = key.compareTo(root.key);
        // root is bigger than given key, should go left
        if (compare < 0)
            root.left = put(root.left, key, value);
            // root is smaller than given key, should go right
        else if (compare > 0)
            root.right = put(root.right, key, value);
            // node find at root, should update the value
        else
            root.value = value;

        if (isRed(root.right) && !isRed(root.left))
            root = rotateLeft(root);

        if (isRed(root.left) && isRed(root.left.left))
            root = rotateRight(root);

        if (isRed(root.left) && isRed(root.right))
            flipColors(root);

        root.counter = size(root.left) + size(root.right) + 1;

        return root;
    }

    // flip the colors of a node and its two children
    // flip: turn against.
    private void flipColors(TreeNode<Key, Value> root) {
        // root must have opposite color of its two children
        // assert (h != null) && (h.left != null) && (h.right != null);
        // assert (!isRed(h) &&  isRed(h.left) &&  isRed(h.right))
        //    || (isRed(h)  && !isRed(h.left) && !isRed(h.right));
        root.color = !root.color;
        root.left.color = !root.left.color;
        root.right.color = !root.right.color;
    }

    // when root.left is red and same time root.left.left is also red, then it violates the rule that can not have continuous red link.
    //                    C                         B
    //          (RED)B <-         =>      (RED)A <-   -> C (RED)
    //     (RED)A <-
    private TreeNode<Key, Value> rotateRight(TreeNode<Key, Value> root) {
        // swap C and B
        TreeNode<Key, Value> resultRoot = root.left;
        root.left = resultRoot.right;
        resultRoot.right = root;

        // change color:
        resultRoot.color = root.color;
        root.color = RED;

        //update size:
        resultRoot.counter = root.counter;
        root.counter = size(root.left) + size(root.right) + 1;

        return resultRoot;
    }

    // the right link of the root is red node, which violates the rule that red link should be on left side.
    // simply switch the root with the right.right:
    //                      E                                       S
    //                B <-    ->  S (red)      =>      (RED)  E <-     -> W
    //                         M  <-  -> W               B <-   -> M
    //
    private TreeNode<Key, Value> rotateLeft(TreeNode<Key, Value> root) {
        // switch the root with root.right:
        TreeNode<Key, Value> resultRoot = root.right;
        root.right = resultRoot.left;
        resultRoot.left = root;

        // switch the color of the two
        resultRoot.color = root.color;
        root.color = RED;

        // update the counter
        resultRoot.counter = root.counter;
        root.counter = size(root.left) + size(root.right) + 1;

        return resultRoot;
    }

    // restore red-black tree invariant
    private TreeNode<Key, Value> balance(TreeNode<Key, Value> root) {
        // assert (root != null);

        if (isRed(root.right))
            root = rotateLeft(root);
        if (isRed(root.left) && isRed(root.left.left))
            root = rotateRight(root);
        if (isRed(root.left) && isRed(root.right))
            flipColors(root);

        root.counter = size(root.left) + size(root.right) + 1;
        return root;
    }


    // get the key from the given root
    private Value get(TreeNode<Key, Value> root, Key key) {
        while (root != null) {
            int compare = root.key.compareTo(key);
            if (compare > 0)
                root = root.left;
            else if (compare < 0)
                root = root.right;
            else if (compare == 0)
                return root.value;
        }

        return null;
    }

    @Override
    public Value get(Key key) {
        return get(root, key);
    }

    @Override
    public Value delete(Key key) {
        return null;
    }

    @Override
    public boolean contains(Key key) {
        return get(key) != null;
    }

    @Override
    public boolean isEmpty() {
        return root == null;
    }

    @Override
    public int size() {
        return size(root);
    }

    private int size(TreeNode<Key, Value> node) {
        return node == null ? 0 : node.counter;
    }

    @Override
    public Iterable<Key> keys() {
        List<Key> keys = new LinkedList<>();
        if (!isEmpty())
            keys(root, keys, min(), max());
        return keys;
    }

    private void keys(TreeNode<Key, Value> root, List<Key> result, Key from, Key to) {
        if (root == null)
            return;

        int compareFrom = from.compareTo(root.key);
        int compareTo = to.compareTo(root.key);
        // collect left:
        if(compareFrom < 0) keys(root.left, result, from, to);
        // collect root:
        if(compareFrom <=0 && compareTo >=0) result.add(root.key);
        // collect right:
        if(compareTo > 0) keys(root.right, result, from, to);
    }


    /**
     * Returns the height of the BST (for debugging).
     *
     * @return the height of the BST (a 1-node tree has height 0)
     */
    public int height() {
        return height(root);
    }

    private int height(TreeNode<Key, Value> treeNode) {
        if (treeNode == null)
            return -1;
        return 1 + Math.max(height(treeNode.left), height(treeNode.right));
    }
}
