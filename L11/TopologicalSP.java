package L11;

public class TopologicalSP {
  private DiEdge[] edgeTo;
  private double[] distTo;

  public TopologicalSP(WeightedDigraph G, int s) {
    edgeTo = new DiEdge[G.V()];
    distTo = new double[G.V()];

    for (int v = 0; v < G.V(); v++)
      distTo[v] = Double.POSITIVE_INFINITY;

    distTo[s] = 0.0;

    TopologicalSort topological = new TopologicalSort(G);
    for (int v : topological.order())
      for (DiEdge e : G.adj[v])
        relax(e);
  }

  public void relax(DiEdge e) {
    int v = e.from(), w = e.to();
    if (distTo[w] > distTo[v] + e.weight()) {
      distTo[w] = distTo[v] + e.weight();
      edgeTo[w] = e;
    }
  }
}