// Last updated: 7/31/2026, 9:36:07 AM
class Solution {
    public int minSwaps(int[][] grid) {
        int n = grid.length;
        int[] trailingZeros = new int[n];

        // Step 1: Count trailing zeros for each row
        for (int i = 0; i < n; i++) {
            int count = 0;
            for (int j = n - 1; j >= 0; j--) {
                if (grid[i][j] == 0) {
                    count++;
                } else {
                    break;
                }
            }
            trailingZeros[i] = count;
        }

        int totalSwaps = 0;

        // Step 2: Satisfy the trailing zeros requirement for each row i
        for (int i = 0; i < n; i++) {
            int neededZeros = n - 1 - i;
            int foundIdx = -1;

            // Find the nearest row from i onwards that satisfies the requirement
            for (int j = i; j < n; j++) {
                if (trailingZeros[j] >= neededZeros) {
                    foundIdx = j;
                    break;
                }
            }

            // If no suitable row exists, it's impossible
            if (foundIdx == -1) {
                return -1;
            }

            // Accumulate swaps needed to bring row foundIdx up to row i
            totalSwaps += (foundIdx - i);

            // Shift trailingZeros elements to reflect row movement
            for (int k = foundIdx; k > i; k--) {
                trailingZeros[k] = trailingZeros[k - 1];
            }
        }

        return totalSwaps;
    }
}