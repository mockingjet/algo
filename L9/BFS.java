package L9;

import java.util.Queue;
import java.util.LinkedList;

public class BFS {
  private boolean[] visited;
  private int[] distTo;
  private Queue<Integer> queue;

  public BFS(Graph graph, int start) {
    visited = new boolean[graph.adj.length];
    distTo = new int[graph.adj.length];
    queue = new LinkedList<Integer>();

    visited[start] = true;
    distTo[start] = 0;
    queue.add(start);

    while (!queue.isEmpty()) {
      int v = queue.remove();
      for (int w : graph.adj[v]) {
        if (!visited[w]) {
          visited[w] = true;
          distTo[w] = distTo[v] + 1;
          queue.add(w);
        }
      }
    }
  }

  public int distTo(int t) {
    return distTo[t];
  }

  public static void main(String[] args) {
    Graph g = new Graph(10);
    g.addEdge(4, 7);
    g.addEdge(3, 5);
    g.addEdge(8, 4);
    g.addEdge(3, 8);

    BFS test = new BFS(g, 3);
    System.out.println(test.distTo(7));
  }
}