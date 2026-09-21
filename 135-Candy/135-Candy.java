// Last updated: 9/21/2026, 5:24:21 PM
1class Solution {
2    public Node copyRandomList(Node head) {
3        if (head == null) {
4            return null;
5        }
6
7        Node curr = head;
8        while (curr != null) {
9            Node next = curr.next;
10            Node copy = new Node(curr.val);
11            curr.next = copy;
12            copy.next = next;
13            curr = next;
14        }
15
16        curr = head;
17        while (curr != null) {
18            if (curr.random != null) {
19                curr.next.random = curr.random.next;
20            }
21            curr = curr.next.next;
22        }
23
24        Node dummy = new Node(0);
25        Node copyCurr = dummy;
26        curr = head;
27
28        while (curr != null) {
29            Node next = curr.next.next;
30            Node copy = curr.next;
31            copyCurr.next = copy;
32            copyCurr = copy;
33            curr.next = next;
34            curr = next;
35        }
36
37        return dummy.next;
38    }
39}
40