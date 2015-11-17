package ng.clarence.solutions;

import ng.clarence.collections.BinaryNode;
import org.junit.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.junit.Assert.assertEquals;

public class BinaryNodeTest {

    @Test
    public void inOrderPrint() {
        BinaryNode<Integer> root = new BinaryNode<>(3);
        root.setLeft(2).setLeft(1);
        BinaryNode<Integer> node = root.setRight(6);
        node.setLeft(4).setRight(5);
        node.setRight(7).setRight(8);
        ByteArrayOutputStream buffer = new ByteArrayOutputStream();
        PrintStream out = new PrintStream(buffer);
        root.printInOrder(out);
        assertEquals("1 2 3 4 5 6 7 8 ", buffer.toString());
    }

    @Test
    public void preOrderPrint() {
        BinaryNode<Integer> root = new BinaryNode<>(1);
        root.setLeft(2).setLeft(3);
        BinaryNode<Integer> node = root.setRight(4);
        node.setLeft(5).setRight(6);
        node.setRight(7).setRight(8);
        ByteArrayOutputStream buffer = new ByteArrayOutputStream();
        PrintStream out = new PrintStream(buffer);
        root.printPreOrder(out);
        assertEquals("1 2 3 4 5 6 7 8 ", buffer.toString());
    }

}
