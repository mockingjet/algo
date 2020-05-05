package L1L2;

import java.util.Arrays;

public class QuickFind {

  int[] id;

  public QuickFind(int N) {
    // array key 為 node
    // array value 為 id
    id = new int[N];
    for (int i = 0; i < N; i++)
      id[i] = i;
    System.out.println(Arrays.toString(id));
    System.out.println();
  }

  /** 遍歷把相同pid的entry改成qid */
  void union(int p, int q) {
    System.out.println("union " + p + " " + q);
    int pid = id[p];
    for (int i = 0; i < id.length; i++)
      if (id[i] == pid)
        id[i] = id[q];
    System.out.println(Arrays.toString(id));
    System.out.println();
  }

  boolean isConnected(int p, int q) {
    return id[p] == id[q];
  }

  public static void main(String[] args) {
    QuickFind test = new QuickFind(10);
    test.union(3, 8);
    test.union(2, 3);
    test.union(2, 5);
    test.union(1, 3);
    System.out.println(test.isConnected(1, 5));
  }
}