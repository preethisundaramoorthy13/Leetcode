// Last updated: 9/21/2026, 5:41:44 PM
class Solution {
    private TreeNode first;
    private TreeNode second;
    private TreeNode prev;

    public void recoverTree(TreeNode root) {
        inorder(root);
        int temp = first.val;
        first.val = second.val;
        second.val = temp;
    }

    private void inorder(TreeNode root) {
        if (root == null) {
            return;
        }

        inorder(root.left);

        if (prev != null && prev.val > root.val) {
            if (first == null) {
                first = prev;
            }
            second = root;
        }
        prev = root;

        inorder(root.right);
    }
}