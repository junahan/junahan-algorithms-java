package com.junahan;

/**
 * Linked table based queue.
 *
 */
public class LQueue {

  private Link front;        // pointer to front node
  private Link rear;         // pointer to rear node

  public LQueue() {
    front = rear = null;
  }

  /**
   * Remove all objects from queue.
   *
   */
  public void clear() {
    front = rear = null;
  }

  /**
   * Enqueue object at rear of queue.
   *
   * @param it the enqueue object.
   */
  public void enqueue(Object it) {
    if (rear != null ) {
      rear.setNext(new Link(it, null));
      rear = rear.getNext();
    } else {
      front = rear = new Link(it, null);
    }
  }

  /**
   * Dequeue object from front.
   *
   * @return the dequeue object.
   */
  public Object dequeue() {
    if (isEmpty()) throw new RuntimeException("Queue is empty.");
    Object it = front.getElement();
    front = front.getNext();
    if (front == null) rear = null;     // dequeued last object
    return it;
  }

  /**
   * .
   * @return the front object.
   */
  public Object firstValue() {
    if (isEmpty()) throw new RuntimeException("Queue is empty.");
    return front.getElement();
  }

  /**
   * Check whether the queue is empty.
   *
   * @return true if queue is empty.
   */
  public boolean isEmpty() {
    return front == null;
  }
}
