package com.junahan;

public class Graphs {

  public static void bfs(Graph g, int s) {
    AQueue q = new AQueue(g.n());
    q.enqueue(new Integer(s));
    g.setMark(s,1);

    while(!q.isEmpty()) {
      int v = ((Integer)q.dequeue()).intValue();
      preVisit(g,v);

      for (Edge w = g.first(v); g.isEdge(w); w = g.next(w)) {
        if (g.getMark(g.v2(w)) == 0) {
          g.setMark(g.v2(w), 1);
          q.enqueue(new Integer(g.v2(w)));
        }
      }

      postVisit(g,v);
    }

  }

  public static void dfs(Graph g, int v) {
    preVisit(g,v);
    g.setMark(v, 1);

    for (Edge w = g.first(v); g.isEdge(w); w = g.next(w)) {
      if (g.getMark(g.v2(w)) == 0) {
        dfs(g,g.v2(w));
      }
    }

    postVisit(g,v);
  }

  public static void dfsWithStack(Graph g, int s) {

  }

  private static void preVisit(Graph g, int s) {
    System.out.println(String.format("Pre visit vertex %s", s));
  }

  private static void postVisit(Graph g, int s) {
    System.out.println(String.format("Post visit vertex %s", s));
  }
}
