package L9;

import java.util.ArrayList;

public class DiGraph {
  public ArrayList<Integer>[] adj;

  public DiGraph(int V) {
    adj = new ArrayList[V];
    for (int v = 0; v < V; v++) {
      adj[v] = new ArrayList<Integer>();
    }
  }

  public int V() {
    return adj.length;
  }

  public void addEdge(Integer v, Integer w) {
    adj[v].add(w);
  }

  public void showGraph() {
    for (int v = 0; v < adj.length; v++) {
      System.out.println(v + ":" + adj[v].toString());
    }
  }

  public static void main(String[] args) {
    DiGraph g = new DiGraph(7);
    g.addEdge(0, 1);
    g.addEdge(0, 5);
    g.addEdge(0, 2);
    g.addEdge(1, 4);
    g.addEdge(3, 5);
    g.addEdge(5, 2);
    g.addEdge(6, 0);
    g.addEdge(6, 4);

    g.showGraph();
  }
}