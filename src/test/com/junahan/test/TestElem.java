package com.junahan.test;

import com.junahan.Elem;
import java.util.Objects;

public class TestElem implements Elem, Comparable {
  private int key;
  private Object val;

  public TestElem(int key, Object val) {
    this.key = key;
    this.val = val;
  }

  @Override
  public int key() {
    return key;
  }

  public Object getValue() {
    return val;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (!(o instanceof TestElem)) {
      return false;
    }
    TestElem testElem = (TestElem) o;
    return key == testElem.key &&
        Objects.equals(val, testElem.val);
  }

  @Override
  public int hashCode() {
    return Objects.hash(key, val);
  }

  @Override
  public String toString() {
    final StringBuilder sb = new StringBuilder("TestElem{");
    sb.append("key=").append(key);
    sb.append(", val=").append(val);
    sb.append('}');
    return sb.toString();
  }

  @Override
  public int compareTo(Object o) {
    if (this.key > ((TestElem)o).key()) {
      return 1;
    } else if (this.key < ((TestElem)o).key()) {
      return -1;
    }
    return 0;
  }
}
