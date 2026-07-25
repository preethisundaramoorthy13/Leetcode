// Last updated: 7/25/2026, 2:07:20 PM
1class Solution {
2    public int maxSubArray(int[] nums) {
3        int maxSoFar = nums[0];
4        int currentMax = nums[0];
5
6        for (int i = 1; i < nums.length; i++) {
7            currentMax = Math.max(nums[i], currentMax + nums[i]);
8            maxSoFar = Math.max(maxSoFar, currentMax);
9        }
10
11        return maxSoFar;
12    }
13}