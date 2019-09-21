package com.junahan;

public interface GTNode {

  Object value();                   // return the node value
  boolean isLeaf();                 // true if the node is leaf
  GTNode parent();                  // return parent
  GTNode leftMostChild();           // return left most child
  GTNode rightSibling();            // return right sibling
  void setValue(Object value);      // set the value
  void setParent(GTNode parent);    // set the parent
  void insertFirst(GTNode node);    // insert a new left most child
  void insertNext(GTNode node);     // insert a new right sibling
  void removeFirst();               // remove the left most child
  void removeNext();                // remove the right sibling

}

