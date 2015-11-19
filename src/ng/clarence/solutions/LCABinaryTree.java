package ng.clarence.solutions;

import ng.clarence.collections.BinaryNode;

import java.util.LinkedList;

/**
 * Least common ancestor between two nodes.
 */
public class LCABinaryTree {

    public static <T> int solution(BinaryNode<T> root, T first, T second) {
        LinkedList<T> firstPath = new LinkedList<>();
        if (!hasValue(root, first, firstPath)) return -1;

        LinkedList<T> secondPath = new LinkedList<>();
        if (!hasValue(root, second, secondPath)) return -1;

        T firstNodeValue = firstPath.removeFirst();
        T secondNodeValue = secondPath.removeFirst();
        while (firstNodeValue == secondNodeValue) {
            firstNodeValue = firstPath.removeFirst();
            secondNodeValue = secondPath.removeFirst();
        }
        return firstPath.size() + secondPath.size();
    }

    public static <T> boolean hasValue(BinaryNode<T> root, T targetValue, LinkedList<T> path) {
        if (root == null) return false;
        path.add(root.value);

        if (root.left!= null && hasValue(root.left, targetValue, path)) return true;
        if (root.right!= null && hasValue(root.right, targetValue, path)) return true;

        path.removeLast();
        return false;
    }
}
