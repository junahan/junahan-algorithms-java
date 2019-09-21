package com.junahan.test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import java.util.List;
import java.util.UUID;

import com.junahan.BST;
import com.junahan.Elem;

import org.junit.Test;

public class BSTTest {

  @Test
  public void insertTest() {
    BST bst = new BST();
    List<Elem> tests = TestUtil.genTestElems(10, 30, 10);
    TestElem min = new TestElem(0, UUID.randomUUID());
    TestElem max = new TestElem(100, UUID.randomUUID());
    tests.add(min);
    tests.add(max);
    for (Elem el:tests) {
      bst.insert(el);
    }
    assertTrue(!bst.isEmpty());
    bst.print();
    Elem  element = bst.find(min.key());
    //    TestElem elemet2 = bst.
    assertNotNull(element);
    assertEquals(min, element);
    element = bst.find(max.key());
    assertNotNull(element);
    assertEquals(max,element);
  }
}
