// Last updated: 9/21/2026, 5:40:04 PM
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    int min = 100001;
    public int minDepth(TreeNode root) {
        if(root==null)   return 0;
        dfs(root, 0);
        return min;
    }
    private void dfs(TreeNode root, int depth) {
        if(++depth>=min) return;
        if(root.left==null && root.right==null) {
            min = depth;
            return;
        }
        if(root.left!=null && (root.right==null||root.right.left!=null||root.right.right!=null))           dfs(root.left, depth);
        if(root.right!=null)    dfs(root.right, depth);
    }
}