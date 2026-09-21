// Last updated: 9/21/2026, 1:18:35 PM
1import java.util.ArrayList;
2import java.util.List;
3
4class Solution {
5    public List<TreeNode> generateTrees(int n) {
6        if (n == 0) {
7            return new ArrayList<>();
8        }
9        return buildTrees(1, n);
10    }
11
12    private List<TreeNode> buildTrees(int start, int end) {
13        List<TreeNode> allTrees = new ArrayList<>();
14        if (start > end) {
15            allTrees.add(null);
16            return allTrees;
17        }
18
19        for (int i = start; i <= end; i++) {
20            List<TreeNode> leftSubtrees = buildTrees(start, i - 1);
21            List<TreeNode> rightSubtrees = buildTrees(i + 1, end);
22
23            for (TreeNode left : leftSubtrees) {
24                for (TreeNode right : rightSubtrees) {
25                    TreeNode root = new TreeNode(i);
26                    root.left = left;
27                    root.right = right;
28                    allTrees.add(root);
29                }
30            }
31        }
32
33        return allTrees;
34    }
35}