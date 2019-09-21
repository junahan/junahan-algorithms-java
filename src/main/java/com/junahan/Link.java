package com.junahan;

public class Link {

  private Object element;
  private Link next;

  public Link(Object element, Link next) {
    this.element = element;
    this.next = next;
  }

  public Link(Link next) {
    this.next = next;
  }

  public Object getElement() {
    return element;
  }

  public void setElement(Object element) {
    this.element = element;
  }

  public Link getNext() {
    return next;
  }

  public void setNext(Link next) {
    this.next = next;
  }
}
