// Last updated: 9/21/2026, 1:22:11 PM
1class Solution {
2    private int in = 0;
3    private int pre = 0;
4
5    public TreeNode buildTree(int[] preorder, int[] inorder) {
6        return build(preorder, inorder, Integer.MIN_VALUE);
7    }
8
9    private TreeNode build(int[] preorder, int[] inorder, int stop) {
10        if (pre >= preorder.length) {
11            return null;
12        }
13        if (inorder[in] == stop) {
14            in++;
15            return null;
16        }
17
18        TreeNode root = new TreeNode(preorder[pre++]);
19        root.left = build(preorder, inorder, root.val);
20        root.right = build(preorder, inorder, stop);
21
22        return root;
23    }
24}