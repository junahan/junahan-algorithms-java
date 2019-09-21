package com.junahan;

public interface List {

  void clear();

  void insert(Object item);

  void append(Object object);

  Object remove();

  void setFirst();

  void next();

  void prev();

  int length();

  void setPos(int pos);

  void setValue(Object val);

  Object currValue();

  boolean isEmpty();

  boolean isInList();

  void  print();

}
