package com.junahan;

/**
 * Binary search tree implementation.
 */
public class BST {
  private BinNode root;        // the root of the tree.

  public BST() {
    root = null;
  }

  public void clear() {
    root = null;
  }

  public void insert(Elem val) {
    root = insertHelp(root, val);
  }

  public void remove(int key) {
    root = removeHelp(root, key);
  }

  public Elem find(int key) {
    return findHelp(root, key);
  }

  public boolean isEmpty() {
    return root == null;
  }

  public void print() {
    if (root == null) {
      System.out.println("The BST is empty.");
    } else {
      printHelp(root, 0);
      System.out.println();
    }
  }

  private void printHelp(BinNode root, int level) {
    if (root == null) return;
    printHelp(root.left(), level + 1);
    for (int i = 0; i < level; i++) {    // indent based on level
      System.out.print("  ");
    }
    System.out.println((Elem)root.element());    // print node value
    printHelp(root.right(), level + 1);
  }

  private Elem findHelp(BinNode root, int key) {
    if (root == null) return null;
    Elem it = (Elem)root.element();
    if (it.key() > key) {
      return findHelp(root.left(), key);
    } else if (it.key() == key) {
      return it;
    } else {
      return findHelp(root.right(), key);
    }
  }

  /**
   *
   * @param root
   * @param key
   * @return
   */
  private BinNode removeHelp(BinNode root, int key) {
    if (root == null) return null;
    Elem it = (Elem)root.element();
    if (key < it.key()) {
      root.setLeft(removeHelp(root.left(), key));
    } else if (key > it.key()) {
      root.setRight(removeHelp(root.right(), key));
    } else { // found it
      if (root.left() == null) {
        root.setLeft(removeHelp(root.left(), key));
      } else if (root.right() == null) {
        root.setRight(removeHelp(root.right(), key));
      } else { // Town children
        Elem temp = getMin(root.right());
        root.setElement(temp);
        root.setRight(deleteMin(root.right()));
      }
    }
    return root;
  }

  private BinNode insertHelp(BinNode root, Elem val) {
    if (root == null) return new BinNodePtr(val);
    Elem it = (Elem)root.element();
    if (it.key() > val.key()) {
      root.setLeft(insertHelp(root.left(), val));
    } else {
      root.setRight(insertHelp(root.right(), val));
    }
    return root;
  }

  private Elem getMin(BinNode root) {
    if (root.left() == null) {
      return (Elem)root.element();
    } else {
      return getMin(root.left());
    }
  }

  private BinNode deleteMin(BinNode root) {
    if (root == null) {
      return root.right();
    } else {
      root.setLeft(deleteMin(root.left()));
      return root;
    }
  }
}
