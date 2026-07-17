// Last updated: 7/17/2026, 3:05:15 PM
class Solution {
    public List<List<Integer>> generate(int numRows) {
       //res[i][j] = res[i-1][j-1] + res[i-1][j]
        List<List<Integer>> res=new ArrayList<>();

        for(int i=1;i<=numRows;i++){
            ArrayList<Integer> temp=new ArrayList<>();
            nthRowOfPascalTriangle(i,temp); 
            res.add(temp);
        }
        return res;
    }
    public void nthRowOfPascalTriangle(int row, ArrayList<Integer> ans) {
        // code here
        ans.add(1);
        int result=1;
        
        for(int col=1;col<row;col++){
            result=result * (row - col);
            result=result/col;
            ans.add(result);
        }
    }    
}