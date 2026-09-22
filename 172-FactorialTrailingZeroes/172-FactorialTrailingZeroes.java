// Last updated: 9/22/2026, 9:33:40 AM
1class Solution {
2    public int calculateMinimumHP(int[][] dungeon) {
3        int m = dungeon.length;
4        int n = dungeon[0].length;
5        
6        // dp[i][j] represents the minimum HP required when entering cell (i, j)
7        int[][] dp = new int[m + 1][n + 1];
8        
9        // Initialize table with infinity to handle boundary constraints
10        for (int i = 0; i <= m; i++) {
11            for (int j = 0; j <= n; j++) {
12                dp[i][j] = Integer.MAX_VALUE;
13            }
14        }
15        
16        // Base cases: neighboring boundaries of the destination cell require at least 1 HP
17        dp[m][n - 1] = 1;
18        dp[m - 1][n] = 1;
19        
20        // Bottom-up computation from bottom-right to top-left
21        for (int i = m - 1; i >= 0; i--) {
22            for (int j = n - 1; j >= 0; j--) {
23                int minHealthOnExit = Math.min(dp[i + 1][j], dp[i][j + 1]);
24                dp[i][j] = Math.max(1, minHealthOnExit - dungeon[i][j]);
25            }
26        }
27        
28        return dp[0][0];
29    }
30}