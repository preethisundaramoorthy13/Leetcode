// Last updated: 7/17/2026, 3:03:41 PM
class Solution {
    public boolean isPowerOfFour(int n) {
        if(n<1)return false;
        while(n%4==0)
        
            n/=4;
            if(n==1)
            return true;
            else
            return false;
        
    }
}