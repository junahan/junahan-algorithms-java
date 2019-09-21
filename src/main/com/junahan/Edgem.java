package com.junahan;

public class Edgem implements Edge {

  private int vert1, vert2;    // The vertex indices

  public Edgem(int vert1, int vert2) {
    this.vert1 = vert1;
    this.vert2 = vert2;
  }

  @Override
  public int v1() {
    return vert1;
  }

  @Override
  public int v2() {
    return vert2;
  }

  @Override
  public String toString() {
    final StringBuilder sb = new StringBuilder("Edgem{");
    sb.append("vert1=").append(vert1);
    sb.append(", vert2=").append(vert2);
    sb.append('}');
    return sb.toString();
  }
}
