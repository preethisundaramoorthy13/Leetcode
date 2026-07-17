// Last updated: 7/17/2026, 3:05:03 PM
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
    ListNode curr;
    boolean abort;
    public void reorderList(ListNode head) {
        curr = head;
        abort = false;
        rec(head);
    }
    private void rec(ListNode node) {
        if(node == null) {return;}
        rec(node.next);
        if(!abort && (curr == node || curr.next == node)) {
            node.next = null;
            abort = true;
        }
        if(abort) {return;}
        ListNode currNext = curr.next;
        curr.next = node;
        node.next = currNext;
        curr = currNext;
    }
}
