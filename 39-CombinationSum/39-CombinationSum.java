// Last updated: 7/18/2026, 7:59:16 AM
1import java.util.ArrayList;
2import java.util.Arrays;
3import java.util.List;
4
5class Solution {
6    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
7        List<List<Integer>> result = new ArrayList<>();
8        Arrays.sort(candidates);
9        backtrack(candidates, target, 0, new ArrayList<>(), result);
10        return result;
11    }
12
13    private void backtrack(int[] candidates, int target, int index, List<Integer> current, List<List<Integer>> result) {
14        if (target == 0) {
15            result.add(new ArrayList<>(current));
16            return;
17        }
18
19        for (int i = index; i < candidates.length; i++) {
20            if (candidates[i] > target) {
21                break;
22            }
23
24            if (i > index && candidates[i] == candidates[i - 1]) {
25                continue;
26            }
27
28            current.add(candidates[i]);
29            backtrack(candidates, target - candidates[i], i + 1, current, result);
30            current.remove(current.size() - 1);
31        }
32    }
33}