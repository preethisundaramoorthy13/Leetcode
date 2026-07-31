// Last updated: 7/31/2026, 9:42:59 AM
class Solution {
    public int[] intersect(int[] nums1, int[] nums2) {
        int[] freq = new int[1001];
        for (int num : nums1) {
            freq[num]++;
        }
        int[] temp = new int[Math.min(nums1.length, nums2.length)];
        int k = 0;
        for (int num : nums2) {
            if (freq[num] > 0) {
                temp[k++] = num;
                freq[num]--;
            }
        }
        int[] result = new int[k];
        for (int i = 0; i < k; i++) {
            result[i] = temp[i];
        }
        return result;
    }
}