# Last updated: 9/21/2026, 5:30:58 PM
class Solution(object):
    def maxConsistentColumns(self, grid, limit):
        m = len(grid)
        n = len(grid[0])
        dp = [1] * n
        for j in range(1,n):
            for i in range(j):
                for r in range(m):
                    if abs(grid[r][j] - grid[r][i]) > limit:
                        break
                else:
                    if dp[i] + 1 > dp[j]:
                        dp[j] = dp[i] + 1 
        return max(dp)
        