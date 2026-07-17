# Last updated: 7/17/2026, 3:01:54 PM
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
        