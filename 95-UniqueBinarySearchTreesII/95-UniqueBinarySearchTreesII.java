// Last updated: 9/21/2026, 1:23:46 PM
1class Solution {
2    private int post;
3    private int in;
4
5    public TreeNode buildTree(int[] inorder, int[] postorder) {
6        post = postorder.length - 1;
7        in = inorder.length - 1;
8        return build(inorder, postorder, Integer.MIN_VALUE);
9    }
10
11    private TreeNode build(int[] inorder, int[] postorder, int stop) {
12        if (post < 0) {
13            return null;
14        }
15        if (inorder[in] == stop) {
16            in--;
17            return null;
18        }
19
20        TreeNode root = new TreeNode(postorder[post--]);
21        root.right = build(inorder, postorder, root.val);
22        root.left = build(inorder, postorder, stop);
23
24        return root;
25    }
26}