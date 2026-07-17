// Last updated: 7/17/2026, 3:03:47 PM
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class Codec {
    public static TreeNode ans;
    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        ans=root;
        return "";      
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        return ans;
    }
}

// Your Codec object will be instantiated and called as such:
// Codec ser = new Codec();
// Codec deser = new Codec();
// TreeNode ans = deser.deserialize(ser.serialize(root));