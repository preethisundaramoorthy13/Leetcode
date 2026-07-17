# Last updated: 7/17/2026, 3:01:55 PM
class Solution(object):
    def maxSubarraySum(self, nums, k):
        def solve(transform_func):
            dp1 = float('-inf')
            dp2 = float('-inf')
            dp3 = float('-inf')
            max_sum = float('-inf')
            for x in nums:
                fx = transform_func(x)
                dp3 = max(dp2, dp3) + x if max(dp2, dp3) != float('-inf') else x
                dp2 = max(0, dp1, dp2) + fx
                dp1 = max(0, dp1) + x
                max_sum = max(max_sum, dp1, dp2, dp3)
            return max_sum
        f_mult = lambda x : x * k
        f_div = lambda x : int(float(x) / k)
        return max(solve(f_mult), solve(f_div))
        