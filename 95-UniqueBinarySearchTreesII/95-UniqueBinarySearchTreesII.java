// Last updated: 9/21/2026, 2:01:10 PM
1class Solution {
2    public int numDistinct(String s, String t) {
3        int m = s.length();
4        int n = t.length();
5        if (m < n) {
6            return 0;
7        }
8
9        char[] sChars = s.toCharArray();
10        char[] tChars = t.toCharArray();
11
12        int[] dp = new int[n + 1];
13        dp[0] = 1;
14
15        for (int i = 0; i < m; i++) {
16            int maxJ = Math.min(i, n - 1);
17            int minJ = Math.max(0, n - m + i);
18            for (int j = maxJ; j >= minJ; j--) {
19                if (sChars[i] == tChars[j]) {
20                    dp[j + 1] += dp[j];
21                }
22            }
23        }
24
25        return dp[n];
26    }
27}