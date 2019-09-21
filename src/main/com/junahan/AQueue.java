package com.junahan;

/**
 * Array-based queue.
 *
 */
public class AQueue {

  private static final int defaultSize = 10;

  private int size;        // Maximum size of queue
  private int front;       // Index prior to front item
  private int rear;        // Index of rear item

  private Object[] listArray;  // Array holding objects.

  /**
   * Initial Queue with default size.
   */
  public AQueue() {
    setup(defaultSize);
  }

  /**
   * Initial Queue with specific size.
   *
   * @param size
   */
  public AQueue(int size) {
    setup(size);
  }

  /*
   * initial the queue.
   */
  private void setup(int size) {
    this.size = size + 1;
    front = rear = 0;
    listArray = new Object[this.size];
  }

  /**
   * Remove all object in queue.
   */
  public void clear() {
    front = rear = 0;
  }

  /**
   * Enqueue object.
   *
   * @param it the object
   */
  public void enqueue(Object it) {
    if (isFull()) throw new RuntimeException("Queue is full.");
    rear = (rear + 1) % size;    // decrement index of rear.
    listArray[rear] = it;
  }

  /**
   * Dequeue object from front.
   *
   * @return object at the front.
   */
  public Object dequeue() {
    if (isEmpty()) throw new RuntimeException("Queue is empty.");
    front = (front + 1) % size;    // increment index of front.
    return listArray[front];
  }

  /**
   * .
   *
   * @return the value of front.
   */
  public Object firstValue() {
    if (isEmpty()) throw new RuntimeException("Queue is empty.");
    return listArray[(front + 1) % size];
  }

  /**
   * .
   * @return true if queue is full.
   */
  public boolean isFull() {
    return front == ((rear + 1) % size);
  }

  /**
   * .
   * @return true if queue is empty.
   */
  public boolean isEmpty() {
    return front == rear;
  }

}
