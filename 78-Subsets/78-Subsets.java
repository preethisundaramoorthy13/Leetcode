// Last updated: 8/30/2026, 12:56:35 PM
class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> ans=new ArrayList<>();
        int n=nums.length;
        solve(0,nums,new ArrayList<>(),ans);
        return ans;
    }
    public void solve(int index,int nums[],List<Integer> lst,List<List<Integer>> ans)
    {
        if(index==nums.length)
        {
            ans.add(new ArrayList<>(lst));
            return;
        }
        lst.add(nums[index]);
        solve(index+1,nums,lst,ans);
        lst.remove(lst.size() - 1);
        solve(index+1,nums,lst,ans);
       
    }
}