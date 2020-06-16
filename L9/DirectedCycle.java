package L9;

import java.util.Stack;

public class DirectedCycle {
  // do dfs exploration over graph, check if visited repeat
  // some exceptions:
  // parent link for undirected case
  // parent link and directed link factor
  // so we use onStack here

  private boolean[] visited;
  private int[] edgeTo;
  private Stack<Integer> cycle;
  private boolean[] onStack;

  public DirectedCycle(DiGraph G) {
    visited = new boolean[G.V()];
    edgeTo = new int[G.V()];
    onStack = new boolean[G.V()];
    for (int v = 0; v < G.V(); v++)
      if (!visited[v])
        dfs(G, v);
  }

  private void dfs(DiGraph G, int v) {
    visited[v] = true;
    onStack[v] = true;
    for (int w : G.adj[v]) {
      if (cycle != null)
        return;
      else if (!visited[w]) {
        edgeTo[w] = v;
        dfs(G, w);
      } else if (onStack[w]) {
        // 重複onStack代表形成一個cycle
        cycle = new Stack<Integer>();
        for (int x = v; x != w; x = edgeTo[x])
          cycle.push(x);
        cycle.push(w);
        cycle.push(v);
      }
    }
    onStack[v] = false;
  }
}