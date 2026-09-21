// Last updated: 9/21/2026, 5:08:17 PM
1class Solution {
2    public int candy(int[] ratings) {
3        if (ratings == null || ratings.length == 0) {
4            return 0;
5        }
6
7        int candies = 1;
8        int up = 0;
9        int down = 0;
10        int peak = 0;
11
12        for (int i = 1; i < ratings.length; i++) {
13            if (ratings[i] > ratings[i - 1]) {
14                up++;
15                down = 0;
16                peak = up;
17                candies += 1 + up;
18            } else if (ratings[i] == ratings[i - 1]) {
19                up = 0;
20                down = 0;
21                peak = 0;
22                candies += 1;
23            } else {
24                up = 0;
25                down++;
26                candies += 1 + down - (peak >= down ? 1 : 0);
27            }
28        }
29
30        return candies;
31    }
32}