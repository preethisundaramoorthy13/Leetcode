// Last updated: 8/28/2026, 11:04:55 PM
class Solution {
    public int[][] insert(int[][] intervals, int[] newInterval) {
        int i=0;
        List<int[]> li=new ArrayList<>();
        while(i<intervals.length&&intervals[i][1]<newInterval[0]){
            li.add(intervals[i]);
            i++;
        }
        while(i<intervals.length&&intervals[i][0]<=newInterval[1]){
             newInterval[0]=Math.min(intervals[i][0],newInterval[0]);
             newInterval[1]=Math.max(intervals[i][1],newInterval[1]);
             i++;
        }
        li.add(newInterval);
        while(i<intervals.length){
            li.add(intervals[i]);
            i++;
        }int resultSize = li.size();
        int[][] resultInArray = new int[resultSize][2];
        for(int j=0;j<resultSize;j++){
            resultInArray[j] = li.get(j);
        }
        return resultInArray;
    }
}