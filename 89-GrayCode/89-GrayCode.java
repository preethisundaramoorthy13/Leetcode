// Last updated: 9/1/2026, 9:22:13 AM
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
12    public ListNode reverseBetween(ListNode head, int left, int right) {
13        if (head == null || left == right) {
14            return head;
15        }
16
17        ListNode dummy = new ListNode(0);
18        dummy.next = head;
19        ListNode prev = dummy;
20
21        // Traverse to the node immediately before the 'left' index
22        for (int i = 0; i < left - 1; i++) {
23            prev = prev.next;
24        }
25
26        ListNode start = prev.next; // First node of the sub-list to be reversed
27        ListNode then = start.next; // Node to be moved to the front of the sub-list
28
29        // Move 'then' nodes sequentially to the front of the sub-list
30        for (int i = 0; i < right - left; i++) {
31            start.next = then.next;
32            then.next = prev.next;
33            prev.next = then;
34            then = start.next;
35        }
36
37        return dummy.next;
38    }
39}