package L10;

public class EagerPrimMST {

  // 紀錄該點離T最小邊
  private Edge[] edgeTo;
  // 紀錄該點離T最小距離
  private double[] distTo;
  private boolean[] visited;
  private IndexMinPQ<Double> pq;

  public EagerPrimMST(WeightedGraph G) {
    edgeTo = new Edge[G.V()];
    distTo = new double[G.V()];
    visited = new boolean[G.V()];
    pq = new IndexMinPQ<Double>(G.V());

    for (int v = 0; v < G.V(); v++)
      distTo[v] = Double.POSITIVE_INFINITY;

    distTo[0] = 0.0;
    pq.insert(0, 0.0);
    while (!pq.isEmpty())
      visit(G, pq.delMin());
  }

  private void visit(WeightedGraph G, int v) {
    visited[v] = true;
    for (Edge e : G.adj[v]) {

      int w = e.other(v);
      if (visited[w])
        continue;
      if (e.weight() < distTo[w]) {
        edgeTo[w] = e;
        distTo[w] = e.weight();
        if (pq.contains(w)) {
          pq.changeKey(w, distTo[w]);
        } else
          pq.insert(w, distTo[w]);
      }
    }
  }

  public void printMST() {
    for (int i = 0; i < edgeTo.length; i++)
      if (edgeTo[i] != null) {
        int v = edgeTo[i].either();
        int w = edgeTo[i].other(v);
        System.out.println("(" + v + "," + w + "," + edgeTo[i].weight() + ")");
      }
  }

  public static void main(String[] args) {
    WeightedGraph wg = WeightedGraph.example();
    EagerPrimMST test = new EagerPrimMST(wg);
    test.printMST();
  }
}