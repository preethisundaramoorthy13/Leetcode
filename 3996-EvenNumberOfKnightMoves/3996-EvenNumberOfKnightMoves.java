// Last updated: 9/21/2026, 5:30:39 PM
class Solution {
    public boolean canReach(int[] start, int[] target) {
        return((start[0] + start[1]) % 2) == ((target[0] + target[1]) % 2);
    }
}