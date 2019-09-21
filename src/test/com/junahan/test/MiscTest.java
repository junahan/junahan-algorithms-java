package com.junahan.test;

import org.junit.Test;

public class MiscTest {

  @Test
  public void modOperatorTest() {
    int size = 20;
    for (int i = 0; i < size + 1; i++) {
      int r = (i + 1) % size;
      System.out.println(String.format("%s mod %s = %s",i,size,r));
    }
  }

}
