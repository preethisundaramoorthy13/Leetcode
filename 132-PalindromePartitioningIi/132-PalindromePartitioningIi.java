// Last updated: 9/21/2026, 5:39:09 PM
class Solution {
    public int minCut(String s) {
        int n = s.length();
        char[] c = s.toCharArray();
        int[] cut = new int[n];
        boolean[][] isPal = new boolean[n][n];

        for (int i = 0; i < n; i++) {
            int min = i;
            for (int j = 0; j <= i; j++) {
                if (c[j] == c[i] && (i - j <= 1 || isPal[j + 1][i - 1])) {
                    isPal[j][i] = true;
                    min = j == 0 ? 0 : Math.min(min, cut[j - 1] + 1);
                }
            }
            cut[i] = min;
        }

        return cut[n - 1];
    }
}