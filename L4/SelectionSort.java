package L4;

import java.util.Arrays;

public class SelectionSort {
  public static void sort(int[] a) {
    int N = a.length;
    for (int i = 0; i < N; i++) {
      int min = i;
      for (int j = i + 1; j < N; j++)
        if ((a[j] < a[min]))
          min = j;
      swap(a, i, min);
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
    SelectionSort.sort(a);
    System.out.println(Arrays.toString(a));
    System.out.println(Arrays.toString(a));
  }
}