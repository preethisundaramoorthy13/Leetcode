// Last updated: 7/17/2026, 3:05:08 PM
class Solution {
    public int singleNumber(int[] nums) {
        int result=0;
        for(int x:nums){
            result^=x;
        }
        return result;
    }
}