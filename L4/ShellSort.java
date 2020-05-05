package L4;

import java.util.Arrays;

public class ShellSort {
  public static void sort(int[] a) {
    int N = a.length;

    int h = 1;
    while (h < N / 3)
      h = 3 * h + 1;

    while (h >= 1) {
      for (int i = h; i < N; i++) {
        for (int j = i; j >= h && a[j] < a[j - h]; j -= h) {
          swap(a, j, j - h);
        }
      }

      h = h / 3;
    }

  }

  private static void swap(int[] a, int i, int j) {
    int tmp = a[i];
    a[i] = a[j];
    a[j] = tmp;
    System.out.println(Arrays.toString(a));
  }

  public static void main(String[] args) {
    int[] a = { 9, 5, 2, 7, 0, 1 };
    ShellSort.sort(a);
    System.out.println(Arrays.toString(a));
  }
}