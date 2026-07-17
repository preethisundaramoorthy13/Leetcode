# Last updated: 7/17/2026, 3:01:49 PM
class Solution(object):
    def minimumCost(self, nums, k):
        MOD = 10 ** 9 + 7
        total_cost = 0
        operations_count = 0
        current_resources = k
        for num in nums:
            if current_resources < num:
                needed = num - current_resources
                ops_needed = (needed + k -1) // k
                first_op = operations_count + 1
                last_op = operations_count + ops_needed
                cost_added = (ops_needed * (first_op + last_op)) // 2
                total_cost = (total_cost + cost_added) % MOD
                operations_count += ops_needed
                current_resources += ops_needed * k
            current_resources -= num
        return total_cost
        