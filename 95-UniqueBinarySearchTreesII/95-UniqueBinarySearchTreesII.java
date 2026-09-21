// Last updated: 9/21/2026, 1:30:39 PM
1class Solution {
2    public int minDepth(TreeNode root) {
3        if (root == null) {
4            return 0;
5        }
6        if (root.left == null) {
7            return minDepth(root.right) + 1;
8        }
9        if (root.right == null) {
10            return minDepth(root.left) + 1;
11        }
12        return Math.min(minDepth(root.left), minDepth(root.right)) + 1;
13    }
14}