package com.junahan;

public class LinkListAlgs {

  /**
   * Merge two sorted linked lists as one in aces order.
   *
   * @param head1 a sorted linked list head
   * @param head2 another sorted linked list head
   * @return the merged sorted linked list in aces order.
   */
  public static Node mergeUsingIteration(Node head1, Node head2) {
    if (head1 == null || head1.getNext() == null) return head2;
    if (head2 == null || head2.getNext() == null) return head1;

    Node rHead, curr1,curr2;
    if (head1.getNext().getElement() <= head2.getNext().getElement()) {
      rHead = head1;
      curr1 = head1.getNext();
      curr2 = head2.getNext();
    } else {
      rHead = head2;
      curr1 = head2.getNext();
      curr2 = head1.getNext();
    }

    while(true) {
      if (curr1.getNext() == null) {         // at the end of curr1
        curr1.setNext(curr2);
        break;
      } else if (curr2.getElement() < curr1.getNext().getElement()) {
        curr1.setNext(new Node(curr2.getElement(), curr1.getNext()));
        curr1 = curr1.getNext();
        curr2 = curr2.getNext();
        if (curr2 == null) return rHead;     // at the end of curr2
      } else {
        curr1 = curr1.getNext();
      }
    }
    return rHead;
  }

}
