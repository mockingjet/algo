package L5L6;

public class QuickSelect {
  public static int select(int[] a, int k) {
    KnuthShuffle.shuffle(a);
    int lo = 0, hi = a.length - 1;
    while (hi > lo) {
      int j = partition(a, lo, hi);
      if (j < k)
        lo = j + 1;
      else if (j > k)
        hi = j - 1;
      else
        return a[k];
    }
    return a[k];
  }

  private static int partition(int a[], int l, int h) {
    int leftIdx = l, rightIdx = h + 1;
    while (true) {
      while (a[++leftIdx] < a[l])
        if (leftIdx == h)
          break;

      while (a[l] < a[--rightIdx])
        if (rightIdx == l)
          break;

      if (leftIdx >= rightIdx) // crooss
        break;
      swap(a, leftIdx, rightIdx);
    }
    swap(a, l, rightIdx); // 最後把第一項跟cross的rightIdx做交換
    return leftIdx;
  }

  private static void swap(int[] a, int i, int j) {
    int tmp = a[i];
    a[i] = a[j];
    a[j] = tmp;
  }

  public static void main(String[] args) {
    int[] a = { 9, 5, 2, 7, 0, 1, 8, 8, 4 };
    int k = 4;
    QuickSelect.select(a, k);
    System.out.println("top " + k + ": " + a[k]);
  }
}