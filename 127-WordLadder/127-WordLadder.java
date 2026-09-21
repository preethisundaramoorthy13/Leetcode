// Last updated: 9/21/2026, 3:04:33 PM
1class Solution {
2    public int sumNumbers(TreeNode root) {
3        return dfs(root, 0);
4    }
5
6    private int dfs(TreeNode node, int currentSum) {
7        if (node == null) {
8            return 0;
9        }
10
11        currentSum = currentSum * 10 + node.val;
12
13        if (node.left == null && node.right == null) {
14            return currentSum;
15        }
16
17        return dfs(node.left, currentSum) + dfs(node.right, currentSum);
18    }
19}