# Report for rapid shrinking on "large_union_list"

This report was generated with rapid v0.4.7.

## Normalization

rapid produced 12 distinct results in 100 test runs.

The most common were:

- ``[][]int{[]int{0, 1, 2, 3, 4}}`` (63.00%)
- ``[][]int{[]int{0, 1, 2, 3, -1}}`` (17.00%)
- ``[][]int{[]int{0}, []int{1, 2, 3, 4}}`` (5.00%)
- ``[][]int{[]int{0, 1, 2}, []int{3, -1}}`` (4.00%)
- ``[][]int{[]int{0, 1}, []int{2, 3, 4}}`` (3.00%)
- ``[][]int{[]int{0, 1, 2}, []int{3, 4}}`` (2.00%)
- ``[][]int{[]int{0, 1, 2, 3}, []int{-1}}`` (1.00%)
- ``[][]int{[]int{0, 1, 2, -1, -2}}`` (1.00%)
- ``[][]int{[]int{0, 1}, []int{2, 3, -1}}`` (1.00%)
- ``[][]int{[]int{0}, []int{1, 2}, []int{3, 4}}`` (1.00%)

