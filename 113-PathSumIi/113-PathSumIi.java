// Last updated: 9/21/2026, 5:39:56 PM
import java.util.ArrayList;
import java.util.List;

class Solution {
    public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
        List<List<Integer>> result = new ArrayList<>();
        dfs(root, targetSum, new ArrayList<>(), result);
        return result;
    }

    private void dfs(TreeNode root, int target, List<Integer> current, List<List<Integer>> result) {
        if (root == null) {
            return;
        }

        current.add(root.val);

        if (root.left == null && root.right == null && target == root.val) {
            result.add(new ArrayList<>(current));
        } else {
            dfs(root.left, target - root.val, current, result);
            dfs(root.right, target - root.val, current, result);
        }

        current.remove(current.size() - 1);
    }
}