package problems;

/**
 * Create a tree from its in-order and pre-order traversal.
 * https://leetcode.com/problems/construct-binary-tree-from-preorder-and-inorder-traversal/
 * Solution takes additional space.
 * */
public class BuildTreeFromTraversal {
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

    public TreeNode buildTree(int[] preorder, int[] inorder) {
        if(preorder == null || preorder.length == 0) return null;

        TreeNode root = new TreeNode(preorder[0]);
        int [][] inorderList =
                splitInorder(root.val, inorder);
        int [][] preorderList =
                splitPreorder(inorderList[0], preorder);
        root.left = buildTree(preorderList[0], inorderList[0]);
        root.right = buildTree(preorderList[1], inorderList[1]);
        return root;
    }

    int [][] splitInorder(int value, int[] inorder) {
        int splitIndex = 0;
        while(splitIndex < inorder.length && inorder[splitIndex] != value)
            splitIndex++;
        int []leftArray = new int[splitIndex];
        int []rightArray = new int[inorder.length - splitIndex];
        for(int i = 0; i < inorder.length; ++i) {
            if(i < splitIndex) leftArray[i] = inorder[i];
            if(i > splitIndex)
                rightArray[i - splitIndex - 1] = inorder[i];
        }

        return new int[][] {leftArray, rightArray};
    }

    int [][] splitPreorder(int[] inorderLeft, int[] preorder) {
        int splitIndex = inorderLeft.length;
        int []leftArray = new int[splitIndex];
        int []rightArray = new int[preorder.length - splitIndex - 1];
        // 1st element in pre-order is already consumed!
        for(int i = 1; i < preorder.length; ++i) {
            if(i <= splitIndex) leftArray[i - 1] = preorder[i];
            else rightArray[i - splitIndex - 1] = preorder[i];
        }
        return new int[][]{leftArray, rightArray};
    }
}
