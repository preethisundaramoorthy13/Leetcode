// Last updated: 9/21/2026, 5:46:40 PM
1import java.util.HashMap;
2import java.util.Map;
3
4class Solution {
5    public int maxPoints(int[][] points) {
6        int n = points.length;
7        if (n <= 2) {
8            return n;
9        }
10
11        int max = 0;
12
13        for (int i = 0; i < n; i++) {
14            Map<Double, Integer> map = new HashMap<>();
15            int x1 = points[i][0];
16            int y1 = points[i][1];
17
18            for (int j = i + 1; j < n; j++) {
19                int x2 = points[j][0];
20                int y2 = points[j][1];
21
22                double slope;
23                if (x1 == x2) {
24                    slope = Double.POSITIVE_INFINITY;
25                } else if (y1 == y2) {
26                    slope = 0.0;
27                } else {
28                    slope = (double) (y2 - y1) / (x2 - x1);
29                }
30
31                int count = map.getOrDefault(slope, 1) + 1;
32                map.put(slope, count);
33                max = Math.max(max, count);
34            }
35        }
36
37        return max;
38    }
39}