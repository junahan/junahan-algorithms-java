package com.junahan;

public interface BinNode {

  Object element();
  Object setElement(Object v);

  BinNode left();
  BinNode setLeft(BinNode left);

  BinNode right();
  BinNode setRight(BinNode right);

  boolean isLeaf();
}
