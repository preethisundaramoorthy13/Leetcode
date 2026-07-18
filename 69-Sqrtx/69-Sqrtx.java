// Last updated: 7/18/2026, 5:58:04 AM
class Solution {
    public int mySqrt(int x) {
        int low = 0;
        int high = x;
        int ans = 0;
        while(low<=high){
            int mid = low+(high-low)/2;
            long square = (long)mid*mid;
            if(square == x){
                return mid;
            }
            else if(square<x){
                ans = mid;
                low = mid+1;
            }
            else{
                high = mid-1;
            }
        }
        return ans;
    }
}