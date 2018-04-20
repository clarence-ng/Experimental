package ng.clarence.collections;

public class Node<T> {
  public final T value;
  public Node<T> next;

  public Node(T value, Node<T> next) {
    this.value = value;
    this.next = next;
  }

  public Node(T value) {
    this(value, null);
  }
}
