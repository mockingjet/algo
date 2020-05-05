package L5L6;

import java.util.Arrays;

public class MergeSort {
  public static void sort(int[] a) {
    int[] aux = new int[a.length];
    divide(a, aux, 0, a.length - 1);
  }

  private static void divide(int[] a, int[] aux, int l, int h) {
    if (l >= h)
      return;
    int m = l + (h - l) / 2;
    System.out.println("divided into " + l + "~" + m + " and " + (m + 1) + "~" + h);
    divide(a, aux, l, m);
    divide(a, aux, m + 1, h);
    sort(a, aux, l, m, h);
  }

  private static void sort(int[] a, int[] aux, int l, int m, int h) {
    for (int i = l; i <= h; i++)
      aux[i] = a[i];

    int leftIdx = l, rightIdx = m + 1;
    for (int i = l; i <= h; i++) {
      if (leftIdx > m)
        a[i] = aux[rightIdx++];
      else if (rightIdx > h)
        a[i] = aux[leftIdx++];
      else if (aux[leftIdx] < aux[rightIdx])
        a[i] = aux[leftIdx++];
      else
        a[i] = aux[rightIdx++];
    }
    System.out.println("sort " + l + "~" + h + ": " + Arrays.toString(a));
  }

  public static void main(String[] args) {
    int[] a = { 9, 5, 2, 7, 0, 1 };
    MergeSort.sort(a);
    System.out.println(Arrays.toString(a));
  }
}