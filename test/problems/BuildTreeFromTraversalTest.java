package problems;

import org.junit.Test;

import static org.junit.Assert.*;

public class BuildTreeFromTraversalTest {

    BuildTreeFromTraversal subject = new BuildTreeFromTraversal();

    @Test
    public void buildTree1() {
        BuildTreeFromTraversal.TreeNode node = subject.buildTree(new int[]{1}, new int[]{1});
        assertEquals(1, node.val);
    }

    @Test
    public void buildTree2() {
        BuildTreeFromTraversal.TreeNode node = subject.buildTree(new int[]{1,2,3}, new int[]{2,1,3});
        assertEquals(1, node.val);
        assertEquals(2, node.left.val);
        assertEquals(3, node.right.val);
    }

    @Test
    public void buildTree3() {
        BuildTreeFromTraversal.TreeNode node = subject.buildTree(new int[]{3,9,20,15,7}, new int[]{9,3,15,20,7});
        assertEquals(3, node.val);
        assertEquals(9, node.left.val);
        assertEquals(20, node.right.val);
        assertEquals(15, node.right.left.val);
        assertEquals(7, node.right.right.val);
    }
}