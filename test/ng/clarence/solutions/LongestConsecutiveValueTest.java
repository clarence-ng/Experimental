package ng.clarence.solutions;

import static ng.clarence.solutions.LongestConsecutiveValue.GraphNode;

import junit.framework.Assert;
import ng.clarence.collections.TreeNode;
import org.junit.Test;

public class LongestConsecutiveValueTest {

    @Test
    public void longestInArray() {
        int[] array = new int[] {0, 8, 9, -1, 0, 2, -11, -12, -11, -10, 1, -99, -97, 0};
        Assert.assertEquals(3, LongestConsecutiveValue.longestConsecutiveIntegerInArray(array));

        array = new int[] {-1, 0, 1, 2};
        Assert.assertEquals(4, LongestConsecutiveValue.longestConsecutiveIntegerInArray(array));

        array = new int[] {-2, 0, 4, 0};
        Assert.assertEquals(1, LongestConsecutiveValue.longestConsecutiveIntegerInArray(array));
    }

    @Test
    public void longestInTree() {
        /**
         * Tree:
         *        0
         *    1      3
         * 2   -1      4
         *      0
         *      1
         *      2
         */
        TreeNode<Integer> root = new TreeNode<>(0);
        TreeNode<Integer> c1 = new TreeNode<>(1);
        TreeNode<Integer> c2 = new TreeNode<>(3);
        TreeNode<Integer> c2c1 = new TreeNode<>(4);
        TreeNode<Integer> c1c1 = new TreeNode<>(2);
        TreeNode<Integer> c1c2 = new TreeNode<>(-1);
        TreeNode<Integer> c1c2c1 = new TreeNode<>(0);
        TreeNode<Integer> c1c2c1c1 = new TreeNode<>(1);
        TreeNode<Integer> c1c2c1c1c1 = new TreeNode<>(2);
        root.children.add(c1);
        root.children.add(c2);
        c2.children.add(c2c1);
        c1.children.add(c1c1);
        c1.children.add(c1c2);
        c1c2.children.add(c1c2c1);
        c1c2c1.children.add(c1c2c1c1);
        c1c2c1c1.children.add(c1c2c1c1c1);
        Assert.assertEquals(4, LongestConsecutiveValue.longestConsecutiveIntegerInTree(root));
    }

    // Failing @Test
    public void longestInTreeUsingGraph() {
        /**
         * Tree:
         *        0
         *    1      3
         * 2   -1      4
         *      0
         *      1
         *      2
         */
        GraphNode root = new GraphNode(0);
        GraphNode c1 = new GraphNode(1);
        GraphNode c2 = new GraphNode(3);
        GraphNode c2c1 = new GraphNode(4);
        GraphNode c1c1 = new GraphNode(2);
        GraphNode c1c2 = new GraphNode(-1);
        GraphNode c1c2c1 = new GraphNode(0);
        GraphNode c1c2c1c1 = new GraphNode(1);
        GraphNode c1c2c1c1c1 = new GraphNode(2);
        root.children.add(c1);
        root.children.add(c2);
        c2.children.add(c2c1);
        c1.children.add(c1c1);
        c1.children.add(c1c2);
        c1c2.children.add(c1c2c1);
        c1c2c1.children.add(c1c2c1c1);
        c1c2c1c1.children.add(c1c2c1c1c1);
        Assert.assertEquals(4, LongestConsecutiveValue.longestConsecutiveIntegerInGraph(root));
    }

    @Test
    public void longestInDAG() {
        /**
         * Tree:
         *         0
         *    10       20
         *         21
         *         22
         *         23
         */
        GraphNode root = new GraphNode(0);
        GraphNode c1 = new GraphNode(10);
        GraphNode c2 = new GraphNode(20);
        GraphNode c1c1 = new GraphNode(21);
        GraphNode c1c1c1 = new GraphNode(22);
        GraphNode c1c1c1c1 = new GraphNode(23);
        root.children.add(c1);
        root.children.add(c2);
        c1.children.add(c1c1);
        c2.children.add(c1c1);
        c1c1.children.add(c1c1c1);
        c1c1c1.children.add(c1c1c1c1);
        Assert.assertEquals(4, LongestConsecutiveValue.longestConsecutiveIntegerInGraph(root));
    }
}
