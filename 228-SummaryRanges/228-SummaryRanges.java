// Last updated: 7/17/2026, 3:04:11 PM
class Solution {
    public List<String> summaryRanges(int[] nums) {
        List<String> res = new ArrayList<>();
        if (nums.length == 0) return res;
        if (nums.length == 1) {
            res.add(Integer.toString(nums[0]));
            return res;
        }

        int count = 1;
        StringBuilder sb = new StringBuilder();
        sb.append(nums[0]);
        // 0 1 2 3 4 7
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] != nums[i - 1] + 1) {
                if (count != 1) {
                    sb.append("->").append(nums[i - 1]);
                }
                res.add(sb.toString());
                sb = new StringBuilder();
                sb.append(nums[i]);
                count = 1;
            } else {
                count++;
            }

        }
        if (count != 1) {
            sb.append("->").append(nums[nums.length - 1]);
        }
        res.add(sb.toString());

        return res;
    }
}