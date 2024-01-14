package problems;

import org.junit.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.*;

public class BTreeZigZagTraversalTest {

    BTreeZigZagTraversal subject = new BTreeZigZagTraversal();
    @Test
    public void zigzagLevelOrder() {
        BTreeZigZagTraversal.TreeNode nodeA = new BTreeZigZagTraversal.TreeNode(4);
        BTreeZigZagTraversal.TreeNode nodeB = new BTreeZigZagTraversal.TreeNode(5);
        BTreeZigZagTraversal.TreeNode nodeC = new BTreeZigZagTraversal.TreeNode(6);
        BTreeZigZagTraversal.TreeNode nodeD = new BTreeZigZagTraversal.TreeNode(2, nodeA, nodeB);
        BTreeZigZagTraversal.TreeNode nodeE = new BTreeZigZagTraversal.TreeNode(3,  null, nodeC);
        BTreeZigZagTraversal.TreeNode root = new BTreeZigZagTraversal.TreeNode(1, nodeD, nodeE);
        List<List<Integer>> actualOutput = subject.zigzagLevelOrder(root);

        assertEquals(actualOutput.get(0), Arrays.asList(1));
        assertEquals(actualOutput.get(1), Arrays.asList(3, 2));
        assertEquals(actualOutput.get(2), Arrays.asList(4, 5, 6));
    }
}