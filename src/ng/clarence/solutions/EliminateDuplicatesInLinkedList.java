package ng.clarence.solutions;

import ng.clarence.collections.Node;

public class EliminateDuplicatesInLinkedList {
  static <T extends  Comparable<T>> void solution(Node<T> head) {
    if (head.next == null) {
      return;
    }
    if (head.next.value.compareTo(head.value) == 0) {
      Node<T> nextNext = head.next.next;
      head.next = nextNext;
    }
    solution(head.next);
  }
}
