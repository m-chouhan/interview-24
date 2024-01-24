package datastructures;

public abstract class Tree<T> {
    TreeNode<T> rootNode;
    class TreeNode<t> {
        public t value;
        public TreeNode left = null, right = null;
        TreeNode(t value) {
            this.value = value;
        }
        TreeNode(t value, TreeNode left, TreeNode right) {
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
    abstract T[] toArray();
}
