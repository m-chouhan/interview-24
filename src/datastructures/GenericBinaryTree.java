package datastructures;

public class GenericBinaryTree<T extends Comparable<T>> extends Tree<T>{

    @Override
    boolean add(T value) {
        if(rootNode == null) {
            rootNode = new TreeNode<T>(value);
            return true;
        } else return add(rootNode, value);
    }

    private boolean add(TreeNode<T> node, T value) {
        int compare = node.value.compareTo(value);
        if(compare == 0) {
            return false; // value already exist, no addition operation was performed.
        }
        else if(compare < 0) {
            if(node.left != null) return add(node.left, value);
            else {
                node.left = new TreeNode<>(value);
                return true;
            }
        }
        else {
            if(node.right != null) return add(node.right, value);
            node.right = new TreeNode<>(value);
            return true;
        }
    }

    @Override
    boolean remove(T value) {
        return remove(rootNode, null, value);
    }

    private void swap(TreeNode<T> nodeA, TreeNode<T> nodeB) {
        T value = nodeA.value;
        nodeA.value = nodeB.value;
        nodeB.value = value;
    }

    private boolean remove(TreeNode<T> node, TreeNode<T> parentNode, T value) {
        if(node == null) return false;

        int compare = node.value.compareTo(value);
        if(compare == 0) {
            if(!node.hasChild()) {
                if(parentNode.left == node) parentNode.left = null;
                else parentNode.right = null;
                return true;
            }
            TreeNode<T> nextNode = node.right != null ? node.right : node.left;
            swap(node, nextNode);
            return remove(nextNode, node, value);
        }
        if(compare < 0) {
            return remove(node.left, node, value);
        }
        return remove(node.right, node, value);
    }

    @Override
    boolean contains(T value) {
        return contains(rootNode, value);
    }

    private boolean contains(TreeNode<T> node, T value) {
        if(node == null) return false;
        int comparator = node.value.compareTo(value);
        if(comparator == 0) return true;
        if(comparator > 0) return contains(node.right, value);
        else return contains(node.left, value);
    }

    @Override
    int size() {
        return 0;
    }

    @Override
    T[] toArray() {
        return null;
    }
}
