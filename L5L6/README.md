## MergeSort

Basic Plan:
1. Divide array into two halves.
2. Recursively sort each half.
3. Merge two halves.

> divide and conquer

```js
If D (N) satisfies D (N) = 2 D (N / 2) + N for N > 1, with D (1) = 0, then D (N) = N lg N.

D (N) = 2 D (N/2) + N

D (N) / N = 2 D (N/2) / N + 1
          = D (N/2) / (N/2) + 1 // 代數轉換
          = D (N/4) / (N/4) + 1 + 1 // D(N)/N =2D(N/2)/N+1
          = D (N/8) / (N/8) + 1 + 1 + 1
          . . .
          = D (N/N) / (N/N) + 1 + 1 + ... + 1
          = lg N
```

Improvements:

* Use insertion sort for small subarrays.
* Is largest item in first half ≤ smallest item in second half?

## TimSort 

[原理介绍](https://blog.csdn.net/zhongyangzhong/article/details/8184707)

1. Natural mergesort.
2. Use insertion sort to make initial runs (if needed).

## QuickSort

Basic Plan:
1. shuffle the array
2. partition, for some j 
    - entry a[j] is in place
    - no larger entry to the left of j
    - no smaller entry to the right of j
3. sort each sunbarray recursively


Worst Case:
> If input is ordered, the # of compares = 1/2*N^2 => O(N^2)

|     |     |     |     |     | loop |
|-----|-----|-----|-----|-----|------|
| *2* | 3   | 4   | 5   | 6   | N    |
| 2   | *3* | 4   | 5   | 6   | N-1  |
| 2   | 3   | *4* | 5   | 6   | ...  |
| 2   | 3   | 4   | *5* | 6   | ...  |
| 2   | 3   | 4   | 5   | *6* | 1    |


Average Case:
> The # of compares = CN ~ 2(N + 1) lnN ≈ 1.39N*lgN => O(NlgN)

[1](https://imgur.com/wU5jrkh) <br>
[2](https://imgur.com/JlH2zCq)

Best Case:
> pivot happens to be the middle item in every subarrays => N*lgN => O(NlgN)
---
[Proof for Time Complexity](https://www.khanacademy.org/computing/computer-science/algorithms/quick-sort/a/analysis-of-quicksort)

Improvements:

* Use insertion sort for small subarrays.
* Median of sample. Best choice of pivot item = median.
```java
int median = medianOf3(a, lo, lo + (hi - lo)/2, hi);
swap(a, lo, median);
```
* 3-way QuickSort solves repeated items ( from O(1/2*N^2) to O(n) )


## QuickSelect
> Use quick sort to find top k item => N + N/2 + N/4 + ... + 1 => 2N compares