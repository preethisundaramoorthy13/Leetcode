# Last updated: 7/17/2026, 3:01:48 PM
class Solution(object):
    def maxDigitRange(self, nums):
        max_range = - 1
        ans = 0
        for num in nums:
            x = num
            mn = 9
            mx = 0
            if x == 0:
                mn = mx = 0
            else:
                while x > 0:
                    d = x%10
                    if d < mn:
                        mn = d
                    if d > mx:
                        mx = d
                    x //= 10
            r = mx - mn
            
            if r > max_range:
                max_range = r
                ans = num
            elif r == max_range:
                ans += num
        return ans
        