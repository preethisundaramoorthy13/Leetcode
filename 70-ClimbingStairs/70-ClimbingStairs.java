// Last updated: 7/18/2026, 5:58:02 AM
class Solution {
    public int climbStairs(int n) {
        int a=0;
        int b=1;
        int c=2;
        if(n<=3) return n;
        for(int i=3;i<=n;i++){
            a=b+c;
            b=c;
            c=a;
        }
        return a;
    }
}