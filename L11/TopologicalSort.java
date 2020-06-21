package L11;

import java.util.Stack;

public class TopologicalSort {
  // 拓樸排序結果不唯一

  private boolean[] visited;
  private Stack<Integer> postOrder;

  public TopologicalSort(WeightedDigraph G) {
    visited = new boolean[G.V()];
    postOrder = new Stack<Integer>();

    for (int v = 0; v < G.V(); v++) {
      if (!visited[v])
        dfs(G, v);
    }
  }

  private void dfs(WeightedDigraph G, int v) {
    visited[v] = true;
    for (DiEdge w : G.adj[v])
      if (!visited[w.to()])
        dfs(G, w.to());
    // v 所有的下一步都走完了
    postOrder.push(v);
  }

  public Iterable<Integer> order() {
    return postOrder;
  }
}