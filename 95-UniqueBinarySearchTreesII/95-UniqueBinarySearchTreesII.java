// Last updated: 9/21/2026, 1:20:02 PM
1class Solution {
2    public boolean isInterleave(String s1, String s2, String s3) {
3        if (s1.length() + s2.length() != s3.length()) {
4            return false;
5        }
6        return dfs(s1.toCharArray(), s2.toCharArray(), s3.toCharArray(), 0, 0, 0, new boolean[s1.length() + 1][s2.length() + 1]);
7    }
8
9    private boolean dfs(char[] c1, char[] c2, char[] c3, int i, int j, int k, boolean[][] invalid) {
10        if (invalid[i][j]) {
11            return false;
12        }
13        if (k == c3.length) {
14            return true;
15        }
16
17        boolean valid = (i < c1.length && c1[i] == c3[k] && dfs(c1, c2, c3, i + 1, j, k + 1, invalid)) ||
18                        (j < c2.length && c2[j] == c3[k] && dfs(c1, c2, c3, i, j + 1, k + 1, invalid));
19
20        if (!valid) {
21            invalid[i][j] = true;
22        }
23
24        return valid;
25    }
26}