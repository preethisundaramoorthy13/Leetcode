// Last updated: 9/22/2026, 9:32:45 AM
1import java.util.ArrayDeque;
2import java.util.Deque;
3
4/**
5 * Definition for a binary tree node.
6 * public class TreeNode {
7 *     int val;
8 *     TreeNode left;
9 *     TreeNode right;
10 *     TreeNode() {}
11 *     TreeNode(int val) { this.val = val; }
12 *     TreeNode(int val, TreeNode left, TreeNode right) {
13 *         this.val = val;
14 *         this.left = left;
15 *         this.right = right;
16 *     }
17 * }
18 */
19class BSTIterator {
20    private Deque<TreeNode> stack;
21
22    public BSTIterator(TreeNode root) {
23        stack = new ArrayDeque<>();
24        pushAllLeft(root);
25    }
26    
27    public int next() {
28        TreeNode currentNode = stack.pop();
29        pushAllLeft(currentNode.right);
30        return currentNode.val;
31    }
32    
33    public boolean hasNext() {
34        return !stack.isEmpty();
35    }
36
37    private void pushAllLeft(TreeNode node) {
38        while (node != null) {
39            stack.push(node);
40            node = node.left;
41        }
42    }
43}