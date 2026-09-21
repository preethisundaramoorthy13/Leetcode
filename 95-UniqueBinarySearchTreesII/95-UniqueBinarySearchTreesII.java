// Last updated: 9/21/2026, 2:02:06 PM
1class Solution {
2    public Node connect(Node root) {
3        if (root == null) {
4            return null;
5        }
6
7        Node curr = root;
8
9        while (curr.left != null) {
10            Node head = curr;
11            while (head != null) {
12                head.left.next = head.right;
13                if (head.next != null) {
14                    head.right.next = head.next.left;
15                }
16                head = head.next;
17            }
18            curr = curr.left;
19        }
20
21        return root;
22    }
23}