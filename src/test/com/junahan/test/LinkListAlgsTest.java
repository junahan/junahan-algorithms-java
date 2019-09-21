package com.junahan.test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;

import com.junahan.Node;
import com.junahan.LinkListAlgs;
import java.util.Arrays;
import java.util.Random;
import org.junit.Test;

public class LinkListAlgsTest {

  @Test
  public void mergeUsingIterationTestWithSmallSize() throws Exception {
    Node head1 = genNodes(1, 20, 10);
    Node head2 = genNodes(1,20,10);
    Node result = LinkListAlgs.mergeUsingIteration(head1,head2);
    doAssertion(result,20);
  }

  @Test
  public void mergeUsingIterationTestWithMillionSize() throws Exception {
    Node head1 = genNodes(1, 100000, 2000000);
    Node head2 = genNodes(1,100000,1000000);
    Node result = LinkListAlgs.mergeUsingIteration(head1,head2);
    doAssertion(result,3000000);
  }

  @Test
  public void mergeUsingIterationTestWithDifferentArrange() throws Exception {
    Node head1 = genNodes(10, 100, 10);
    Node head2 = genNodes(100,200,20);
    Node result = LinkListAlgs.mergeUsingIteration(head1,head2);
    doAssertion(result,30);
  }

  @Test
  public void mergeUsingIterationTestWithOneEmpty() throws Exception {
    Node head1 = genNodes(10, 100, 10);
    Node head2 = genNodes(100,200,0);
    Node result = LinkListAlgs.mergeUsingIteration(head1,head2);
    doAssertion(result,10);

    Node head3 = genNodes(10, 100, 0);
    Node head4 = genNodes(100,200,10);
    Node result2 = LinkListAlgs.mergeUsingIteration(head3,head4);
    doAssertion(result,10);
  }

  @Test
  public void mergeUsingIterationTestWithTowEmpty() throws Exception {
    Node head1 = genNodes(10, 100, 0);
    Node head2 = genNodes(100,200,0);
    Node result = LinkListAlgs.mergeUsingIteration(head1,head2);
    assertNull(result);
  }

  private void doAssertion(Node head, int excepted) {
    assertNotNull(head);
    int actualSize = 0;
    Node temp = head.getNext();
    while (temp != null && temp != head) {
      if (temp.getNext() != null && temp.getNext() != head) {
        assertTrue(temp.getNext().getElement() >= temp.getElement());
      }
      actualSize++;
      temp = temp.getNext();
    }
    assertEquals(excepted,actualSize);
  }

  private Node genNodes(int min, int max, int size) {
    if (size <= 0) return null;
    Random random = new Random();
    int[] array = new int[size];
    for (int i = 0; i < size; i++ ) {
      array[i] = random.nextInt(max - min + 1) + min;
    }
    Arrays.sort(array);
    Node head = new Node(0,null);
    Node current = head;
    for (int j = 0; j < size; j++) {
      Node next = new Node(array[j],null);
      current.setNext(next);
      current = current.getNext();
    }
    return head;
  }
}
