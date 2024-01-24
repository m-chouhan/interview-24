package datastructures.tree;

import java.util.ArrayList;

/**
 * Abstract binary tree.
 * The tree node values MUST be comparable.
 * */
public abstract class BTree<T extends Comparable<T>> {
    TreeNode<T> rootNode;
    class TreeNode<T> {
        public T value;
        public TreeNode left = null, right = null;
        TreeNode(T value) {
            this.value = value;
        }
        TreeNode(T value, TreeNode left, TreeNode right) {
            this.value = value;
            this.left = left;
            this.right = right;
        }

        boolean hasChild() {
            return left != null || right != null;
        }
    }

    /* Returns true if new node was added, false otherwise.
    * */
    abstract boolean add(T value);
    abstract boolean remove(T value);
    abstract boolean contains(T value);
    abstract int size();
    abstract ArrayList<T> toArray();
}
