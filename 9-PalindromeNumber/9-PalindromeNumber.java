// Last updated: 7/18/2026, 9:01:55 PM
class Solution {
    public boolean isPalindrome(int x) {
        int original = x;
        int rev = 0;
        while(x>0){
            int d  = x%10;
            rev = rev*10 + d;
            x=x/10; 
        }
        return original == rev;
    }
}