package L9;

import java.util.Stack;

public class TopologicalSort {
  // 拓樸排序結果不唯一

  private boolean[] visited;
  private Stack<Integer> postOrder;

  public TopologicalSort(DiGraph G) {
    visited = new boolean[G.V()];
    postOrder = new Stack<Integer>();

    for (int v = 0; v < G.V(); v++) {
      if (!visited[v])
        dfs(G, v);
    }
  }

  private void dfs(DiGraph G, int v) {
    visited[v] = true;
    for (int w : G.adj[v])
      if (!visited[w])
        dfs(G, w);
    // v 所有的下一步都走完了
    postOrder.push(v);
  }

  public void printResult() {
    System.out.print(postOrder.pop());
    while (!postOrder.empty())
      System.out.print(" -> " + postOrder.pop());
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

    TopologicalSort test = new TopologicalSort(g);
    test.printResult();
  }
}