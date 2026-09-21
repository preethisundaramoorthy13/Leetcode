// Last updated: 9/21/2026, 3:07:53 PM
1import java.util.ArrayList;
2import java.util.List;
3
4class Solution {
5    public List<List<String>> partition(String s) {
6        int n = s.length();
7        boolean[][] dp = new boolean[n][n];
8        for (int i = 0; i < n; i++) {
9            for (int j = 0; j <= i; j++) {
10                if (s.charAt(j) == s.charAt(i) && (i - j <= 2 || dp[j + 1][i - 1])) {
11                    dp[j][i] = true;
12                }
13            }
14        }
15
16        List<List<String>> result = new ArrayList<>();
17        backtrack(s, 0, dp, new ArrayList<>(), result);
18        return result;
19    }
20
21    private void backtrack(String s, int start, boolean[][] dp, List<String> current, List<List<String>> result) {
22        if (start == s.length()) {
23            result.add(new ArrayList<>(current));
24            return;
25        }
26
27        for (int end = start; end < s.length(); end++) {
28            if (dp[start][end]) {
29                current.add(s.substring(start, end + 1));
30                backtrack(s, end + 1, dp, current, result);
31                current.remove(current.size() - 1);
32            }
33        }
34    }
35}