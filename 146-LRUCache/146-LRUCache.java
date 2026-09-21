// Last updated: 9/21/2026, 5:55:33 PM
1class Solution {
2    public int maxProduct(int[] nums) {
3        int n = nums.length;
4        int max = nums[0];
5        int l = 0;
6        int r = 0;
7
8        for (int i = 0; i < n; i++) {
9            l = (l == 0 ? 1 : l) * nums[i];
10            r = (r == 0 ? 1 : r) * nums[n - 1 - i];
11            max = Math.max(max, Math.max(l, r));
12        }
13
14        return max;
15    }
16}