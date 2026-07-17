// Last updated: 7/17/2026, 3:02:36 PM
class Solution {
    public int tribonacci(int n) { 
        int a=0,b=1,c=1;
        int temp;
        if(n==0) return 0;
        if(n==1||n==2) return 1;
        for(int i=3;i<=n;i++){
            temp= a+b+c;
            a=b;
            b=c;
            c=temp;
        }
        return c;
    }
}