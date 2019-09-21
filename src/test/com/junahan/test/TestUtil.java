package com.junahan.test;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.UUID;

public class TestUtil {

  public static List<TestElem> genTestElems(int minKey, int maxKey, int size) {
    Random random = new Random();
    List<TestElem> testElems = new ArrayList<>();
    for (int i = 0; i < size; i++) {
      testElems.add(new TestElem(random.nextInt(maxKey - minKey + 1) + minKey, UUID.randomUUID()));
    }
    return testElems;
  }

}
