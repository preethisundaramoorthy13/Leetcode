// Last updated: 7/17/2026, 9:11:43 PM
1class Solution {
2    public boolean isMatch(String s, String p) {
3        int m = s.length();
4        int n = p.length();
5        
6        // dp[i][j] represents if s[0..i-1] matches p[0..j-1]
7        boolean[][] dp = new boolean[m + 1][n + 1];
8        
9        // Base case: empty string matches empty pattern
10        dp[0][0] = true;
11        
12        // Deal with patterns that can match an empty string (e.g., a*, a*b*, .*)
13        for (int j = 2; j <= n; j++) {
14            if (p.charAt(j - 1) == '*') {
15                dp[0][j] = dp[0][j - 2];
16            }
17        }
18        
19        // Fill the DP table
20        for (int i = 1; i <= m; i++) {
21            for (int j = 1; j <= n; j++) {
22                char sc = s.charAt(i - 1);
23                char pc = p.charAt(j - 1);
24                
25                if (pc == '.' || pc == sc) {
26                    dp[i][j] = dp[i - 1][j - 1];
27                } else if (pc == '*') {
28                    // Case 1: Match 0 times (ignore the character and the '*')
29                    dp[i][j] = dp[i][j - 2];
30                    
31                    // Case 2: Match 1 or more times (if preceding character matches)
32                    char prevPc = p.charAt(j - 2);
33                    if (prevPc == '.' || prevPc == sc) {
34                        dp[i][j] = dp[i][j] || dp[i - 1][j];
35                    }
36                }
37            }
38        }
39        
40        return dp[m][n];
41    }
42}