// Last updated: 7/15/2026, 2:01:36 PM
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
12    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
13        // Create a dummy head to simplify list construction
14        ListNode dummyHead = new ListNode(0);
15        ListNode curr = dummyHead;
16        int carry = 0;
17
18        // Traverse both lists until we reach the end of both and have no carry left
19        while (l1 != null || l2 != null || carry != 0) {
20            int sum = carry;
21
22            if (l1 != null) {
23                sum += l1.val;
24                l1 = l1.next;
25            }
26            if (l2 != null) {
27                sum += l2.val;
28                l2 = l2.next;
29            }
30
31            // Calculate new carry and the digit to store in the new node
32            carry = sum / 10;
33            curr.next = new ListNode(sum % 10);
34            curr = curr.next;
35        }
36
37        return dummyHead.next;
38    }
39}