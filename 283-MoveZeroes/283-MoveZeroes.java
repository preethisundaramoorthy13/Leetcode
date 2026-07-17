// Last updated: 7/17/2026, 3:03:51 PM
class Solution {
    public void moveZeroes(int[] nums) {
        int sum=0;
        for(int i=0;i<nums.length;i++){
            if(nums[i]!=0){
                nums[sum]=nums[i];
                sum++;
            }
        }
        while(sum<nums.length){
            nums[sum] = 0;
            sum++;
       }
    }
}