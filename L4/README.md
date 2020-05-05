## Selection Sort

> Running time insensitive to input. Quadratic time, even if input is sorted.Data movement is minimal. Linear number of exchanges.

Invariants:
1. Entries the left of ↑ (including ↑) fixed and in ascending order.
2. No entry to right of ↑ is smaller than any entry to the left of ↑.


## InsertionSort

> To sort a randomly-ordered array with distinct keys, insertion sort uses ~ ¼ N 2 compares and ~ ¼ N 2 exchanges on average.

* best case: N-1 compares, 0 swap
* worst case: 1/2 * N^2 compares, 1/2 * N^2 swaps

Invariants:
1. Entries to the left of ↑ (including ↑) are in ascending order.
2. Entries to the right of ↑ have not yet been seen.

Improvements:
* Half Swaps => shift items over; eliminates unnecessary data movement
* Binary Insertion Sort => # of compares -> N*lgN

## ShellSort


## Knuth Shuffling

>common bug: between 0 and N – 1

>correct variant: between 0 and i

```java
public static void shuffle(Object[] a) {
  int N = a.length;
  for (int i = 0; i < N; i++) {
    int r = StdRandom.uniform(i + 1); // 0 <= r <= i
    exch(a, i, r);
  }
}
```

| i=0 | i=1 | i=2 |     |
|-----|-----|-----|-----|
|     |     | ABC | 1/6 |
|     |     | ACB | 1/6 |
|     | AB  | CBA | 1/6 |
| A   |     |     |     |
|     | BA  | BAC | 1/6 |
|     |     | BCA | 1/6 |
|     |     | CAB | 1/6 |