package com.junahan;

public class LList implements List {

  private Link head;
  private Link tail;
  private Link curr;

  public LList() {
    tail = head = curr = new Link(null);
  }

  @Override
  public void clear() {
    head.setNext(null);
    curr = tail = head;
  }

  @Override
  public void insert(Object item) {
    if (item == null) {
      throw new IllegalArgumentException("argument item is required.");
    }
    curr.setNext(new Link(item, curr.getNext()));
    if (tail == curr) {
      tail = curr.getNext();
    }
  }

  @Override
  public void append(Object object) {
    tail.setNext(new Link(object, null));
    tail = tail.getNext();
  }

  @Override
  public Object remove() {
    if (!isInList()) {
      return null;
    }
    Object it = curr.getNext().getElement();
    if (tail == curr.getNext()) {
      tail = curr;
    }
    curr.setNext(curr.getNext().getNext());
    return it;
  }

  @Override
  public void setFirst() {
    curr = head;
  }

  @Override
  public void next() {
    if (curr != null) {
      curr.getNext();
    }
  }

  @Override
  public void prev() {
    if (curr == null || curr == head) {
      curr = null;
      return;
    }

    Link temp = head;
    while (temp != null && temp.getNext() != curr) {
      temp = temp.getNext();
    }
    curr = temp;
  }

  @Override
  public int length() {
    int cnt = 0;
    for (Link temp = head.getNext(); temp != null; temp = temp.getNext()) {
      cnt++;
    }
    return cnt;
  }

  @Override
  public void setPos(int pos) {
    curr = head;
    for (int i = 0; (curr != null) && (i < pos); i++) {
      curr = curr.getNext();
    }
  }

  @Override
  public void setValue(Object val) {
    if (!isInList()) {
      throw new RuntimeException("curr is not in list.");
    }
    curr.getNext().setElement(val);
  }

  @Override
  public Object currValue() {
    if (!isInList()) {
      return null;
    }
    return curr.getNext().getElement();
  }

  @Override
  public boolean isEmpty() {
    return head.getNext() == null;
  }

  @Override
  public boolean isInList() {
    return curr != null && curr.getNext() != null;
  }

  @Override
  public void print() {
    if (isEmpty()) {
      System.out.println("()");
    } else {
      System.out.print("( ");
      for (setFirst(); isInList(); next()) {
        System.out.print((currValue() + " "));
      }
      System.out.print(")");
    }
  }
}
