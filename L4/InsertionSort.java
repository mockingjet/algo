package L4;

import java.util.Arrays;

public class InsertionSort {
  public static void sort(int[] a) {
    int N = a.length;
    for (int i = 0; i < N; i++) {
      for (int j = i; j > 0 && a[j] < a[j - 1]; j--) {
        swap(a, j, j - 1);
      }
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
    InsertionSort.sort(a);
    System.out.println(Arrays.toString(a));
  }
}