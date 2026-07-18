// Last updated: 7/18/2026, 5:57:20 AM
1import java.util.ArrayList;
2import java.util.List;
3
4class Solution {
5    public List<List<Integer>> combinationSum(int[] candidates, int target) {
6        List<List<Integer>> result = new ArrayList<>();
7        backtrack(candidates, target, 0, new ArrayList<>(), result);
8        return result;
9    }
10
11    private void backtrack(int[] candidates, int target, int index, List<Integer> current, List<List<Integer>> result) {
12        if (target == 0) {
13            result.add(new ArrayList<>(current));
14            return;
15        }
16        if (target < 0 || index >= candidates.length) {
17            return;
18        }
19        current.add(candidates[index]);
20        backtrack(candidates, target - candidates[index], index, current, result);
21       
22        current.remove(current.size() - 1);
23
24        backtrack(candidates, target, index + 1, current, result);
25    }
26}