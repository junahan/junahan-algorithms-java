package com.junahan.test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import com.junahan.Elem;
import com.junahan.MaxHeap;
import java.util.List;
import java.util.UUID;
import org.junit.Test;

public class MaxHeapTest {

  @Test
  public void removeMaxTest() {
    List<TestElem> elems = TestUtil.genTestElems(0,8, 9);
    elems.add(new TestElem(100, UUID.randomUUID()));
    Elem[] heap = new Elem[elems.size()];
    elems.toArray(heap);

    MaxHeap mh = new MaxHeap(heap,heap.length,20);
    assertNotNull(mh);
    assertEquals(elems.size(), mh.size());
    Elem max = mh.removeMax();
    assertNotNull(max);
    assertEquals(elems.get(elems.size() - 1), max);
  }

  @Test
  public void removeTest() {
    List<TestElem> elems = TestUtil.genTestElems(0,8, 10);
    Elem[] heap = new Elem[elems.size()];
    elems.toArray(heap);

    MaxHeap mh = new MaxHeap(heap,heap.length,20);
    assertNotNull(mh);
    int pos = 5;
    Elem expected = heap[pos];
    Elem r = mh.remove(pos);
    assertNotNull(r);
    assertEquals(expected,r);
  }

  @Test(expected = RuntimeException.class)
  public void removeFromEmptyHeapTest() {
    MaxHeap mh = new MaxHeap(null, 0, 20);
    assertNotNull(mh);
    Elem max = mh.removeMax();
  }

}
