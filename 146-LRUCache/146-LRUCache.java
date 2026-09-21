// Last updated: 9/21/2026, 5:44:46 PM
1class Solution {
2    public ListNode sortList(ListNode head) {
3        if (head == null || head.next == null) {
4            return head;
5        }
6
7        ListNode prev = null;
8        ListNode slow = head;
9        ListNode fast = head;
10
11        while (fast != null && fast.next != null) {
12            prev = slow;
13            slow = slow.next;
14            fast = fast.next.next;
15        }
16
17        prev.next = null;
18
19        ListNode l1 = sortList(head);
20        ListNode l2 = sortList(slow);
21
22        return merge(l1, l2);
23    }
24
25    private ListNode merge(ListNode l1, ListNode l2) {
26        ListNode dummy = new ListNode(0);
27        ListNode curr = dummy;
28
29        while (l1 != null && l2 != null) {
30            if (l1.val < l2.val) {
31                curr.next = l1;
32                l1 = l1.next;
33            } else {
34                curr.next = l2;
35                l2 = l2.next;
36            }
37            curr = curr.next;
38        }
39
40        if (l1 != null) {
41            curr.next = l1;
42        }
43        if (l2 != null) {
44            curr.next = l2;
45        }
46
47        return dummy.next;
48    }
49}