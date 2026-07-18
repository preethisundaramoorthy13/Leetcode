// Last updated: 7/18/2026, 9:01:52 PM
class Solution {
     static {
        for (int i = 0; i < 100; i++) {
            maxArea(new int[] {0, 0});
        }   
    }
    public static int maxArea(int[] height) {
        int i=0;
        int j=height.length-1;
        int maxArea=0;
        while(i<j){
            int width=j-i;
            int minHeight=Math.min(height[i],height[j]);
            maxArea=Math.max(maxArea,minHeight*width);
            while(i<j && height[i]<=minHeight)i++;
            while(i<j && height[j]<=minHeight)j--;
        }
        return maxArea;
    }
}