package problems;
import java.util.*;

/**
 * Recently asked at microsoft.
 * https://leetcode.com/problems/binary-tree-zigzag-level-order-traversal/
 */
public class BTreeZigZagTraversal {
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

    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> answer = new ArrayList<>();
        Stack<TreeNode> first = new Stack<>();
        Stack<TreeNode> second = new Stack<>();
        boolean useFirst = true;
        if(root != null) first.add(root);

        while(!first.isEmpty() || !second.isEmpty()) {
            Stack<TreeNode> currentStack = useFirst ? first : second;
            Stack<TreeNode> nextStack = useFirst ? second : first;
            ArrayList<Integer> currentOutput = new ArrayList<>();

            while(!currentStack.isEmpty()) {
                TreeNode node = currentStack.pop();
                currentOutput.add(node.val);
                if(useFirst) {
                    if(node.left != null) nextStack.push(node.left);
                    if(node.right != null) nextStack.push(node.right);
                } else {
                    if(node.right != null) nextStack.push(node.right);
                    if(node.left != null) nextStack.push(node.left);
                }
            }
            answer.add(currentOutput);
            useFirst = !useFirst;
        }
        return answer;
    }
}
