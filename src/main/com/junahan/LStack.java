package com.junahan;

public class LStack {

  private Link top;        // Pointer to list head

  public LStack() {
    top = null;
  }

  /**
   *  Remove all object from stack.
   *
   */
  public void clear() {
    top = null;
  }

  /**
   * Push object into stack at head.
   *
   * @param it the pushed object.
   */
  public void push(Object it) {
    top = new Link(it,top);
  }

  /**
   * Pop object at top of stack.
   *
   * @return the object at the top.
   */
  public Object pop() {
    if (isEmpty()) throw new RuntimeException("Stack is empty.");
    Object it = top.getElement();
    top = top.getNext();
    return it;
  }

  /**
   * Get value of top object.
   *
   * @return the value of the top object.
   */
  public Object topVlue() {
    if (isEmpty()) return null;
    return top.getElement();
  }

  /**
   * .
   *
   * @return true if stack is empty.
   */
  public boolean isEmpty() {
    return top == null;
  }
}
