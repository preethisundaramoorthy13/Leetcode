// Last updated: 7/18/2026, 5:57:56 AM
class Solution {
    public boolean search(int[] nums, int target) {
        int low = 0;
        int high = nums.length - 1;
        while(low<=high){
            int mid = low+(high-low)/2;
            if(nums[mid] == target){
                return true;
            }
            if(nums[low] == nums[mid] && nums[mid] == nums[high]){
                high--;
                low++;
            }
            else if(nums[low] <= nums[mid]){
                if(target < nums[mid] && target>=nums[low]){
                    high = mid-1;
                }
                else{
                    low = mid+1;
                }
            }
            else{
                if(target > nums[mid] && target<=nums[high]){
                    low=mid+1;
                }
                else{
                    high=mid-1;
                }
            }
        }
        return false;

    }
}