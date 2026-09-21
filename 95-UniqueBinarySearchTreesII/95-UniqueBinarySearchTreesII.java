// Last updated: 9/21/2026, 1:20:42 PM
1class Solution {
2    private TreeNode first;
3    private TreeNode second;
4    private TreeNode prev;
5
6    public void recoverTree(TreeNode root) {
7        inorder(root);
8        int temp = first.val;
9        first.val = second.val;
10        second.val = temp;
11    }
12
13    private void inorder(TreeNode root) {
14        if (root == null) {
15            return;
16        }
17
18        inorder(root.left);
19
20        if (prev != null && prev.val > root.val) {
21            if (first == null) {
22                first = prev;
23            }
24            second = root;
25        }
26        prev = root;
27
28        inorder(root.right);
29    }
30}