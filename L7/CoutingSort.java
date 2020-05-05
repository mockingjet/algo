package L7;

import java.util.Arrays;

public class CoutingSort {
  public static void sort(String[] a, int R) {
    int N = a.length;
    String[] aux = new String[N];
    int[] count = new int[R + 1];

    // count
    for (int i = 0; i < N; i++)
      count[a[i].hashCode() - 97 + 1]++;

    // accumulate
    for (int r = 0; r < R; r++)
      count[r + 1] += count[r];

    // rearrange
    for (int i = 0; i < N; i++)
      aux[count[a[i].hashCode() - 97]++] = a[i];

    // copy
    for (int i = 0; i < N; i++)
      a[i] = aux[i];
  }

  public static void main(String[] args) {
    String[] a = { "d", "c", "f", "f", "b", "d", "f", "b", "f", "b", "e", "a" };
    int R = 6;
    CoutingSort.sort(a, R);
    System.out.println(Arrays.toString(a));
  }
}