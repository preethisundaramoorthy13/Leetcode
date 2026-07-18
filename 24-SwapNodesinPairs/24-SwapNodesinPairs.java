// Last updated: 7/18/2026, 2:06:17 AM
/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public ListNode reverseKGroup(ListNode head, int k) {
        
        if (head == null || k == 1) return head;

        ListNode current = head;
        ListNode previousGroupTail = null;
        ListNode newHead = null;
        int i = 0;

        while (current != null) {
            ListNode[] result = reverseK(current, k);

            // less than k nodes left, keep as is
            if (result == null) {
                if (previousGroupTail != null) {
                    previousGroupTail.next = current;
                }
                break;
            }

            // first reversed group gives final head
            if (i == 0) {
                newHead = result[0];
            } else {
                previousGroupTail.next = result[0];
            }

            // old group head becomes tail after reverse; connect to next group start
            current.next = result[1];

            // move to next group
            previousGroupTail = current;
            current = result[1];
            i++;
        }

        return newHead == null ? head : newHead;
    }

    private ListNode[] reverseK(ListNode head, int k) {
        // check if k nodes exist
        ListNode check = head;
        int count = 0;
        while (count < k && check != null) {
            check = check.next;
            count++;
        }

        if (count < k) return null;

        ListNode previous = null;
        ListNode current = head;
        int i = 0;

        while (i < k && current != null) {
            ListNode next = current.next;
            current.next = previous;
            previous = current;
            current = next;
            i++;
        }

        // return {newGroupHead, nextGroupStart}
        return new ListNode[]{previous, current};
    }
}