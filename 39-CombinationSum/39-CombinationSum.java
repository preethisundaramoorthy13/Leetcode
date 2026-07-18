// Last updated: 7/18/2026, 8:22:12 PM
1import java.util.ArrayList;
2import java.util.Arrays;
3import java.util.List;
4
5class Solution {
6    public List<List<Integer>> permuteUnique(int[] nums) {
7        List<List<Integer>> result = new ArrayList<>();
8        Arrays.sort(nums);
9        backtrack(nums, new boolean[nums.length], new ArrayList<>(), result);
10        return result;
11    }
12
13    private void backtrack(int[] nums, boolean[] used, List<Integer> current, List<List<Integer>> result) {
14        if (current.size() == nums.length) {
15            result.add(new ArrayList<>(current));
16            return;
17        }
18
19        for (int i = 0; i < nums.length; i++) {
20            if (used[i]) {
21                continue;
22            }
23            if (i > 0 && nums[i] == nums[i - 1] && !used[i - 1]) {
24                continue;
25            }
26
27            used[i] = true;
28            current.add(nums[i]);
29            backtrack(nums, used, current, result);
30            current.remove(current.size() - 1);
31            used[i] = false;
32        }
33    }
34}