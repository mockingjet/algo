# L1

| algorithm   | initialize | union  | find | connected |
|-------------|------------|--------|------|-----------|
| quick-find  | N          | N      | 1    | 1         |
| quick-union | N          | N †    | N    | N         |
| weighted QU | N          | lg N † | lg N | lg N      |
> † includes cost of finding roots


| algorithm                      | worst-case time |
|--------------------------------|-----------------|
| quick-find                     | N*M             |
| quick-union                    | N*M             |
| weighted QU                    | N + M log N     |
| QU + path compression          | N + M log N     |
| weighted QU + path compression | N + M lg* N     |
> N for length; M for union times

| N      | lg* N |
|--------|-------|
| 1      | 0     |
| 2      | 1     |
| 4      | 2     |
| 16     | 3     |
| 65536  | 4     |
| 265536 | 5     |

# L2

Upper bound. A specific algorithm.
* Brute-force algorithm for 1-SUM: Look at every array entry.

Running time of the algorithm for 1-SUM is O(N).
Lower bound. Proof that no algorithm can do better.(Lower Bound for Worst Case)
* Have to examine all N entries (any unexamined one might be 0).
Running time of an optimal algorithm for 1-SUM is Ω(N).
Optimal algorithm.

Lower bound equals upper bound (to within a constant factor).
* Brute-force algorithm for 1-SUM is optimal: its running time is
Θ(N). 60

## approximate models: Tilde-notation