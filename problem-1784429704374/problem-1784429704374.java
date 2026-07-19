// Last updated: 7/18/2026, 9:55:04 PM
1/**
2 * Definition for a binary tree node.
3 * public class TreeNode {
4 *     int val;
5 *     TreeNode left;
6 *     TreeNode right;
7 *     TreeNode() {}
8 *     TreeNode(int val) { this.val = val; }
9 *     TreeNode(int val, TreeNode left, TreeNode right) {
10 *         this.val = val;
11 *         this.left = left;
12 *         this.right = right;
13 *     }
14 * }
15 */
16class Solution {
17    int count = 0;
18    public int countDominantNodes(TreeNode root) {
19        dfs(root);
20        return count;
21    }
22    private int dfs(TreeNode node){
23        if(node == null)
24            return Integer.MIN_VALUE;
25        int leftMax = dfs(node.left);
26        int rightMax = dfs(node.right);
27        int subtreeMax = Math.max(node.val, Math.max(leftMax, rightMax));
28        if(node.val == subtreeMax)
29            count++;
30        return subtreeMax;
31    }
32}