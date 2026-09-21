// Last updated: 9/21/2026, 6:00:19 PM
1class Solution {
2    public int[] twoSum(int[] numbers, int target) {
3        int left = 0;
4        int right = numbers.length - 1;
5
6        while (left < right) {
7            int sum = numbers[left] + numbers[right];
8            if (sum == target) {
9                return new int[]{left + 1, right + 1};
10            } else if (sum < target) {
11                left++;
12            } else {
13                right--;
14            }
15        }
16
17        return new int[]{-1, -1};
18    }
19}