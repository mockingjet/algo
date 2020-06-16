package L9;

import java.util.Stack;

public class DFS {
  private boolean[] visited;
  private int[] edgeTo;
  private int start;

  public DFS(Graph graph, int start) {
    this.visited = new boolean[graph.adj.length];
    this.edgeTo = new int[graph.adj.length];
    this.start = start;
    dfs(graph, start);
  }

  private void dfs(Graph graph, int v) {
    visited[v] = true;
    for (int w : graph.adj[v]) {
      if (!visited[w]) {
        edgeTo[w] = v;
        dfs(graph, w);
      }
    }
  }

  public Iterable<Integer> pathTo(int v) {
    if (!visited[v])
      return null;
    Stack<Integer> path = new Stack<Integer>();
    for (int w = v; w != start; w = edgeTo[w])
      path.push(w);

    path.push(start);
    return path;
  }

  public static void main(String[] args) {
    Graph g = new Graph(10);
    g.addEdge(4, 7);
    g.addEdge(3, 5);
    g.addEdge(8, 4);
    g.addEdge(3, 8);

    DFS test = new DFS(g, 3);
    Iterable<Integer> path = test.pathTo(7);
    System.out.println(path.toString());
  }
}