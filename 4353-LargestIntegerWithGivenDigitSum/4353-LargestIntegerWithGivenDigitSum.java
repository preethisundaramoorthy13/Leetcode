// Last updated: 7/31/2026, 9:35:36 AM
class Solution {
    public int largestInteger(int n, int s) {
        if(s == 0) return 0;
        if(s > 9*n)return -1;
        StringBuilder ans = new StringBuilder();
        for(int i = 0;i < n;i++){
            int d = Math.min(9,s);
            ans.append(d);
            s -= d;
        }
        return Integer.parseInt(ans.toString());
    }
}