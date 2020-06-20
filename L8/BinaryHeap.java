package L8;

import java.util.Arrays;

public class BinaryHeap {
  // Binary Tree
  // Parent node with value larger than its children
  // Array Implemented
  // a[i] >= a[2*i] && a[i] >= a[2*i+1]
  // parent i => children 2*i, 2*i+1
  // child i => parent floor(i/2)
  // PriorityQueue

  private int[] array;
  private int tail;

  private final int head = 1;

  public BinaryHeap(int[] array) {
    this.array = array;
    this.tail = array.length - 1;
  }

  public void insert(int value) {
    array[++tail] = value;
    swimUp(tail);
  }

  public int delmax() {
    int max = array[head];
    swap(head, tail--);
    sinkDown(head);
    return max;
  }

  private void swimUp(int idx) {
    while (idx > 1 && array[idx / 2] < array[idx]) {
      swap(idx, idx / 2);
      idx = idx / 2;
    }
  }

  private void sinkDown(int idx) {
    while (idx * 2 <= tail) {
      int tmp = 2 * idx;
      if (tmp < tail && array[tmp] < array[tmp + 1])
        tmp++;
      if (array[idx] >= array[tmp])
        break;
      swap(idx, tmp);
      idx = tmp;
    }
  }

  private void swap(int i, int j) {
    // System.out.println(i + " " + j);
    int tmp = array[i];
    array[i] = array[j];
    array[j] = tmp;
  }

  public void printResult() {
    System.out.println(Arrays.toString(this.array));
  }

  public static void main(String[] args) {
    int[] array = { 0, 10, 7, 8, 3, 4, 6, 2 };
    BinaryHeap test = new BinaryHeap(array);
    System.out.println(test.delmax());
    System.out.println(test.delmax());
    test.printResult();
    System.out.println(test.delmax());
    test.printResult();
    test.insert(20);
    test.insert(25);
    test.insert(12);
    test.printResult();
  }
}