// Last updated: 7/26/2026, 10:08:07 AM
1class Solution {
2    public int largestInteger(int n, int s) {
3        if(s == 0) return 0;
4        if(s > 9*n)return -1;
5        StringBuilder ans = new StringBuilder();
6        for(int i = 0;i < n;i++){
7            int d = Math.min(9,s);
8            ans.append(d);
9            s -= d;
10        }
11        return Integer.parseInt(ans.toString());
12    }
13}