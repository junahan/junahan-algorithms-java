package com.junahan.test;

import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;

import com.junahan.AStack;
import java.util.UUID;
import org.junit.Test;

public class AStackTest {

  @Test(expected = RuntimeException.class)
  public void popWithEmptyStackTest() {
    AStack stack = new AStack(20);
    assertTrue(stack.isEmpty());
    Object object = stack.pop();
    assertNull(object);
  }

  @Test(expected = RuntimeException.class)
  public void pushWithFullStackTest() {
    AStack stack = new AStack(2);
    stack.push(UUID.randomUUID());
    stack.push(UUID.randomUUID());
    stack.push(UUID.randomUUID());
  }
}
