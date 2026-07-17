// Last updated: 7/17/2026, 3:02:07 PM
class Solution {
    public int passThePillow(int n, int time) {
        int cycle = 2*(n-1);
        int remainingTime = time%cycle;
        if(remainingTime<= n-1){
            return 1+remainingTime;
        }
        else{
            return n-(remainingTime-(n-1));
        }
    }
}