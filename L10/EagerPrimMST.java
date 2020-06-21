package L10;

// import java.util.PriorityQueue;

public class EagerPrimMST {

  // // 紀錄該點離T最小邊
  // private Edge[] edgeTo;
  // // 紀錄該點離T最小距離
  // private double[] distTo;
  // private boolean[] visited;
  // private PriorityQueue<Double> pq;

  // public EagerPrimMST(WeightedGraph G) {
  // edgeTo = new Edge[G.V()];
  // distTo = new double[G.V()];
  // visited = new boolean[G.V()];
  // pq = new PriorityQueue<Double>(G.V());

  // for (int v = 0; v < G.V(); v++)
  // distTo[v] = Double.POSITIVE_INFINITY;

  // distTo[0] = 0.0;
  // pq.add(0, 0.0);
  // while (!pq.isEmpty())
  // visit(G, pq.remove());
  // }

  // private void visit(WeightedGraph G, int v) {
  // visited[v] = true;
  // for (Edge e : G.adj[v]) {

  // int w = e.other(v);
  // if (visited[w])
  // continue;
  // if (e.weight() < distTo[w]) {
  // edgeTo[w] = e;
  // distTo[w] = e.weight();
  // if (pq.contains(w)) {
  // pq.remove(w, distTo[w]);
  // pq.add(w, distTo[w]);
  // } else
  // pq.add(w, distTo[w]);
  // }
  // }
  // }

  // public static void main(String[] args) {
  // WeightedGraph wg = WeightedGraph.example();
  // EagerPrimMST test = new EagerPrimMST(wg);
  // }
}