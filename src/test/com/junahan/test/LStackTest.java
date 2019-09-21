package com.junahan.test;

import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;

import com.junahan.LStack;
import org.junit.Test;

public class LStackTest {

  @Test(expected = RuntimeException.class)
  public void popWithEmptyStackTest() {
    LStack stack = new LStack();
    assertTrue(stack.isEmpty());
    Object object = stack.pop();
    assertNull(object);
  }

  @Test
  public void pushWithNullObjectTest() {
    LStack stack = new LStack();
    stack.push(null);
    assertTrue(!stack.isEmpty());
  }
}
