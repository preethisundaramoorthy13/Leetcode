// Last updated: 7/18/2026, 9:01:41 PM
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
    public ListNode removeNthFromEnd(ListNode head, int n) {
        // Create a dummy node to seamlessly handle edge cases (like removing the head node)
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        
        ListNode fast = dummy;
        ListNode slow = dummy;
        
        // 1. Move the fast pointer so that there is a gap of n nodes between fast and slow
        for (int i = 0; i <= n; i++) {
            fast = fast.next;
        }
        
        // 2. Move fast to the end, maintaining the constant gap
        while (fast != null) {
            fast = fast.next;
            slow = slow.next;
        }
        
        // 3. slow is now right before the node to be deleted. Skip the target node.
        slow.next = slow.next.next;
        
        return dummy.next;
    }
}