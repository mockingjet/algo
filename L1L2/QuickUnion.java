package L1L2;

import java.util.Arrays;

public class QuickUnion {

  int[] id;

  public QuickUnion(int N) {
    // id[i] is parent of i.
    id = new int[N];
    for (int i = 0; i < N; i++)
      id[i] = i;
    System.out.println(Arrays.toString(id));
    System.out.println();
  }

  void union(int p, int q) {
    System.out.println("union " + p + " " + q);
    id[findRoot(p)] = findRoot(q);
    System.out.println(Arrays.toString(id));
    System.out.println();
  }

  int findRoot(int p) {
    // chase parent pointers until reach root
    while (id[p] != p) {
      id[p] = id[id[p]]; // 加上此行可已讓樹更平
      p = id[p];
    }
    return p;
  }

  boolean isConnected(int p, int q) {
    return findRoot(p) == findRoot(q);
  }

  public static void main(String[] args) {

    QuickUnion test = new QuickUnion(10);
    test.union(3, 8);
    test.union(2, 3);
    test.union(2, 5);
    test.union(1, 3);
    System.out.println(test.isConnected(1, 5));
  }
}