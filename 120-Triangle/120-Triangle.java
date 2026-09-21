// Last updated: 9/21/2026, 5:39:37 PM
class Solution {
    public int minimumTotal(List<List<Integer>> triangle) {
        int n = triangle.size();
        int[] dp = new int[n + 1];

        for (int row = n - 1; row >= 0; row--) {
            List<Integer> currRow = triangle.get(row);
            for (int i = 0; i < currRow.size(); i++) {
                dp[i] = currRow.get(i) + Math.min(dp[i], dp[i + 1]);
            }
        }

        return dp[0];
    }
}