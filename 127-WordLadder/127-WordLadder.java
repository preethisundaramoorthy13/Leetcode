// Last updated: 9/21/2026, 4:47:21 PM
1class Solution {
2    public int canCompleteCircuit(int[] gas, int[] cost) {
3        int total = 0;
4        int tank = 0;
5        int start = 0;
6
7        for (int i = 0; i < gas.length; i++) {
8            int diff = gas[i] - cost[i];
9            total += diff;
10            tank += diff;
11            if (tank < 0) {
12                start = i + 1;
13                tank = 0;
14            }
15        }
16
17        return total >= 0 ? start : -1;
18    }
19}