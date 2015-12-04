package ng.clarence.solutions;

import ng.clarence.collections.TreeNode;

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

    public static int longestConsecutiveIntegerInTree(TreeNode<Integer> current) {
        if (current == null) return 0;
        return helper(current, 1);
    }

    public static int helper(TreeNode<Integer> current, int currentLength) {
        int result = currentLength;
        for (TreeNode<Integer> node : current.children) {
            result = Math.max(helper(node, (node.value == current.value + 1) ? currentLength + 1 : 1), result);
        }
        return result;
    }
}
