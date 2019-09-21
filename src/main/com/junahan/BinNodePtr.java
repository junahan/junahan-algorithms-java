package com.junahan;

public class BinNodePtr implements BinNode {
  private Object element;        // the element of the node;
  private BinNode left;          // the left node.
  private BinNode right;         // the right node.

  public BinNodePtr() {
    left = right = null;
  }

  public BinNodePtr(Object element) {
    this.element = element;
    left = right = null;
  }

  public BinNodePtr(Object element, BinNode left, BinNode right) {
    this.element = element;
    this.left = left;
    this.right = right;
  }

  @Override
  public Object element() {
    return element;
  }

  @Override
  public Object setElement(Object element) {
    return this.element = element;
  }

  @Override
  public BinNode left() {
    return left;
  }

  @Override
  public BinNode setLeft(BinNode left) {
    return this.left = left;
  }

  @Override
  public BinNode right() {
    return right;
  }

  @Override
  public BinNode setRight(BinNode right) {
    return this.right = right;
  }

  @Override
  public boolean isLeaf() {
    return left == null && right == null;
  }
}
