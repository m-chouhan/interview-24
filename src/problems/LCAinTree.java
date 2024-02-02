package problems;

/**
 * Find the lowest Common Ancestor in a tree.
 * https://leetcode.com/problems/lowest-common-ancestor-of-a-binary-tree/
 */
class LCAinTree {
     public class TreeNode {
      int val;
      TreeNode left;
      TreeNode right;
      TreeNode(int x) { val = x; }
    }

    TreeNode LCA;

    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        searchTree(root, p.val, q.val);
        return LCA;
    }

    boolean searchTree(TreeNode node, int p, int q) {

        if(node == null)
            return false;

        boolean nodeSearch = node.val == p || node.val == q;
        boolean leftSearch = searchTree(node.left, p, q);
        boolean rightSearch = searchTree(node.right, p, q);
        boolean isCurrentNodeLCA =
                (leftSearch && rightSearch) || ((leftSearch || rightSearch) && nodeSearch);

        if(isCurrentNodeLCA)
            LCA = node;

        return nodeSearch || leftSearch || rightSearch;
    }
}