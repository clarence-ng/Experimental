package ng.clarence.collections;

import java.io.PrintStream;

public class BinaryNode<T> {
    public final T value;
    public BinaryNode<T> left;
    public BinaryNode<T> right;

    public BinaryNode(T value) {
        this.value = value;
    }

    public BinaryNode<T> setLeft(T value) {
        left = new BinaryNode<>(value);
        return left;
    }

    public BinaryNode<T> setRight(T value) {
        right = new BinaryNode<>(value);
        return right;
    }

    public void printInOrder(PrintStream printStream) {
        if (left != null) left.printInOrder(printStream);
        printStream.print(value);
        printStream.print(" ");
        if (right != null) right.printInOrder(printStream);
    }

    public void printPreOrder(PrintStream printStream) {
        printStream.print(value);
        printStream.print(" ");
        if (left != null) left.printPreOrder(printStream);
        if (right != null) right.printPreOrder(printStream);
    }

}