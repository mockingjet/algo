package L1L2;

public class WeightedQuickUnion {

  private int[] id;
  private int[] sz;

  public WeightedQuickUnion(int N) {
    // id[i] 為 i 的父元素
    // id[id[i]] 為 i 的祖元素
    id = new int[N];
    sz = new int[N];
    for (int i = 0; i < N; i++) {
      id[i] = i;
      sz[i] = 0;
    }
  }

  public void union(int p, int q) {
    int proot = findRoot(p);
    int qroot = findRoot(q);
    if (sz[p] > sz[q]) {
      id[proot] = qroot;
      sz[proot] += sz[qroot];
    } else {
      id[qroot] = proot;
      sz[qroot] += sz[proot];
    }
  }

  public int findRoot(int p) {
    // id[p] == p 表示自己為根元素
    while (id[p] != p) {
      id[p] = id[id[p]]; // path compression
      p = id[p];
    }
    return p;
  }

  public boolean isConnected(int p, int q) {
    return findRoot(p) == findRoot(q);
  }

  public static void main(String[] args) {
    WeightedQuickUnion test = new WeightedQuickUnion(10);
    test.union(3, 8);
    test.union(2, 3);
    test.union(5, 2);
    test.union(1, 3);
    System.out.println(test.isConnected(5, 8));
    long startTime = System.nanoTime();
    for (int i = 0; i < 100; i++)
      test.isConnected(5, 8);
    long endTime = System.nanoTime();
    System.out.println(endTime - startTime);
  }
}