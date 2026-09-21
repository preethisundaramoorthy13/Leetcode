// Last updated: 9/21/2026, 5:40:10 PM
class Solution {
    private ListNode head;

    public TreeNode sortedListToBST(ListNode head) {
        this.head = head;
        int length = getLength(head);
        return buildTree(0, length - 1);
    }

    private int getLength(ListNode head) {
        int len = 0;
        while (head != null) {
            len++;
            head = head.next;
        }
        return len;
    }

    private TreeNode buildTree(int left, int right) {
        if (left > right) {
            return null;
        }

        int mid = left + (right - left) / 2;

        TreeNode leftChild = buildTree(left, mid - 1);

        TreeNode root = new TreeNode(head.val);
        root.left = leftChild;

        head = head.next;

        root.right = buildTree(mid + 1, right);

        return root;
    }
}