// Last updated: 7/18/2026, 9:01:26 PM
class Solution {
    public int divide(int dividend, int divisor) {
        // Handle the unique 32-bit signed integer overflow case
        if (dividend == Integer.MIN_VALUE && divisor == -1) {
            return Integer.MAX_VALUE;
        }
        
        // Determine the sign of the quotient
        boolean isNegative = (dividend < 0) ^ (divisor < 0);
        
        // Convert to absolute values using long to avoid integer overflow
        long absDividend = Math.abs((long) dividend);
        long absDivisor = Math.abs((long) divisor);
        
        int quotient = 0;
        
        // Perform exponential subtraction using bit shifting
        while (absDividend >= absDivisor) {
            long tempDivisor = absDivisor;
            long multiple = 1;
            
            // Shift left until tempDivisor is just about to exceed absDividend
            while (absDividend >= (tempDivisor << 1)) {
                tempDivisor <<= 1;
                multiple <<= 1;
            }
            
            // Subtract the largest shifted divisor from dividend
            absDividend -= tempDivisor;
            // Add the corresponding multiple to the quotient
            quotient += multiple;
        }
        
        return isNegative ? -quotient : quotient;
    }
}