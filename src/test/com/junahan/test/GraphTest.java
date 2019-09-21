package com.junahan.test;

import com.junahan.Graph;
import com.junahan.Graphm;
import com.junahan.Graphs;
import org.junit.Test;

public class GraphTest {

  @Test
  public void testDfsTravel() {
    // create the graph.
    Graph g = new Graphm(4);
    g.setEdge(0,1, 1);
    g.setEdge(0,2, 1);
    g.setEdge(1,3, 1);
    g.setEdge(3,2, 1);
    // test Bfs travel

    Graphs.dfs(g,0);
  }


  @Test
  public void testDfsWithStackTravel() {
    // create the graph.
    Graph g = new Graphm(4);
    g.setEdge(0,1, 1);
    g.setEdge(0,2, 1);
    g.setEdge(1,3, 1);
    g.setEdge(3,2, 1);
    // test Bfs travel

    Graphs.dfsWithStack(g,0);
  }

  @Test
  public void testBfsTravel() {
    // create the graph.
    Graph g = new Graphm(4);
    g.setEdge(0,1, 1);
    g.setEdge(0,2, 1);
    g.setEdge(1,3, 1);
    g.setEdge(3,2, 1);
    // test Bfs travel

    Graphs.bfs(g,0);
  }
}
