// Last updated: 7/17/2026, 3:02:09 PM
class Solution {
    public int numberOfCuts(int n) {
        if(n==1) return 0;
        if(n%2==0){
            return n/2;
        }
        else{
            return n;
        }
    }
}