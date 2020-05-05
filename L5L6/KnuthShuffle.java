package L5L6;

import java.util.Arrays;

public class KnuthShuffle {

  public static void shuffle(int[] a) {
    int n = a.length;
    for (int i = 0; i < n; i++) {
      int r = (int) (Math.random() * (i + 1));
      int swap = a[r];
      a[r] = a[i];
      a[i] = swap;
    }
  }

  public static void main(String[] args) {
    int[] a = { 9, 5, 2, 7, 0, 1 };
    KnuthShuffle.shuffle(a);
    System.out.println(Arrays.toString(a));
  }
}