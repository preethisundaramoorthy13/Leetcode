// Last updated: 7/17/2026, 3:05:17 PM
class Solution {

    private TreeNode prev = null;

    public void flatten(TreeNode root) {
        dfs(root);
    }

    private void dfs(TreeNode node) {

        if (node == null) return;

        dfs(node.right);
        dfs(node.left);

        node.right = prev;
        node.left = null;

        prev = node;
    }
}