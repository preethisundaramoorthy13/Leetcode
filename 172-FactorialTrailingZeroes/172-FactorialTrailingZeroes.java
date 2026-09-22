// Last updated: 9/22/2026, 9:36:32 AM
1public class Solution {
2    // treat n as an unsigned value
3    public int reverseBits(int n) {
4        int result = 0;
5        for (int i = 0; i < 32; i++) {
6            result = (result << 1) | (n & 1);
7            n >>>= 1; // Logical right shift
8        }
9        return result;
10    }
11}