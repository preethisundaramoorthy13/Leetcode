// Last updated: 7/18/2026, 2:02:26 AM
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
12    public ListNode swapPairs(ListNode head) {
13        // Create a dummy node to point to the head of the list
14        ListNode dummy = new ListNode(0);
15        dummy.next = head;
16        
17        // This pointer tracks the node right before the pair we are swapping
18        ListNode prev = dummy;
19        
20        // Make sure there are at least two nodes left to swap
21        while (prev.next != null && prev.next.next != null) {
22            ListNode first = prev.next;
23            ListNode second = prev.next.next;
24            
25            // Adjusting pointers to swap the pair
26            first.next = second.next;
27            second.next = first;
28            prev.next = second;
29            
30            // Move the prev pointer two steps ahead for the next pair
31            prev = first;
32        }
33        
34        return dummy.next;
35    }
36}