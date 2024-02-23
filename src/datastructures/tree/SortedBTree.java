package datastructures.tree;

import java.util.ArrayList;

/**
 * Ensures that the objects in the binary tree remains in a sorted order.
 * */
public class SortedBTree<T extends Comparable<T>> extends BTree<T> {
    int size = 0;
    @Override
    boolean add(T value) {
        if(rootNode == null) {
            rootNode = new TreeNode<T>(value);
            size++;
            return true;
        }
        return add(rootNode, value);
    }

    private boolean add(TreeNode<T> node, T value) {
        int compare = node.value.compareTo(value);
        if(compare == 0) {
            return false; // value already exist, no addition operation was performed.
        }
        else if(compare > 0) {
            if(node.left != null)
                return add(node.left, value);
            node.left = new TreeNode<>(value);
            size++;
            return true;
        } else {
            if (node.right != null)
                return add(node.right, value);
            node.right = new TreeNode<>(value);
            size++;
            return true;
        }
    }

    @Override
    boolean remove(T value) {
        TreeNode<T>[] pair = searchNode(rootNode, null, value);
        if(pair != null) {
            removeNode(pair[0], pair[1]);
            size--;
            return true;
        }
        return false;
    }

    private TreeNode<T>[] searchNode(TreeNode<T> node, TreeNode<T> parent, T value) {
        if(node == null) return null;
        int comparator = node.value.compareTo(value);
        if(comparator == 0) return new TreeNode[]{node, parent};
        return searchNode(comparator > 0 ? node.right : node.left, node, value);
    }

    private void removeNode(TreeNode<T> node, TreeNode<T> parent) {
        if(!node.hasChild()) {
            if(parent == null) rootNode = null;
            else parent.removeChild(node);
        } else {
            TreeNode<T> [] childNodes = null;
//                    node.right != null ? findSuccessor(node) : findPredessor(node);
            node.value = childNodes[0].value;
            removeNode(childNodes[0], childNodes[1]);
        }
    }

    private void swap(TreeNode<T> nodeA, TreeNode<T> nodeB) {
        T value = nodeA.value;
        nodeA.value = nodeB.value;
        nodeB.value = value;
    }

    @Override
    boolean contains(T value) {
        return contains(rootNode, value);
    }

    private boolean contains(TreeNode<T> node, T value) {
        if(node == null) return false;
        int comparator = node.value.compareTo(value);
        if(comparator == 0) return true;
        if(comparator > 0) return contains(node.left, value);
        else return contains(node.right, value);
    }

    @Override
    int size() {
        return size;
    }

    @Override
    ArrayList<T> toArray() {
        ArrayList<T> arrayList = new ArrayList<>();
        traverse(rootNode, arrayList);
        return arrayList;
    }

    private void traverse(TreeNode<T> node, ArrayList<T> arrayList) {
        if(node == null) return;
        traverse(node.left, arrayList);
        arrayList.add(node.value);
        traverse(node.right, arrayList);
    }
}
