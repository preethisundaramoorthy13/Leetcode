// Last updated: 8/28/2026, 11:03:55 PM
import java.util.ArrayList;
import java.util.List;

class Solution {
    public List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> result = new ArrayList<>();
        backtrack(1, n, k, new ArrayList<>(), result);
        return result;
    }

    private void backtrack(int start, int n, int k, List<Integer> current, List<List<Integer>> result) {
        // Base case: combination of size k is formed
        if (current.size() == k) {
            result.add(new ArrayList<>(current));
            return;
        }

        // Pruning optimization: stop exploring if remaining numbers aren't enough to reach k elements
        int remainingNeeded = k - current.size();
        for (int i = start; i <= n - remainingNeeded + 1; i++) {
            current.add(i);
            backtrack(i + 1, n, k, current, result);
            current.remove(current.size() - 1); // Backtrack
        }
    }
}