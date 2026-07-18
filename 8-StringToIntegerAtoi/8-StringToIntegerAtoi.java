// Last updated: 7/18/2026, 9:01:57 PM
class Solution {
    public int myAtoi(String s) {
        if (s == null || s.length() == 0) {
            return 0;
        }

        int index = 0;
        int n = s.length();
        int sign = 1;
        int result = 0;

        // 1. Discard leading whitespaces
        while (index < n && s.charAt(index) == ' ') {
            index++;
        }

        // If the string is empty or only had spaces
        if (index == n) {
            return 0;
        }

        // 2. Check for sign
        if (s.charAt(index) == '+' || s.charAt(index) == '-') {
            sign = (s.charAt(index) == '-') ? -1 : 1;
            index++;
        }

        // 3. Convert digits and handle overflow
        while (index < n) {
            char currChar = s.charAt(index);
            
            // Stop if it's a non-digit character
            if (currChar < '0' || currChar > '9') {
                break;
            }

            int digit = currChar - '0';

            // 4. Check overflow/underflow bounds before updating result
            if (result > Integer.MAX_VALUE / 10 || 
               (result == Integer.MAX_VALUE / 10 && digit > Integer.MAX_VALUE % 10)) {
                return (sign == 1) ? Integer.MAX_VALUE : Integer.MIN_VALUE;
            }

            result = result * 10 + digit;
            index++;
        }

        return result * sign;
    }
}