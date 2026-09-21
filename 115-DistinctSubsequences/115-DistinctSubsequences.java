// Last updated: 9/21/2026, 5:39:51 PM
class Solution {
    public int numDistinct(String s, String t) {
        int m = s.length();
        int n = t.length();
        if (m < n) {
            return 0;
        }

        char[] sChars = s.toCharArray();
        char[] tChars = t.toCharArray();

        int[] dp = new int[n + 1];
        dp[0] = 1;

        for (int i = 0; i < m; i++) {
            int maxJ = Math.min(i, n - 1);
            int minJ = Math.max(0, n - m + i);
            for (int j = maxJ; j >= minJ; j--) {
                if (sChars[i] == tChars[j]) {
                    dp[j + 1] += dp[j];
                }
            }
        }

        return dp[n];
    }
}