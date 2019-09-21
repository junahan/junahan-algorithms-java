package com.junahan.test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import com.junahan.ArrayUtil;
import com.junahan.Elem;
import java.util.Arrays;
import java.util.List;
import org.junit.Test;

public class ArrayUtilTest {

  @Test
  public void qSortTestWithNormal() {
    int min = 0;
    int max = 8;
    Elem[] array = genTestData(min,max,20);

    ArrayUtil.qSort(array, 0, array.length - 1);
    doAssertion(array, min, max);
  }

  @Test
  public void qSortTestWithSortedArray() {
    int min = 0;
    int max = 8;
    Elem[] array = genTestData(min,max,20);
    Arrays.sort(array);

    ArrayUtil.qSort(array, 0, array.length - 1);
    doAssertion(array, min, max);
  }

  @Test
  public void qSortTestWithMultiDuplicationData() {
    int min = 2;
    int max = 2;
    Elem[] array = genTestData(min,max,20000);

    ArrayUtil.qSort(array, 0, array.length - 1);
    doAssertion(array, min, max);
  }

  @Test
  public void shellSortTestWithNormal() {
    int min = 0;
    int max = 8;
    Elem[] array = genTestData(min,max,20);

    ArrayUtil.shellSort(array);
    doAssertion(array, min, max);
  }

  @Test
  public void insSortTestWithNormal() {
    int min = 0;
    int max = 8;
    Elem[] array = genTestData(min,max,20);

    ArrayUtil.insSort(array);
    doAssertion(array, min, max);
  }

  @Test
  public void mergeSortTestWithNormal() {
    int min = 0;
    int max = 8;
    Elem[] array = genTestData(min,max,20);
    Elem[] temp = new Elem[20];

    ArrayUtil.mergeSort(array,temp,0,array.length - 1);
    doAssertion(array, min, max);
  }

  @Test
  public void bubSortTestWithNormal() {
    int min = 0;
    int max = 8;
    Elem[] array = genTestData(min,max,20);

    ArrayUtil.bubSort(array);
    doAssertion(array, min, max);
  }

  @Test
  public void heapSortTestWithNormal() {
    int min = 0;
    int max = 8;
    Elem[] array = genTestData(min,max,20);

    ArrayUtil.heapSort(array);
    doAssertion(array, min, max);
  }

  @Test
  public void binarySearchTest() {
    Elem[] a = genTestData(5);
    for (int i = 0; i < a.length; i++) {
      int index = ArrayUtil.binarySearch(a, i);
      assertEquals(i,index);
    }

    Elem[] b = genTestData(10);
    for (int i = 0; i < b.length; i++) {
      int index = ArrayUtil.binarySearch(b, i);
      assertEquals(i,index);
    }
  }

  @Test
  public void binarySearchTestWithNonExistKey() {
    Elem[] a = genTestData(5);
    int index = ArrayUtil.binarySearch(a, -5);
    assertTrue(index < 0);
    index = ArrayUtil.binarySearch(a, 10);
    assertTrue(index < 0);
  }

  private Elem[] genTestData(int size) {
    Elem[] elems = new Elem[size];
    for (int i = 0; i < size; i++ ) {
      elems[i] = new TestElem(i,"");
    }
    return elems;
  }

  private Elem[] genTestData(int minKey, int maxKey, int size) {
    List<TestElem> elems = TestUtil.genTestElems(minKey,maxKey, size);
    Elem[] array = new Elem[elems.size()];
    elems.toArray(array);
    return array;
  }

  private void doAssertion(Elem[] array, int min, int max) {
    for (int i = 0; i < array.length; i++) {
      assertTrue(array[i].key() >= min);
      assertTrue(array[i].key() <= max);
      if (i > 0) {
        assertTrue(array[i].key() >= array[i - 1].key());
      }
    }
  }
}
