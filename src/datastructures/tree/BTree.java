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

        boolean hasChild(TreeNode<T> node) {
            return left == node || right == node;
        }

        void removeChild(TreeNode<T> node) {
            if(left == node) left = null;
            else if(right == node) right = null;
            throw new IllegalStateException(
                    String.format("Illegal remoaval (%s) operation on %s", node.value, value));
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
