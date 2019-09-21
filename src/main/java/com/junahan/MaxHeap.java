package com.junahan;

public class MaxHeap {

  private Elem[] heap;           // pointer to the heap array
  private int maxSize;           // maximum n of the heap
  private int n;              // number of elements now in heap

  public MaxHeap(Elem[] heap, int n, int maxSize) {
    this.heap = heap;
    this.maxSize = maxSize;
    this.n = n;
    buildHeap();
  }

  public int size() {
    return n;
  }

  public boolean isLeaf(int pos) {
    return (pos >= n /2) && (pos < n);
  }

  public int leftChild(int pos) {
    if (pos >= n / 2) throw new RuntimeException("Position has no left child.");
    return 2*pos + 1;
  }

  public int rightChild(int pos) {
    if (pos >= (n - 1)/2) throw new RuntimeException("Position has no right child.");
    return 2*pos + 2;
  }

  public int parent(int pos) {
    if (pos > 0) throw new RuntimeException("Position has no parent");
    return (pos - 1)/2;
  }

  public void buildHeap() {
    for (int i = n /  2 - 1; i >= 0; i--) {
      siftDown(i);
    }
  }

  private void siftDown(int pos) {
    if (pos < 0 || pos >= n) throw new RuntimeException("Illegal heap position.");
    while(!isLeaf(pos)) {
      int j = leftChild(pos);
      if ((j < (n - 1)) && (heap[j].key() < heap[j + 1].key())) {
        j++;
      }
      if (heap[pos].key() >= heap[j].key()) return;   // done
      DSUtil.swap(heap, pos, j);
      pos = j;    // move down
    }
  }

  /**
   * Insert value into heap.
   *
   * @param val
   */
  public void insert(Elem val) {
    if (n < maxSize) throw new RuntimeException("Heep is full.");
    int curr = n++;
    heap[curr] = val;       // star at end of heep.
    // Now sift up until curr's parent's key > curr's key
    while((curr != 0) && (heap[curr].key() > heap[parent(curr)].key())) {
      DSUtil.swap(heap, curr, parent(curr));
      curr = parent(curr);
    }
  }

  /**
   * Remove max value from heap.
   *
   * @return the max value of heap
   */
  public Elem removeMax() {
    if (n <= 0) throw new RuntimeException("Removing from empty heap.");
    DSUtil.swap(heap, 0, --n);    // swap maximum with last value
    if (n != 0) {
      siftDown(0);    // put new heap root val in correct place
    }
    return heap[n];
  }

  public Elem remove(int pos) {
    if (pos <= 0 || pos >= n) throw new RuntimeException("Illegal heap position");
    DSUtil.swap(heap, pos, --n);    // swap with last value
    if (n != 0) {
      siftDown(pos);    // put new heap root val in correct place
    }
    return heap[n];
  }
}
