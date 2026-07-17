// Last updated: 7/17/2026, 3:04:16 PM
class Solution {

    static {

        for(int i = 0; i <= 500 ; i++){
            containsDuplicate(new int[] {1, 0, 1});
        }
    }

    public static boolean containsDuplicate(int[] nums) {
       
        int n = nums.length;

        for(int i = 1; i < n ; i++){

            int curr = nums[i];
            int j = i - 1;

            while(j >= 0 && nums[j] > curr){
                nums[j+1] = nums[j];
                j--;
            }

            if(j >= 0 && nums[j] == curr)
                return true;

            nums[j+1] = curr; 

        }

        return false;

    }
}