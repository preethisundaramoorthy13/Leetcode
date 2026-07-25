// Last updated: 7/25/2026, 2:10:19 PM
1import java.util.*;
2
3class Solution {
4    public int[][] insert(int[][] intervals, int[] newInterval) {
5        List<int[]> result = new ArrayList<>();
6        int i = 0;
7        int n = intervals.length;
8
9        while (i < n && intervals[i][1] < newInterval[0]) {
10            result.add(intervals[i]);
11            i++;
12        }
13
14        while (i < n && intervals[i][0] <= newInterval[1]) {
15            newInterval[0] = Math.min(newInterval[0], intervals[i][0]);
16            newInterval[1] = Math.max(newInterval[1], intervals[i][1]);
17            i++;
18        }
19        result.add(newInterval);
20
21        while (i < n) {
22            result.add(intervals[i]);
23            i++;
24        }
25
26        return result.toArray(new int[result.size()][]);
27    }
28}