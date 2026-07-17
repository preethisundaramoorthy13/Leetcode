// Last updated: 7/17/2026, 3:02:48 PM
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    public List<List<Integer>> verticalTraversal(TreeNode root) {
        HashSet<Integer> hs=new HashSet<>();
        int arr[]=traverse(root,0,0);
        arr[0]++;
        arr[1]--;
        int size=arr[1]-arr[0];
        PriorityQueue<Integer> temp[][]=new PriorityQueue[arr[2]][size+1];
        t(root,0,0,arr[0],temp);
        List<List<Integer>> res=new ArrayList<>();
        for(int i=0;i<=size;i++){
            res.add(new ArrayList<>());
            for(int j=0;j<arr[2];j++){
                if(temp[j][i]!=null){
                    PriorityQueue<Integer> pq=temp[j][i];
                    while(!pq.isEmpty()){
                        res.get(i).add(pq.remove());
                    }
                }
            }
        }
        return res;
    }
    void t(TreeNode root,int r,int c,int min,PriorityQueue<Integer> temp[][]){
        if(root==null){
            return;
        }
        if(temp[c][r-min]==null){
            temp[c][r-min]=new PriorityQueue<>();
        }
        temp[c][r-min].add(root.val);
        t(root.left,r-1,c+1,min,temp);
        t(root.right,r+1,c+1,min,temp);
        
    }
    int[] traverse(TreeNode root,int i,int j){
        if(root==null){
            return new int[]{i,i,j};
        }
       int l[]=traverse(root.left,i-1,j+1);
        int r[]=traverse(root.right,i+1,j+1);
        return new int[]{Math.min(l[0],r[0]),Math.max(l[1],r[1]),Math.max(l[2],r[2])};
    }
}