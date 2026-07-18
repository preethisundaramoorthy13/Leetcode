// Last updated: 7/18/2026, 9:01:35 PM
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
import java.util.PriorityQueue;

class Solution {
    public ListNode mergeKLists(ListNode[] lists) {
        // Edge cases
        if (lists == null || lists.length == 0) {
            return null;
        }
        
        // Initialize Min-Heap based on node values
        PriorityQueue<ListNode> minHeap = new PriorityQueue<>((a, b) -> Integer.compare(a.val, b.val));
        
        // Add the head node of each non-empty list to the heap
        for (ListNode head : lists) {
            if (head != null) {
                minHeap.add(head);
            }
        }
        
        // Dummy node to easily build the output list
        ListNode dummy = new ListNode(0);
        ListNode tail = dummy;
        
        // Process the heap until empty
        while (!minHeap.isEmpty()) {
            ListNode smallestNode = minHeap.poll();
            tail.next = smallestNode;
            tail = tail.next;
            
            // If there is a next node in that list, push it to the heap
            if (smallestNode.next != null) {
                minHeap.add(smallestNode.next);
            }
        }
        
        return dummy.next;
    }
}