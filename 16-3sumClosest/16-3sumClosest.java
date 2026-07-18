// Last updated: 7/18/2026, 9:01:45 PM
import java.util.Arrays;

class Solution {
    public int threeSumClosest(int[] nums, int target) {
        // 1. Sort the array to use the two-pointer technique
        Arrays.sort(nums);
        
        // Initialize closestSum with the sum of the first three elements
        int closestSum = nums[0] + nums[1] + nums[2];
        
        // 2. Iterate through the array fixing the first element
        for (int i = 0; i < nums.length - 2; i++) {
            int left = i + 1;
            int right = nums.length - 1;
            
            // 3. Use two pointers to find the closest sum for the remaining two elements
            while (left < right) {
                int currentSum = nums[i] + nums[left] + nums[right];
                
                // If we find an exact match, return it immediately
                if (currentSum == target) {
                    return currentSum;
                }
                
                // Update closestSum if the current triplet is closer to the target
                if (Math.abs(currentSum - target) < Math.abs(closestSum - target)) {
                    closestSum = currentSum;
                }
                
                // Move pointers based on how currentSum compares to target
                if (currentSum < target) {
                    left++; // Need a larger sum
                } else {
                    right--; // Need a smaller sum
                }
            }
        }
        
        return closestSum;
    }
}