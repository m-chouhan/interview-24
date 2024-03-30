package problems;

import java.util.Arrays;

public class BuildTreeFromTraversalII {
    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int val) { this.val = val; }
        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }

    public TreeNode buildTree(int []preorder, int []inorder) {
        return buildTree(preorder, 0, preorder.length, inorder, 0, inorder.length);
    }

    private TreeNode buildTree(int[] preorder, int pIndex, int pLength, int[] inorder, int iIndex, int iLength) {
        if(preorder == null || pLength == 0) return null;

        TreeNode currentNode = new TreeNode(preorder[pIndex]);
        if(pLength == 1) return currentNode;

        int splitIndex = findIndex(preorder[pIndex], inorder, iIndex);
        int leftArrayLength = splitIndex - iIndex;
        int rightArrayLength = iLength - leftArrayLength - 1;

        currentNode.left = buildTree(
                preorder, pIndex + 1, leftArrayLength,
                inorder, iIndex, leftArrayLength);
        currentNode.right = buildTree(
                preorder, pIndex + leftArrayLength + 1, rightArrayLength,
                inorder, splitIndex + 1, rightArrayLength);
        return currentNode;
    }

    private int findIndex(int value, int [] array, int start) {
        while(start < array.length && array[start] != value) start++;
        return start;
    }

}
