// Last updated: 9/21/2026, 5:56:22 PM
1class Solution {
2    public int findMin(int[] nums) {
3        int low = 0;
4        int high = nums.length - 1;
5
6        while (low < high) {
7            int mid = low + (high - low) / 2;
8
9            if (nums[mid] < nums[high]) {
10                high = mid;
11            } else if (nums[mid] > nums[high]) {
12                low = mid + 1;
13            } else {
14                high--;
15            }
16        }
17
18        return nums[low];
19    }
20}