// Last updated: 8/30/2026, 12:55:50 PM
1import java.util.ArrayList;
2import java.util.List;
3
4class Solution {
5    public List<List<Integer>> subsets(int[] nums) {
6        List<List<Integer>> result = new ArrayList<>();
7        backtrack(0, nums, new ArrayList<>(), result);
8        return result;
9    }
10
11    private void backtrack(int start, int[] nums, List<Integer> current, List<List<Integer>> result) {
12        result.add(new ArrayList<>(current));
13        for (int i = start; i < nums.length; i++) {
14            current.add(nums[i]);
15            backtrack(i + 1, nums, current, result);
16            current.remove(current.size() - 1);
17        }
18    }
19}