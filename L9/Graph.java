package L9;

import java.util.ArrayList;

public class Graph {
  public ArrayList<Integer>[] adj;

  public Graph(int V) {
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
    adj[w].add(v);
  }

  public void showGraph() {
    for (int v = 0; v < adj.length; v++) {
      System.out.println(v + ":" + adj[v].toString());
    }
  }

  public static void main(String[] args) {
    Graph g = new Graph(10);
    g.addEdge(1, 2);
    g.addEdge(3, 5);
    g.addEdge(2, 9);
    g.addEdge(3, 8);

    g.showGraph();
  }
}