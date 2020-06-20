package L8;

import java.util.Arrays;
import java.util.PriorityQueue;

public class Heapsort {
  public void sort(int[] array) {
    int N = array.length;
    PriorityQueue<Integer> pq = new PriorityQueue<Integer>();
    for (int i = 0; i < N; i++)
      pq.add(array[i]);
    for (int i = N - 1; i >= 0; i--)
      array[i] = pq.remove();
  }

  public static void main(String[] args) {
    Heapsort test = new Heapsort();
    int[] array = { 0, 10, 7, 8, 3, 4, 6, 2 };
    test.sort(array);
    System.out.println(Arrays.toString(array));
  }
}