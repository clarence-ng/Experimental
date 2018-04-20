package ng.clarence.solutions;

import ng.clarence.collections.Node;
import org.junit.Test;

public class EliminateDuplicatesInLinkedListTest {
  @Test
  public void sanity() {
    Node<Integer> linkedList = createLinkedList(1, 1, 2, 3, 4, 4, 8);
    printLinkedList(linkedList);
    EliminateDuplicatesInLinkedList.solution(linkedList);
    printLinkedList(linkedList);
  }

  private void printLinkedList(Node<Integer> linkedList) {
    StringBuilder stringBuilder = new StringBuilder();
    while (linkedList != null) {
      stringBuilder.append(linkedList.value);
      stringBuilder.append(" ");
      linkedList = linkedList.next;
    }
    System.out.println(stringBuilder.toString());
  }

  private Node<Integer> createLinkedList(int ... values) {
    Node<Integer> head = null;
    Node<Integer> current = null;
    for (int i : values) {
      Node<Integer> newNode = new Node(i);
      if (current == null) {
        head = newNode;
      } else {
        current.next = newNode;
      }
      current = newNode;
    }
    return head;
  }
}
