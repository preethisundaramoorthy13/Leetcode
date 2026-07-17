// Last updated: 7/17/2026, 9:53:12 PM
1/**
2 * Definition for singly-linked list.
3 * public class ListNode {
4 *     int val;
5 *     ListNode next;
6 *     ListNode() {}
7 *     ListNode(int val) { this.val = val; }
8 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
9 * }
10 */
11class Solution {
12    public ListNode removeNthFromEnd(ListNode head, int n) {
13        // Create a dummy node to seamlessly handle edge cases (like removing the head node)
14        ListNode dummy = new ListNode(0);
15        dummy.next = head;
16        
17        ListNode fast = dummy;
18        ListNode slow = dummy;
19        
20        // 1. Move the fast pointer so that there is a gap of n nodes between fast and slow
21        for (int i = 0; i <= n; i++) {
22            fast = fast.next;
23        }
24        
25        // 2. Move fast to the end, maintaining the constant gap
26        while (fast != null) {
27            fast = fast.next;
28            slow = slow.next;
29        }
30        
31        // 3. slow is now right before the node to be deleted. Skip the target node.
32        slow.next = slow.next.next;
33        
34        return dummy.next;
35    }
36}