### Compare-based lower bound for sorting

> Any compare-based sorting algorithm must use at least lg(N!)  ~  N*lgN  compares in the worst-case.

```java
2^h ≥ # leaves ≥ N!
=> h ≥ lg(N!)
=> h ≥ N*lgN
```

## CoutingSort

## LSD Sorting

9 1 1 <br> 
4 2 5 <br> 
3 6 7 <br>
3 6 9 <br>

W=3, N=4, R=9
> 2W*(N + R), Better if R is small

> Extra Space: N + R

## MDS Sorting

> 2W*(N + R), but N*lgN/lgR if random

> Extra Space: N + D*R (D for length of the longest prefix match)

Potential Disasters:
* much slow for small subarrays ( N << R, maintaing count[] cost too much )
* may has huge number of small subarrays ( recursion )