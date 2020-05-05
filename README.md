# Sorting Algorithms

|             | inplace? | stable? | best        | average  | worst   | remarks                                             |
|-------------|----------|---------|-------------|----------|---------|-----------------------------------------------------|
| selection   | Y        |         | ½ * N^2     | ½ * N^2  | ½ * N^2 | N exchanges                                         |
| insertion   | Y        | Y       | N           | ¼ N 2    | ½ N^2   | use for small N or partially ordered                |
| shell       | Y        |         | N logN/log3 | ?        | c N^3/2 | tight code; subquadratic                            |
| merge       |          | Y       | ½ N lg N    | N lg N   | N lg N  | N log N guarantee;      stable                      |
| timsort     |          | Y       | N           | N lg N   | N lg N  | improves mergesort when preexisting order           |
| quick       | Y        |         | N lg N      | 2 N ln N | ½ N 2   | N log N probabilistic guarantee;fastest in practice |
| 3-way quick | Y        |         | N           | 2 N ln N | ½ N 2   | improves quicksort when duplicate keys              |
| ?           | Y        | Y       | N           | N lg N   | N lg N  | holy sorting grail                                  |


# Sorting Attributes

* Deterministic? (same input has same efficiency)
> not for quicksort due to shuffling

* Large Items?
> selection sort has fewest exchanges

* Guaranteed Performance?
> quicksort's worst case: 1/2 * N^2, which is much slower than average case: N * lgN