// Last updated: 7/31/2026, 9:36:05 AM
class Solution {
    public char findKthBit(int n, int k) {
        if (n == 1) return '0';
        
        int len = (1 << n) - 1;
        int mid = len / 2 + 1;
        
        if (k == mid) {
            return '1';
        } else if (k < mid) {
            return findKthBit(n - 1, k);
        } else {
            char ch = findKthBit(n - 1, len - k + 1);
            return ch == '0' ? '1' : '0';
        }
    }
}