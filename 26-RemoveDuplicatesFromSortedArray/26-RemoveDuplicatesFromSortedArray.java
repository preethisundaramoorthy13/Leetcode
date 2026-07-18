// Last updated: 7/18/2026, 9:01:30 PM
class Solution {
    public int removeDuplicates(int[] nums) {
        int prev=0;
        for(int i=1; i<nums.length; i++){
            if(nums[i]!=nums[prev]){
                nums[prev+1]=nums[i];
                prev++;
            }
        }

        return prev+1;
    }
}