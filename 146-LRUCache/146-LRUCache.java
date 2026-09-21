// Last updated: 9/21/2026, 5:44:08 PM
1class Solution {
2    public ListNode insertionSortList(ListNode head) {
3        if (head == null || head.next == null) {
4            return head;
5        }
6
7        ListNode dummy = new ListNode(0);
8        ListNode curr = head;
9        ListNode prev = dummy;
10        ListNode next = null;
11
12        while (curr != null) {
13            next = curr.next;
14
15            if (prev.next != null && prev.next.val > curr.val) {
16                prev = dummy;
17            }
18
19            while (prev.next != null && prev.next.val < curr.val) {
20                prev = prev.next;
21            }
22
23            curr.next = prev.next;
24            prev.next = curr;
25            curr = next;
26        }
27
28        return dummy.next;
29    }
30}