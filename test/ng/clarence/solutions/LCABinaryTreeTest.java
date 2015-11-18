package ng.clarence.solutions;

import ng.clarence.collections.BinaryNode;
import org.junit.Test;

import static junit.framework.TestCase.assertEquals;

public class LCABinaryTreeTest {

    @Test
    public void noRoot() {
        assertEquals(-1, LCABinaryTree.solution(null, 1, 2));
    }

    @Test
    public void noFirstValue() {
        assertEquals(-1, LCABinaryTree.solution(new BinaryNode<>(1), 0, 1));
    }

    @Test
    public void noSecondValue() {
        assertEquals(-1, LCABinaryTree.solution(new BinaryNode<>(1), 0, 1));
    }

    @Test
    public void sanityTest() {
        BinaryNode<Integer> root = new BinaryNode<>(1);
        BinaryNode<Integer> node = root.setLeft(2);
        node.setLeft(3);
        node.setRight(4).setRight(5);
        root.setRight(3).setRight(4).setRight(5).setRight(6);
        assertEquals(-1, LCABinaryTree.solution(new BinaryNode<>(1), 0, 1));
    }

}