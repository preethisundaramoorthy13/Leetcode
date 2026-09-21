// Last updated: 9/21/2026, 3:05:38 PM
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
    public int traverse(TreeNode root, int sum) {
        if(root == null)
            return sum;
        sum = sum * 10 + root.val;
        if(root.left == null && root.right == null) 
            return sum;
        if(root.left != null && root.right != null)
            return traverse(root.right, sum) + traverse(root.left, sum);
        else if(root.left != null)
            return traverse(root.left, sum);
        else
            return traverse(root.right, sum);
    }
    public int sumNumbers(TreeNode root) {
        return traverse(root, 0);
    }
}