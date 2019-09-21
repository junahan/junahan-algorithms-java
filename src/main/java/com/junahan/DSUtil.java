package com.junahan;

public class DSUtil {

  public static void swap(Object[] array, int index1, int index2) {
    if (index1 < 0 ||
        index1 > array.length ||
        index2 < 0 ||
        index2 > array.length) {
      throw new IllegalArgumentException("Invalid arguments index1 or index2");
    }

    Object temp = array[index1];
    array[index1] = array[index2];
    array[index2] = temp;
  }

}
