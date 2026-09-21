// Last updated: 9/21/2026, 1:42:51 PM
1import java.util.ArrayList;
2import java.util.List;
3
4class Solution {
5    public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
6        List<List<Integer>> result = new ArrayList<>();
7        dfs(root, targetSum, new ArrayList<>(), result);
8        return result;
9    }
10
11    private void dfs(TreeNode root, int target, List<Integer> current, List<List<Integer>> result) {
12        if (root == null) {
13            return;
14        }
15
16        current.add(root.val);
17
18        if (root.left == null && root.right == null && target == root.val) {
19            result.add(new ArrayList<>(current));
20        } else {
21            dfs(root.left, target - root.val, current, result);
22            dfs(root.right, target - root.val, current, result);
23        }
24
25        current.remove(current.size() - 1);
26    }
27}