// Last updated: 9/21/2026, 5:40:20 PM
class Solution {
    private int post;
    private int in;

    public TreeNode buildTree(int[] inorder, int[] postorder) {
        post = postorder.length - 1;
        in = inorder.length - 1;
        return build(inorder, postorder, Integer.MIN_VALUE);
    }

    private TreeNode build(int[] inorder, int[] postorder, int stop) {
        if (post < 0) {
            return null;
        }
        if (inorder[in] == stop) {
            in--;
            return null;
        }

        TreeNode root = new TreeNode(postorder[post--]);
        root.right = build(inorder, postorder, root.val);
        root.left = build(inorder, postorder, stop);

        return root;
    }
}