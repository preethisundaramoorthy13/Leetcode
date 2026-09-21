// Last updated: 9/21/2026, 5:23:28 PM
1class Solution {
2    public int singleNumber(int[] nums) {
3        int ones = 0;
4        int twos = 0;
5
6        for (int num : nums) {
7            ones = (ones ^ num) & ~twos;
8            twos = (twos ^ num) & ~ones;
9        }
10
11        return ones;
12    }
13}