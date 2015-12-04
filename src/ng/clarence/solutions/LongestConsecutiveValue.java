package ng.clarence.solutions;

import ng.clarence.collections.TreeNode;

import java.util.LinkedList;
import java.util.List;

public class LongestConsecutiveValue {

    public static int longestConsecutiveIntegerInArray(int[] array) {
        int longest = 1;
        int currentLongest = 1;
        for (int i = 1; i < array.length; i++) {
            if (array[i-1] + 1 == array[i]) {
                currentLongest++;
            } else {
                longest = Math.max(currentLongest, longest);
                currentLongest = 1;
            }
        }
        longest = Math.max(currentLongest, longest);
        return longest;

    }

    /**
     * Finds the longest by pushing the current solution down to the children, and bubbling the answer up.
     * @param current
     * @return
     */
    public static int longestConsecutiveIntegerInTree(TreeNode<Integer> current) {
        if (current == null) return 0;
        return treeHelper(current, 1);
    }

    public static int treeHelper(TreeNode<Integer> current, int currentLength) {
        int result = currentLength;
        for (TreeNode<Integer> node : current.children) {
            result = Math.max(treeHelper(node, (node.value == current.value + 1) ? currentLength + 1 : 1), result);
        }
        return result;
    }

    public static class GraphNode {
        public int longest = -1;
        public final int value;
        public final List<GraphNode> children = new LinkedList<>();

        public GraphNode(int value) {
            this.value = value;
        }
    }

    /**
     * Marks the longest seen by the node, and re-use the solution when the node is re-visited.
     * @return
     */
    public static int longestConsecutiveIntegerInGraph(GraphNode root) {
        if (root == null) return 0;
        graphHelper(root);
        return root.longest;
    }

    public static void graphHelper(GraphNode current) {
        if (current.longest > 0) {
            return;
        }
        int result = 1;
        for (GraphNode node : current.children) {
            graphHelper(node);
        }
        for (GraphNode node : current.children) {
            result = Math.max(result, (node.value == current.value + 1) ? node.longest + 1 : node.longest);
        }
        current.longest = result;
    }
}
