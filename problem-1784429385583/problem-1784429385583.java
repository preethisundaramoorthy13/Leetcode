// Last updated: 7/18/2026, 9:49:45 PM
1class Solution {
2    public boolean canReach(int[] start, int[] target) {
3        return((start[0] + start[1]) % 2) == ((target[0] + target[1]) % 2);
4    }
5}