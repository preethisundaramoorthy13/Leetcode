// Last updated: 9/21/2026, 2:36:05 PM
1class Solution {
2    public Node connect(Node root) {
3        Node head = root;
4        while (head != null) {
5            Node dummy = new Node(0);
6            Node temp = dummy;
7            while (head != null) {
8                if (head.left != null) {
9                    temp.next = head.left;
10                    temp = temp.next;
11                }
12                if (head.right != null) {
13                    temp.next = head.right;
14                    temp = temp.next;
15                }
16                head = head.next;
17            }
18            head = dummy.next;
19        }
20        return root;
21    }
22}