package com.junahan;

public class Graphm implements Graph {
  private int[][] matrix;        // the edge matrix
  private int numEdge;           // number of edge
  private int[] mark;            // the mark array

  public Graphm(int n) {
    mark = new int[n];
    matrix = new int[n][n];
    numEdge = 0;
  }

  @Override
  public int n() {
    return mark.length;
  }

  @Override
  public int e() {
    return numEdge;
  }

  @Override
  public Edge first(int v) {
    for (int i = 0; i < mark.length; i++) {
      if (matrix[v][i] != 0) {
        return new Edgem(v,i);
      }
    }
    return null;
  }

  @Override
  public Edge next(Edge w) {
    if (null == w) return null;
    for (int i = w.v2() + 1; i < mark.length; i++) {
      if (matrix[w.v1()][i] != 0) {
        return new Edgem(w.v1(), i);
      }
    }
    return null;
  }

  @Override
  public boolean isEdge(Edge w) {
    if (null == w) return false;
    return matrix[w.v1()][w.v2()] != 0;
  }

  @Override
  public boolean isEdge(int i, int j) {
    return matrix[i][j] != 0;
  }

  @Override
  public int v1(Edge w) {
    return w.v1();
  }

  @Override
  public int v2(Edge w) {
    return w.v2();
  }

  @Override
  public void setEdge(int i, int j, int weight) {
    if (weight == 0) throw new IllegalArgumentException("Cannot set weight to 0.");
    matrix[i][j] = weight;
    numEdge++;
  }

  @Override
  public void setEdge(Edge w, int weight) {
    if (weight == 0) throw new IllegalArgumentException("Cannot set weight to 0.");
    matrix[w.v1()][w.v2()] = weight;
    numEdge++;
  }

  @Override
  public void delEdge(Edge w) {
    if (null != w) {
      if (matrix[w.v1()][w.v2()] != 0) {
        matrix[w.v1()][w.v2()] = 0;
        numEdge--;
      }
    }
  }

  @Override
  public void delEdge(int i, int j) {
    if (matrix[i][j] != 0) {
      matrix[i][j] = 0;
      numEdge--;
    }
  }

  @Override
  public int weight(Edge w) {
    if (null == w) throw new IllegalArgumentException("Cannot take weight of null edge.");
    if (matrix[w.v1()][w.v2()] == 0) {
      return Integer.MAX_VALUE;
    } else {
      return matrix[w.v1()][w.v2()];
    }
  }

  @Override
  public void setMark(int v, int val) {
    mark[v] = val;
  }

  @Override
  public int getMark(int v) {
    return mark[v];
  }
}
