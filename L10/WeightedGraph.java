package L10;

import java.util.ArrayList;
import java.util.Stack;

public class WeightedGraph {
  public ArrayList<Edge>[] adj;
  private Stack<Edge> edges;

  public WeightedGraph(int V) {
    adj = new ArrayList[V];
    edges = new Stack<Edge>();

    for (int v = 0; v < V; v++) {
      adj[v] = new ArrayList<Edge>();
    }
  }

  public int V() {
    return adj.length;
  }

  public void addEdge(Edge e) {
    int v = e.either();
    int w = e.other(v);
    adj[v].add(e);
    adj[w].add(e);
    edges.push(e);
  }

  public Edge[] edges() {
    return edges.toArray(new Edge[0]);
  }
}