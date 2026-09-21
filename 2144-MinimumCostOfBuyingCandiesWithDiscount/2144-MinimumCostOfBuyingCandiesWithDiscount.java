// Last updated: 9/21/2026, 5:32:05 PM
class Solution {
    public int minimumCost(int[] cost) {
        Arrays.sort(cost);
        int total = 0;

        for (int i = cost.length - 1; i >= 0; i -= 3) {
            total += cost[i];
            if (i - 1 >= 0)
                total += cost[i - 1];
        }

        return total;
    }
}