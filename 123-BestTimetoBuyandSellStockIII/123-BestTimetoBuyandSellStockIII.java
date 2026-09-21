// Last updated: 9/21/2026, 2:45:13 PM
1class Solution {
2    private int maxSum = Integer.MIN_VALUE;
3
4    public int maxPathSum(TreeNode root) {
5        maxGain(root);
6        return maxSum;
7    }
8
9    private int maxGain(TreeNode node) {
10        if (node == null) {
11            return 0;
12        }
13
14        int leftGain = Math.max(maxGain(node.left), 0);
15        int rightGain = Math.max(maxGain(node.right), 0);
16
17        int currentPathSum = node.val + leftGain + rightGain;
18        maxSum = Math.max(maxSum, currentPathSum);
19
20        return node.val + Math.max(leftGain, rightGain);
21    }
22}