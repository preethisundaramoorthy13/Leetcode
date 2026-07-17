// Last updated: 7/17/2026, 3:02:15 PM
class Solution {
    public int[] getConcatenation(int[] nums) {
        int len=nums.length;
        int[] ans=new int[2*len];
        for(int i =0;i<len;i++){
            ans[i] = nums[i];
            ans[i+len] = nums[i];
        }
        return ans;
    }
}