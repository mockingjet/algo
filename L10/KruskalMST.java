package L10;

import java.util.Arrays;
import java.util.PriorityQueue;

import L1L2.WeightedQuickUnion;

public class KruskalMST {
  // 1. sorting - ElogE
  // 2. isCircle - E^2(dfs) / logE(WQU)

  private PriorityQueue<Edge> mst;

  public KruskalMST(WeightedGraph G) {
    mst = new PriorityQueue<Edge>();
    WeightedQuickUnion wqu = new WeightedQuickUnion(G.V());
    Edge[] edges = G.edges();
    Arrays.sort(edges);

    for (int i = 0; i < edges.length; i++) {
      Edge e = edges[i];
      int v = e.either();
      int w = e.other(v);
      if (!wqu.isConnected(v, w)) {
        wqu.union(v, w);
        mst.add(e);
      }
    }
  }

  public void printMST() {
    while (!mst.isEmpty()) {
      Edge e = mst.poll();
      int v = e.either();
      int w = e.other(v);
      System.out.print("(" + v + "," + w + "," + e.weight() + ")" + ", ");
    }
  }

  public static void main(String[] args) {
    WeightedGraph graph = new WeightedGraph(6);
    graph.addEdge(new Edge(0, 1, 4));
    graph.addEdge(new Edge(0, 2, 3));
    graph.addEdge(new Edge(1, 3, 2));
    graph.addEdge(new Edge(1, 2, 5));
    graph.addEdge(new Edge(2, 3, 7));
    graph.addEdge(new Edge(3, 4, 2));
    graph.addEdge(new Edge(4, 0, 4));
    graph.addEdge(new Edge(4, 1, 4));
    graph.addEdge(new Edge(4, 5, 6));

    KruskalMST test = new KruskalMST(graph);
    test.printMST();
  }
}