// Last updated: 9/21/2026, 2:36:55 PM
1class Solution {
2    public int minimumTotal(List<List<Integer>> triangle) {
3        int n = triangle.size();
4        int[] dp = new int[n + 1];
5
6        for (int row = n - 1; row >= 0; row--) {
7            List<Integer> currRow = triangle.get(row);
8            for (int i = 0; i < currRow.size(); i++) {
9                dp[i] = currRow.get(i) + Math.min(dp[i], dp[i + 1]);
10            }
11        }
12
13        return dp[0];
14    }
15}