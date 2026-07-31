// Last updated: 7/31/2026, 9:35:37 AM
class Solution {
    public boolean canReach(int[] start, int[] target) {
        return((start[0] + start[1]) % 2) == ((target[0] + target[1]) % 2);
    }
}