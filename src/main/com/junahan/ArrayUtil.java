package com.junahan;

public class ArrayUtil {

  /**
   * Insert sorting algorithm.
   *
   * @param array original array.
   */
  public static void insSort(Elem[] array) {
    for (int i = 1; i < array.length; i++) {
      for (int j = i; (j > 0) && (array[j].key() < array[j - 1].key()); j--) {
        DSUtil.swap(array, j, j - 1);
      }
    }
  }

  /**
   * Bubble sorting algorithm.
   *
   * @param array
   */
  public static void bubSort(Elem[] array) {
    for (int i = 0; i < array.length; i++) {
      for (int j = array.length - 1; j > i; j--) {
        if (array[j].key() < array[j - 1].key()) {
          DSUtil.swap(array, j, j - 1);
        }
      }
    }
  }

  /**
   * Select sorting algorithm.
   *
   * @param array
   */
  public static void selSort(Elem[] array) {
    for (int i = 0; i < array.length; i++) {
      int lowIndex = i;
      for (int j = array.length - 1; j > i; j--) {
        if (array[j].key() < array[lowIndex].key()) {
          lowIndex = j;
        }
      }
      DSUtil.swap(array, i, lowIndex);
    }
  }

  /**
   * Shell sorting algorithm.
   *
   * @param array
   */
  public static void shellSort(Elem[] array) {
    for (int i = array.length/2; i > 2; i /= 2) {
      for (int j = 0; j < i; j++) {
        insSort2(array, j, i);
      }
    }
    insSort2(array, 0, 1);
  }

  /*
   * Insert sorting, used by shell sorting algorithm.
   */
  private static void insSort2(Elem[] array, int start, int incr) {
    for (int i = start + incr; i < array.length; i += incr) {
      for (int j = i; (j >= incr) && (array[j].key() < array[j - incr].key()); j -= incr) {
        DSUtil.swap(array, j, j - incr);
      }
    }
  }

  /**
   * Quick sorting algorithm.
   *
   * @param array
   * @param i
   * @param j
   */
  public static void qSort(Elem[] array, int i, int j) {
    int pivotIndex = (i + j)/2;                      // pik a pivot
    DSUtil.swap(array, pivotIndex, j);               // stick pivot at end

    // k will be the first position in the right subarray
    int k = partition(array, i - 1, j, array[j].key());
    DSUtil.swap(array, k, j);                        // put pivot in place
    if ((k - i) > 1) qSort(array, i, k - 1);      // sort the left partition
    if ((j - k) > 1) qSort(array, k + 1, j);      // sort the right partition
  }

  /*
   * Partition the array to two virtual array -
   *  - values in left partition are less than pivot
   *  - values in right partition are more than pivot
   */
  private static int partition(Elem[] array, int l, int r, int pivot) {
    do {
      while(array[++l].key() < pivot) {}            // move left bound to right
      while(r > 0 && array[--r].key() > pivot) {}   // move right bound to left
      DSUtil.swap(array,l,r);                       // swap out-of-place value
    } while(l < r);                                 // stop when they cross
    DSUtil.swap(array,l,r);                         // reverse last wasted swap
    return l;                                       // return first position in right partition
  }

  /**
   * Merge sorting algorithm.
   *
   * @param array
   * @param temp
   * @param l
   * @param r
   */
  public static void mergeSort(Elem[] array, Elem[] temp, int l, int r) {
    int mid = (l + r)/2;
    if (l == r) return;                          // list has only one element.
    mergeSort(array,temp,l, mid);                // mergesort first half
    mergeSort(array,temp, mid + 1, r);        // mergesort second half

    // copy subarray to temp.
    for (int i = l; i <= r; i++) {
      temp[i] = array[i];
    }

    // merge back to array
    int i1 = l;
    int i2 = mid + 1;
    for (int curr = l; curr <= r; curr++) {
      if (i1 == mid + 1) {          // left sublist exhausted
        array[curr] = temp[i2++];
      } else if (i2 > r) {          // right sublist exhausted
        array[curr] = temp[i1++];
      } else if (temp[i1].key() < temp[i2].key()) {
        array[curr] = temp[i1++];
      } else {
        array[curr] = temp[i2++];
      }
    }
  }

  /**
   * Heap sorting algorithm.
   *
   * @param array
   */
  public static void heapSort(Elem[] array) {
    MaxHeap h = new MaxHeap(array, array.length, array.length);
    for (int i = 0; i < array.length; i++) {
      h.removeMax();        // Removmax places max value at end of the heap.
    }
  }

  /**
   * Binary search for a sorted array.
   *
   * @param array
   * @param key
   * @return
   */
  public static int binarySearch(Elem[] array, int key) {
    int lowIndex = 0;
    int highIndex = array.length - 1;
    while (lowIndex <= highIndex) {
      int mid = (lowIndex + highIndex) / 2;
      if (array[mid].key() < key) {
        lowIndex = mid + 1;
      } else if (array[mid].key() > key) {
        highIndex = mid - 1;
      } else {
        return mid;                // find key.
      }
    }
    return -(lowIndex + 1);        // key not found.
  }
}
