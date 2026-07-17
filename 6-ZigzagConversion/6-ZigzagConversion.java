// Last updated: 7/17/2026, 9:32:20 PM
1import java.util.Arrays;
2
3class Solution {
4    public int threeSumClosest(int[] nums, int target) {
5        // 1. Sort the array to use the two-pointer technique
6        Arrays.sort(nums);
7        
8        // Initialize closestSum with the sum of the first three elements
9        int closestSum = nums[0] + nums[1] + nums[2];
10        
11        // 2. Iterate through the array fixing the first element
12        for (int i = 0; i < nums.length - 2; i++) {
13            int left = i + 1;
14            int right = nums.length - 1;
15            
16            // 3. Use two pointers to find the closest sum for the remaining two elements
17            while (left < right) {
18                int currentSum = nums[i] + nums[left] + nums[right];
19                
20                // If we find an exact match, return it immediately
21                if (currentSum == target) {
22                    return currentSum;
23                }
24                
25                // Update closestSum if the current triplet is closer to the target
26                if (Math.abs(currentSum - target) < Math.abs(closestSum - target)) {
27                    closestSum = currentSum;
28                }
29                
30                // Move pointers based on how currentSum compares to target
31                if (currentSum < target) {
32                    left++; // Need a larger sum
33                } else {
34                    right--; // Need a smaller sum
35                }
36            }
37        }
38        
39        return closestSum;
40    }
41}