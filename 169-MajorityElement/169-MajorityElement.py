# Last updated: 7/17/2026, 3:04:50 PM
class Solution:
    def majorityElement(self, nums: List[int]) -> int:
        nums.sort()
        n = len(nums)
        return nums[n//2]