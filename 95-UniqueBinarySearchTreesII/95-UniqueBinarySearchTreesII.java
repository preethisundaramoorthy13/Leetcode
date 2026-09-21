// Last updated: 9/21/2026, 1:26:35 PM
1class Solution {
2    public boolean isBalanced(TreeNode root) {
3        return checkHeight(root) != -1;
4    }
5
6    private int checkHeight(TreeNode root) {
7        if (root == null) {
8            return 0;
9        }
10
11        int leftHeight = checkHeight(root.left);
12        if (leftHeight == -1) {
13            return -1;
14        }
15
16        int rightHeight = checkHeight(root.right);
17        if (rightHeight == -1) {
18            return -1;
19        }
20
21        if (Math.abs(leftHeight - rightHeight) > 1) {
22            return -1;
23        }
24
25        return 1 + Math.max(leftHeight, rightHeight);
26    }
27}