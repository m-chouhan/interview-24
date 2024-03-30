package problems;

import java.util.HashMap;

/**
 * Optimal Solution for building tree from traversal, using indexing.
 * https://leetcode.com/problems/construct-binary-tree-from-preorder-and-inorder-traversal
 * */
public class BuiltTreeFromTraversalIII {
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

    int []preorder;
    HashMap<Integer, Integer> indexMap = new HashMap<>();
    public TreeNode buildTree(int []preorder, int []inorder) {
        this.preorder = preorder;
        for(int i = 0; i < inorder.length; ++i)
            indexMap.put(inorder[i], i);

        return buildTree(0, preorder.length, 0);
    }

    private TreeNode buildTree(int start, int length, int inorderIndex) {
        if(length == 0) return null;
        if(length == 1) return new TreeNode(preorder[start]);

        int splitIndex = indexMap.get(preorder[start]);
        int leftLen = splitIndex - inorderIndex;
        int rightLen = length - leftLen - 1;

        TreeNode left = buildTree(start + 1, leftLen, inorderIndex);
        TreeNode right = buildTree(start + leftLen + 1, rightLen, splitIndex + 1);
        return new TreeNode(preorder[start], left, right);
    }
}
