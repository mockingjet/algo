package L5L6;

import java.util.Arrays;

public class QuickSort {
  public static void sort(int[] a) {
    // KnuthShuffle.shuffle(a);
    sort(a, 0, a.length - 1, "start");
  }

  private static void sort(int[] a, int l, int h, String s) {
    System.out.println("partitioning: " + l + " ~ " + h + ", (" + s + ")");
    if (l >= h)
      return;

    // normal quicksort
    // int p = partition(a, l, h);
    // sort(a, l, p - 1, "left");
    // sort(a, p + 1, h, "right");

    // 3way quicksort
    int pivot = a[l], leftIdx = l, lt = l, gt = h;
    while (leftIdx <= gt) {
      if (a[leftIdx] < pivot)
        // 如果當前item比pivot小，跟a[lt]交換，lt++
        swap(a, lt++, leftIdx++);
      else if (a[leftIdx] > pivot)
        // 如果當前item比pivot大，跟a[gt]交換，gt--
        swap(a, leftIdx, gt--);
      else
        // 如果當前item==pivot，換下一個item
        leftIdx++;
    }

    sort(a, l, lt, "left");
    sort(a, gt + 1, h, "right");
  }

  // private static int partition(int a[], int l, int h) {
  // int leftIdx = l, rightIdx = h + 1;
  // while (true) {
  // while (a[++leftIdx] < a[l])
  // if (leftIdx == h)
  // break;

  // while (a[l] < a[--rightIdx])
  // if (rightIdx == l)
  // break;

  // if (leftIdx >= rightIdx) // crooss
  // break;
  // swap(a, leftIdx, rightIdx);
  // }
  // swap(a, l, rightIdx); // 最後把第一項跟cross的rightIdx做交換
  // return leftIdx;
  // }

  // private static int partition(int a[], int l, int h) {
  // int leftIdx = l;
  // for (int i = l; i < h; i++) {
  // if (a[i] <= a[h]) {
  // swap(a, leftIdx, i);
  // leftIdx++;
  // }
  // }

  // swap(a, leftIdx, h);
  // return leftIdx;
  // }

  private static void swap(int[] a, int i, int j) {
    int tmp = a[i];
    a[i] = a[j];
    a[j] = tmp;
    System.out.println(Arrays.toString(a));
  }

  public static void main(String[] args) {
    int[] a = { 9, 5, 2, 7, 0, 1, 8, 8, 4 };
    QuickSort.sort(a);
    System.out.println(Arrays.toString(a));
  }
}