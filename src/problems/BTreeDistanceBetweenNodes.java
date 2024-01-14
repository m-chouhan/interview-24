package problems;

/**
 * Return distance between two nodes in a binary tree with unique values.
 * Leetcode : https://leetcode.com/problems/find-distance-in-a-binary-tree/
 */
public class BTreeDistanceBetweenNodes {
    public static class TreeNode {
        int val;
        BTreeZigZagTraversal.TreeNode left;
        BTreeZigZagTraversal.TreeNode right;
        TreeNode(int val) { this.val = val; }
        TreeNode(int val, BTreeZigZagTraversal.TreeNode left, BTreeZigZagTraversal.TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }

    public int findDistance(TreeNode current, int p, int q, int level) {
        if(current == null) return -1;
        if(p == q) return 0;

        int leftDistance = findDistance(current.left, p, q, level+1);
        int rightDistance = findDistance(current.right, p, q, level+1);

        int anyChildWithValidDistance = leftDistance != -1 ? leftDistance : rightDistance;
        boolean allChildWithValue = leftDistance != -1 && rightDistance != -1;
        boolean currentChildWithValue = current.val == p || current.val == q;

        if(currentChildWithValue) {
            return anyChildWithValidDistance != -1 ? anyChildWithValidDistance - level : level;
        }

        if(allChildWithValue) {
            return (leftDistance - level) + (rightDistance - level);
        }

        return anyChildWithValidDistance;
    }

    public int findDistance(TreeNode root, int p, int q) {
        return findDistance(root, p, q, 0);
    }
}
