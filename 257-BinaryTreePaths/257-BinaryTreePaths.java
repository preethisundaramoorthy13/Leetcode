// Last updated: 7/17/2026, 3:04:00 PM
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
    public List<String> binaryTreePaths(TreeNode root) {
        List<String> result = new ArrayList<>();
        List<Integer> path = new ArrayList<>();
        dfs(root, result, path);
        return result;
    }
    private void dfs(TreeNode root, List<String> result, List<Integer> path){
        if (root == null){
            return;
        }

        path.add(root.val);

        if (root.left == null && root.right == null){
            StringBuilder sb = new StringBuilder();

            for (int i = 0; i < path.size(); i++) {
                sb.append(path.get(i));
                if (i != path.size() - 1)
                    sb.append("->");
            }

            result.add(sb.toString());        
        }

        dfs(root.left, result, path);
        dfs(root.right, result, path);

        path.remove(path.size() - 1);
    }
}