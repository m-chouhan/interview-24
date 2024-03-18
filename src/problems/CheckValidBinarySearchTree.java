package problems;

/**
 * Recently Asked at amazon:
 * Validate a binary search tree
 * https://leetcode.com/problems/validate-binary-search-tree/
 * */
public class CheckValidBinarySearchTree {
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode() {}
        TreeNode(int val) { this.val = val; }
        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }

    class SubTreeInfo {
        public boolean isValid;
        public int minValue;
        public int maxValue;
        SubTreeInfo(boolean isValid, int minValue, int maxValue) {
            this.isValid = isValid;
            this.minValue = minValue;
            this.maxValue = maxValue;
        }
    }

    public boolean isValidBST(TreeNode root) {
        SubTreeInfo rootInfo = computeTreeInfo(root);
        return rootInfo.isValid;
    }

    public SubTreeInfo computeTreeInfo(TreeNode current) {
        if(current == null) return null;
        if(current.left == null && current.right == null)
            return new SubTreeInfo(true, current.val, current.val);

        SubTreeInfo leftTreeInfo = computeTreeInfo(current.left);
        SubTreeInfo rightTreeInfo = computeTreeInfo(current.right);
        boolean isLeftValid = leftTreeInfo == null ||
                (leftTreeInfo.isValid && leftTreeInfo.maxValue < current.val);
        boolean isRightValid = rightTreeInfo == null ||
                (rightTreeInfo.isValid && rightTreeInfo.minValue > current.val);

        boolean isValidTree = isLeftValid && isRightValid;
        int minTreeValue = leftTreeInfo == null ? current.val : leftTreeInfo.minValue;
        int maxTreeValue = rightTreeInfo == null ? current.val : rightTreeInfo.maxValue;

        return new SubTreeInfo(isValidTree, minTreeValue, maxTreeValue);
    }
}
