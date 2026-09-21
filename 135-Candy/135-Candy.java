// Last updated: 9/21/2026, 5:27:40 PM
1public class Solution {
2    public ListNode detectCycle(ListNode head) {
3        if (head == null || head.next == null) {
4            return null;
5        }
6
7        ListNode slow = head;
8        ListNode fast = head;
9
10        while (fast != null && fast.next != null) {
11            slow = slow.next;
12            fast = fast.next.next;
13
14            if (slow == fast) {
15                ListNode entry = head;
16                while (entry != slow) {
17                    entry = entry.next;
18                    slow = slow.next;
19                }
20                return entry;
21            }
22        }
23
24        return null;
25    }
26}