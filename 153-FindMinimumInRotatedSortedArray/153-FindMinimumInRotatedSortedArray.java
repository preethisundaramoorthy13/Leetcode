// Last updated: 7/17/2026, 3:04:57 PM
class Solution {
    public int findMin(int[] nums) {

        int left = 0;
        int right = nums.length - 1;

        while (left < right) {

            int mid = left + (right - left) / 2;

            if (nums[mid] > nums[right]) {
                left = mid + 1; // minimum in right half
            } else {
                right = mid; // minimum in left half
            }
        }

        return nums[left];
    }
}