// Last updated: 7/17/2026, 3:02:50 PM
class Solution {
    public int fib(int n) {
        int temp=1;
        int a=1;
        int b=1;
        if(n==1) return 1;
        if(n==0) return 0;
        for(int i = 0;i<n-2;i++){
            temp = a+b;
            a=b;
            b=temp;
        }
        return temp;
    }
}