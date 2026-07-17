// Last updated: 7/17/2026, 3:02:19 PM
class Solution {
    public int[] runningSum(int[] nums) {
        int n = nums.length;
        for(int i = 1;i<n;i++){
            nums[i] = nums[i] + nums[i-1];
        }
        return nums;
    }
}