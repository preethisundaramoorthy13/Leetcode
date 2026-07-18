// Last updated: 7/18/2026, 2:07:01 AM
1class Solution {
2    public int divide(int dividend, int divisor) {
3        // Handle the unique 32-bit signed integer overflow case
4        if (dividend == Integer.MIN_VALUE && divisor == -1) {
5            return Integer.MAX_VALUE;
6        }
7        
8        // Determine the sign of the quotient
9        boolean isNegative = (dividend < 0) ^ (divisor < 0);
10        
11        // Convert to absolute values using long to avoid integer overflow
12        long absDividend = Math.abs((long) dividend);
13        long absDivisor = Math.abs((long) divisor);
14        
15        int quotient = 0;
16        
17        // Perform exponential subtraction using bit shifting
18        while (absDividend >= absDivisor) {
19            long tempDivisor = absDivisor;
20            long multiple = 1;
21            
22            // Shift left until tempDivisor is just about to exceed absDividend
23            while (absDividend >= (tempDivisor << 1)) {
24                tempDivisor <<= 1;
25                multiple <<= 1;
26            }
27            
28            // Subtract the largest shifted divisor from dividend
29            absDividend -= tempDivisor;
30            // Add the corresponding multiple to the quotient
31            quotient += multiple;
32        }
33        
34        return isNegative ? -quotient : quotient;
35    }
36}