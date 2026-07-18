// Last updated: 7/18/2026, 8:08:19 AM
1import java.util.ArrayList;
2import java.util.List;
3
4class Solution {
5    public List<List<Integer>> permute(int[] nums) {
6        List<List<Integer>> result = new ArrayList<>();
7        backtrack(nums, new ArrayList<>(), result);
8        return result;
9    }
10
11    private void backtrack(int[] nums, List<Integer> current, List<List<Integer>> result) {
12        if (current.size() == nums.length) {
13            result.add(new ArrayList<>(current));
14            return;
15        }
16
17        for (int i = 0; i < nums.length; i++) {
18            if (current.contains(nums[i])) {
19                continue;
20            }
21            current.add(nums[i]);
22            backtrack(nums, current, result);
23            current.remove(current.size() - 1);
24        }
25    }
26}