// Last updated: 8/30/2026, 3:23:36 PM
1class Solution {
2    public ListNode deleteDuplicates(ListNode head) {
3        ListNode dummy = new ListNode(0, head);
4        ListNode prev = dummy;
5
6        while (head != null) {
7            if (head.next != null && head.val == head.next.val) {
8                while (head.next != null && head.val == head.next.val) {
9                    head = head.next;
10                }
11                prev.next = head.next;
12            } else {
13                prev = prev.next;
14            }
15            head = head.next;
16        }
17
18        return dummy.next;
19    }
20}