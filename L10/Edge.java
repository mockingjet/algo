package L10;

public class Edge implements Comparable<Edge> {
  private int v, w;
  private double weight;

  public Edge(int v, int w, double weight) {
    this.v = v;
    this.w = w;
    this.weight = weight;
  }

  public int either() {
    return v;
  }

  public int other(int other) {
    return other == v ? w : v;
  }

  public double weight() {
    return weight;
  }

  public int compareTo(Edge that) {
    return (int) this.weight - (int) that.weight;
  }
}