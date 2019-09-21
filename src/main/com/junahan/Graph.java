package com.junahan;

public interface Graph {

  int n();                                   // number of vertexes
  int e();                                   // number of edge
  Edge first(int v);                         // get first edge for a vertex
  Edge next(Edge w);                         // get next edge for a vertex
  boolean isEdge(Edge w);                    // true if this is edge
  boolean isEdge(int i, int j);              // true if this is edge
  int v1(Edge w);                            // where edge from
  int v2(Edge w);                            // where edge gos to
  void setEdge(int i, int j, int weight);    // set edge weight
  void setEdge(Edge w, int weight);          // set edge weight
  void delEdge(Edge w);                      // delete edge
  void delEdge(int i, int j);                // delete edge
  int weight(Edge w);                        // return weight of edge
  void setMark(int v, int val);              // set mark for v
  int getMark(int v);                        // get mark for v

}
