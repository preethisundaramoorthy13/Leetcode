# Last updated: 7/17/2026, 3:05:18 PM
# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
    def sortedArrayToBST(self, nums: List[int]) -> Optional[TreeNode]:
        def converter(esquerda, direita):
            if esquerda > direita:
                return None
            
            mid = (esquerda + direita) // 2
            node = TreeNode(nums[mid])

            node.left = converter(esquerda, mid - 1)
            node.right = converter(mid + 1, direita)

            return node

        return converter(0, len(nums) - 1)