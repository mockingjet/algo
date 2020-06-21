package L11;

import java.util.ArrayList;

public class WeightedDigraph {
  public ArrayList<DiEdge>[] adj;

  public WeightedDigraph(int V) {
    adj = new ArrayList[V];

    for (int v = 0; v < V; v++) {
      adj[v] = new ArrayList<DiEdge>();
    }
  }

  public int V() {
    return adj.length;
  }

  public void addEdge(DiEdge e) {
    int v = e.from();
    adj[v].add(e);
  }
}