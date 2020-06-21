package L10;

import java.util.PriorityQueue;

public class LazyPrimMST {

  private boolean[] visited;
  private PriorityQueue<Edge> pq;
  private PriorityQueue<Edge> mst;

  public LazyPrimMST(WeightedGraph G) {
    visited = new boolean[G.V()];
    pq = new PriorityQueue<Edge>();
    mst = new PriorityQueue<Edge>();

    visit(G, 0);

    while (!pq.isEmpty()) {
      Edge e = pq.remove();
      int v = e.either();
      int w = e.other(v);

      if (visited[v] && visited[w])
        continue;

      mst.add(e);

      if (!visited[v])
        visit(G, v);
      if (!visited[w])
        visit(G, w);
    }
  }

  private void visit(WeightedGraph G, int v) {
    visited[v] = true;
    for (Edge e : G.adj[v])
      if (!visited[e.other(v)])
        pq.add(e);
  }

  public void printMST() {
    if (!mst.isEmpty()) {
      Edge e = mst.remove();
      int v = e.either();
      int w = e.other(v);
      System.out.print("(" + v + "," + w + "," + e.weight() + ")");
    } else
      return;
    while (!mst.isEmpty()) {
      Edge e = mst.remove();
      int v = e.either();
      int w = e.other(v);
      System.out.print(", (" + v + "," + w + "," + e.weight() + ")");
    }
  }

  public static void main(String[] args) {
    WeightedGraph wg = WeightedGraph.example();
    LazyPrimMST test = new LazyPrimMST(wg);
    test.printMST();
  }
}