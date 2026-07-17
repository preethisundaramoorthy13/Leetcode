// Last updated: 7/17/2026, 9:56:51 PM
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
11import java.util.PriorityQueue;
12
13class Solution {
14    public ListNode mergeKLists(ListNode[] lists) {
15        // Edge cases
16        if (lists == null || lists.length == 0) {
17            return null;
18        }
19        
20        // Initialize Min-Heap based on node values
21        PriorityQueue<ListNode> minHeap = new PriorityQueue<>((a, b) -> Integer.compare(a.val, b.val));
22        
23        // Add the head node of each non-empty list to the heap
24        for (ListNode head : lists) {
25            if (head != null) {
26                minHeap.add(head);
27            }
28        }
29        
30        // Dummy node to easily build the output list
31        ListNode dummy = new ListNode(0);
32        ListNode tail = dummy;
33        
34        // Process the heap until empty
35        while (!minHeap.isEmpty()) {
36            ListNode smallestNode = minHeap.poll();
37            tail.next = smallestNode;
38            tail = tail.next;
39            
40            // If there is a next node in that list, push it to the heap
41            if (smallestNode.next != null) {
42                minHeap.add(smallestNode.next);
43            }
44        }
45        
46        return dummy.next;
47    }
48}