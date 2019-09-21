package com.junahan;

public class AList implements List {

  // the default array size
  private static final int defaultSize = 10;

  private int size;              // maximum size of list
  private int numInList;         // actual number of objects in list
  private int curr;              // position of current object
  private Object[] listArray;    // Array holding list objects

  public AList() {
    setup(defaultSize);
  }

  public AList(int size) {
    setup(size);
  }

  private void setup(int size) {
    this.size = size;
    numInList = curr = 0;
    listArray = new Object[size];
  }

  /**
   * Remove all objects from list.
    */
  public void clear() {
    // simple initialize values
    numInList = curr = 0;
  }

  /**
   * Insert object at curr position.
   *
   * @param item
   */
  public void insert(Object item) {
    if (numInList >= size) throw new RuntimeException("List is full.");
    if (curr < 0 || curr > numInList) throw new RuntimeException("Bad curr value.");

    for (int i = numInList; i > curr; i--) {
      listArray[i] = listArray[i - 1];
    }
    listArray[curr] = item;
    numInList++;
  }

  /**
   * Append item to the end.
   *
   * @param item
   */
  public void append(Object item) {
    if (numInList >= size) throw new RuntimeException("List is full.");
    listArray[numInList++] = item;
  }

  /**
   * Remove and return current object.
   *
   * @return
   */
  public Object remove() {
    if (isEmpty()) throw new RuntimeException("Cann't delete from empty list.");
    if (!isInList()) throw new RuntimeException("No current element.");
    Object it = listArray[curr];
    // shift element down.
    for (int i = curr; i < numInList; i--) {
      listArray[i] = listArray[i + 1];
    }
    numInList--;
    return it;
  }

  @Override
  public void setFirst() {
    curr = 0;
  }

  @Override
  public void next() {
    curr++;
  }

  @Override
  public void prev() {
    curr--;
  }

  @Override
  public int length() {
    return numInList;
  }

  @Override
  public void setPos(int pos) {
    curr = pos;
  }

  @Override
  public void setValue(Object val) {
    if (!isInList()) throw new RuntimeException("No current element.");
  }

  @Override
  public Object currValue() {
    if (!isInList()) throw new RuntimeException("No current element.");
    return listArray[curr];
  }

  @Override
  public boolean isEmpty() {
    return numInList == 0;
  }

  @Override
  public boolean isInList() {
    return (curr >= 0) && (curr < numInList);
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
