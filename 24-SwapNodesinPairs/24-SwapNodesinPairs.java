// Last updated: 7/18/2026, 2:04:40 AM
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
12    public ListNode reverseKGroup(ListNode head, int k) {
13        if (head == null || k == 1) return head;
14        
15        ListNode dummy = new ListNode(0);
16        dummy.next = head;
17        
18        ListNode prevGroupEnd = dummy;
19        ListNode curr = head;
20        
21        while (curr != null) {
22            // Check if there are at least k nodes left to reverse
23            ListNode groupEnd = prevGroupEnd;
24            for (int i = 0; i < k; i++) {
25                groupEnd = groupEnd.next;
26                if (groupEnd == null) {
27                    // Less than k nodes left, keep them as-is and finish
28                    return dummy.next;
29                }
30            }
31            
32            // These will track our boundary positions
33            ListNode nextGroupStart = groupEnd.next;
34            ListNode groupStart = prevGroupEnd.next;
35            
36            // Reverse the current group of k nodes
37            ListNode prev = nextGroupStart;
38            ListNode p = groupStart;
39            while (p != nextGroupStart) {
40                ListNode nextNode = p.next;
41                p.next = prev;
42                prev = p;
43                p = nextNode;
44            }
45            
46            // Connect the reversed group back to the main list
47            prevGroupEnd.next = groupEnd;
48            prevGroupEnd = groupStart;
49            curr = nextGroupStart;
50        }
51        
52        return dummy.next;
53    }
54}