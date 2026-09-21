// Last updated: 9/21/2026, 5:40:23 PM
class Solution {
    private int in = 0;
    private int pre = 0;

    public TreeNode buildTree(int[] preorder, int[] inorder) {
        return build(preorder, inorder, Integer.MIN_VALUE);
    }

    private TreeNode build(int[] preorder, int[] inorder, int stop) {
        if (pre >= preorder.length) {
            return null;
        }
        if (inorder[in] == stop) {
            in++;
            return null;
        }

        TreeNode root = new TreeNode(preorder[pre++]);
        root.left = build(preorder, inorder, root.val);
        root.right = build(preorder, inorder, stop);

        return root;
    }
}