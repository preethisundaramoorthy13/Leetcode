// Last updated: 9/21/2026, 3:09:11 PM
1class Solution {
2    public int minCut(String s) {
3        int n = s.length();
4        char[] c = s.toCharArray();
5        int[] cut = new int[n];
6        boolean[][] isPal = new boolean[n][n];
7
8        for (int i = 0; i < n; i++) {
9            int min = i;
10            for (int j = 0; j <= i; j++) {
11                if (c[j] == c[i] && (i - j <= 1 || isPal[j + 1][i - 1])) {
12                    isPal[j][i] = true;
13                    min = j == 0 ? 0 : Math.min(min, cut[j - 1] + 1);
14                }
15            }
16            cut[i] = min;
17        }
18
19        return cut[n - 1];
20    }
21}