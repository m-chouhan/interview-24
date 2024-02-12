package problems;

import java.util.*;

public class PrintTreeLeaves {
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode() {
        }

        TreeNode(int val) {
            this.val = val;
        }

        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }
    Set<TreeNode> visited = new HashSet<>();
    public List<List<Integer>> findLeaves(TreeNode root) {
        List<List<Integer>> answer = new ArrayList<>();
        while(!visited.contains(root)) {
            ArrayList<Integer> leafNodes = new ArrayList<>();
            dfs(root, leafNodes);
            answer.add(leafNodes);
        }
        return answer;
    }

    void dfs(TreeNode node, List<Integer> leafNodes) {
        if(node == null || visited.contains(node)) {
            return;
        }
        else if(isLeaf(node)) {
            visited.add(node);
            leafNodes.add(node.val);
            return;
        }

        dfs(node.left, leafNodes);
        dfs(node.right, leafNodes);
    }

    boolean isLeaf(TreeNode node) {
        boolean isLeftSeen = node.left == null || visited.contains(node.left);
        boolean isRightSeen = node.right == null || visited.contains(node.right);
        return isLeftSeen && isRightSeen;
    }
}
