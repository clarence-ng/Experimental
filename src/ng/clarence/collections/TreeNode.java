package ng.clarence.collections;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public class TreeNode<T> {
    public final T value;
    public final List<TreeNode<T>> children = new LinkedList<>();

    public TreeNode(T value) {
        this.value = value;
    }
}