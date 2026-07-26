// Last updated: 7/26/2026, 1:14:13 PM
1import java.util.Arrays;
2
3class Solution {
4    public int maximumProduct(int[] nums) {
5        Arrays.sort(nums);
6        int n = nums.length;
7        return Math.max(
8            nums[n - 1] * nums[n - 2] * nums[n - 3], 
9            nums[0] * nums[1] * nums[n - 1]
10        );
11    }
12}