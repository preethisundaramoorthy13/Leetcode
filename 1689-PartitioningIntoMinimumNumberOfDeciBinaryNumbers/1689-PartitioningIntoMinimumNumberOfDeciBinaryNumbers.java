// Last updated: 9/21/2026, 5:32:28 PM
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