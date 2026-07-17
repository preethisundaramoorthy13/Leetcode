// Last updated: 7/17/2026, 3:03:56 PM
class Solution {
    public int missingNumber(int[] nums) {
        int n= nums.length;
        int expected=n*(n+1)/2;
        int actual = 0;
        for(int x:nums){
            actual+=x;
        }
        return expected - actual;
    }
}