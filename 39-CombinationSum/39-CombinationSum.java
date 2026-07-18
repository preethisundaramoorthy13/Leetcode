// Last updated: 7/18/2026, 8:07:33 AM
1class Solution {
2    public int jump(int[] nums) {
3        if (nums.length <= 1) {
4            return 0;
5        }
6
7        int jumps = 0;
8        int currentEnd = 0;
9        int farthest = 0;
10
11        for (int i = 0; i < nums.length - 1; i++) {
12            farthest = Math.max(farthest, i + nums[i]);
13            
14            if (i == currentEnd) {
15                jumps++;
16                currentEnd = farthest;
17                
18                if (currentEnd >= nums.length - 1) {
19                    break;
20                }
21            }
22        }
23
24        return jumps;
25    }
26}