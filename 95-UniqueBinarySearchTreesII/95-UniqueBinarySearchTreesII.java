// Last updated: 9/21/2026, 1:25:47 PM
1class Solution {
2    private ListNode head;
3
4    public TreeNode sortedListToBST(ListNode head) {
5        this.head = head;
6        int length = getLength(head);
7        return buildTree(0, length - 1);
8    }
9
10    private int getLength(ListNode head) {
11        int len = 0;
12        while (head != null) {
13            len++;
14            head = head.next;
15        }
16        return len;
17    }
18
19    private TreeNode buildTree(int left, int right) {
20        if (left > right) {
21            return null;
22        }
23
24        int mid = left + (right - left) / 2;
25
26        TreeNode leftChild = buildTree(left, mid - 1);
27
28        TreeNode root = new TreeNode(head.val);
29        root.left = leftChild;
30
31        head = head.next;
32
33        root.right = buildTree(mid + 1, right);
34
35        return root;
36    }
37}