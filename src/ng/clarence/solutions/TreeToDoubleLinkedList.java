
package ng.clarence.solutions;

import ng.clarence.collections.BinaryNode;

public class TreeToDoubleLinkedList<T> {

    public static <T> BinaryNode<T> inPlaceToDoubleLinkedList(BinaryNode<T> root) {
        if (root == null) return null;
        BinaryNode<T> left = root.left;
        BinaryNode<T> right = root.right;
        BinaryNode<T> center = root;
        inPlaceToDoubleLinkedListIgnoreChildren(root);
        if (left != null) {
            root = inPlaceToDoubleLinkedList(left);
            mergeDoubleLinkedList(root, center);
        } else {
            root = center;
        }
        if (right != null) {
            right = inPlaceToDoubleLinkedList(right);
            mergeDoubleLinkedList(root, right);
        }
        return root;
    }

    private static <T> void inPlaceToDoubleLinkedListIgnoreChildren(BinaryNode<T> root) {
        root.left = root;
        root.right = root;
    }

    private static <T> void mergeDoubleLinkedList(BinaryNode<T> left, BinaryNode<T> right) {
        BinaryNode<T> lTail = left.right;
        BinaryNode<T> lHead = left;
        BinaryNode<T> rTail = right.right;
        BinaryNode<T> rHead = right;
        lTail.left = rHead;
        rHead.right = lTail;
        lHead.right = rTail;
        rTail.left = lHead;
    }
}
