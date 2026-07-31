// Last updated: 7/31/2026, 9:35:57 AM
class Solution {
    static {
        Solution instance = new Solution();

        for (int i = 0; i < 500; i++) {
            instance.minPartitions("0");
        }
    }

    public int minPartitions(String n) {
        int largestDigit = 0;

        for (int index = 0; index < n.length(); index++) {
            largestDigit = Math.max(n.charAt(index) - '0', largestDigit);
        }

        return largestDigit;
    }
}