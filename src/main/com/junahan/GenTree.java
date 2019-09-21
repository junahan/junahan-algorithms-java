package com.junahan;

public interface GenTree {
  void clear();          // clear the tree
  GTNode root();         // return the root

  /**
   * Make the tree have a new root with children first and sibling.
   *
   * @param value
   * @param first
   * @param sibling
   */
  void newRoot(Object value, GTNode first, GTNode sibling);
}
