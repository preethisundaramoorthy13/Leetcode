// Last updated: 7/18/2026, 5:57:51 AM
class Solution {
    void fc(int[] can,int target,List<Integer>ans,List<List<Integer>>res,int sum,int index){
        if(index==can.length){
            if(sum==target){
                res.add(new ArrayList(ans));
            }
            return;
        }
        if(sum+can[index]<=target){
            ans.add(can[index]);
            fc(can,target,ans,res,sum+can[index],index);
            ans.remove(ans.size()-1);
        }
        fc(can,target,ans,res,sum,index+1);
    }
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<Integer>ans=new ArrayList<>();
        List<List<Integer>>res=new ArrayList<>();
        fc(candidates,target,ans,res,0,0);
        return res;
    }
}