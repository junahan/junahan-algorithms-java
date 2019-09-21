package com.junahan;

public class AStack {

  private static final int defaultSize = 10;    // default maximum size of stack
  private int size;            // Maximum size of stack
  private int top;             // index for top object
  private Object[] listArray;  // array holding stack objects

  public AStack() {
    setup(defaultSize);
  }

  public AStack(int size) {
    setup(size);
  }

  /*
   * Setup the stack.
   * @param size
   */
  private void setup(int size) {
    this.size = size;
    top = 0;
    listArray = new Object[this.size];
  }

  /**
   * Remove all objects from stack
   */
  public void clear() {
    top = 0;
  }

  /**
   * Push object onto stack - on top.
   *
   * @param it
   */
  public void push(Object it) {
    if (top >= size) throw new RuntimeException("Stack overflow.");
    listArray[top++] = it;
  }

  /**
   * Pop object from top of the stack.
   *
   * @return object from top
   */
  public Object pop() {
    if (isEmpty()) throw new RuntimeException("Stack is empty.");
    return listArray[--top];
  }

  /**
   * Return value of top object.
   *
   * @return
   */
  public Object getTopValue() {
    if (isEmpty()) return null;
    return listArray[top - 1];
  }

  /**
   * Return true if stack is empty.
   *
   * @return
   */
  public boolean isEmpty() {
    return top == 0;
  }

}
