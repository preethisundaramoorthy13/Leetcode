# Last updated: 7/17/2026, 3:01:50 PM
class Solution(object):
    def maxSum(self, nums, k, mul):
        """
        :type nums: List[int]
        :type k: int
        :type mul: int
        :rtype: int
        """
        nums.sort(reverse = True)
        total_sum = 0
        for i in range(k):
            val = nums[i]
            if mul > 1:
                total_sum += val * mul
                mul -= 1
            else:
                total_sum += val
                mul -= 1
        return total_sum
        