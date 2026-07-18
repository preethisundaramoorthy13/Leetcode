// Last updated: 7/18/2026, 9:01:33 PM
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
    public ListNode swapPairs(ListNode head) {
        // Create a dummy node to point to the head of the list
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        
        // This pointer tracks the node right before the pair we are swapping
        ListNode prev = dummy;
        
        // Make sure there are at least two nodes left to swap
        while (prev.next != null && prev.next.next != null) {
            ListNode first = prev.next;
            ListNode second = prev.next.next;
            
            // Adjusting pointers to swap the pair
            first.next = second.next;
            second.next = first;
            prev.next = second;
            
            // Move the prev pointer two steps ahead for the next pair
            prev = first;
        }
        
        return dummy.next;
    }
}