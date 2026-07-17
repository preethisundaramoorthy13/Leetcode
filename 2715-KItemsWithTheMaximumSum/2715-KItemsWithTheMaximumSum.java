// Last updated: 7/17/2026, 3:02:05 PM
class Solution {
    public int kItemsWithMaximumSum(int numOnes, int numZeros, int numNegOnes, int k) {
        
        int max = 0; 
        while(k > 0){
            if(numOnes > 0){
                numOnes--;
                max++;
                k--;
            }
            else if(numZeros > 0){
                numZeros--;
                k--;
            }
        
            else{
                numNegOnes--;
                max--;
                k--;
            }   
        } 
        return max;
    }
}