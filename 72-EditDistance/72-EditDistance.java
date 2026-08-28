// Last updated: 8/28/2026, 11:04:06 PM
class Solution {
    public int minDistance(String word1, String word2) {
        int dp[][]=new int[word1.length()][word2.length()];
        for(int rows[]:dp) Arrays.fill(rows,-1);
        return dist(word1.length()-1,word2.length()-1,word1,word2,dp);
    }
    int dist(int i,int j,String word1, String word2, int[][]dp)
    {
        if(i<0) return j+1;
        if(j<0) return i+1;

        if(dp[i][j]!=-1) return dp[i][j];

        if(word1.charAt(i)==word2.charAt(j)) return dp[i][j]=dist(i-1,j-1,word1,word2,dp);
        
        return
           dp[i][j]=  1 + (Math.min(dist(i-1,j,word1,word2,dp),Math.min(dist(i-1,j-1,word1,word2,dp),dist(i,j-1,word1,word2,dp))));
        
    }
    }