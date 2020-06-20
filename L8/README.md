## HeapSort

> Based on priority queue

1. swim-based => NlogN + NlogN
2. sink-based => N + NlogN

proof.
N = 2^(h+1) - 1

case1: from root sink to leaf => h
case2: two children of root sink to leaf => 2(h-1)
case3: four children of two children of root sink to leaf => 4(h-1)
...
=> h + 2(h-1) + 4(h-2) + ... + 2^h(0) = 2^(h+1) - h - 2 
= N - (h-1) <= N