// Last updated: 7/17/2026, 9:10:58 PM
1class Solution {
2    public int myAtoi(String s) {
3        if (s == null || s.length() == 0) {
4            return 0;
5        }
6
7        int index = 0;
8        int n = s.length();
9        int sign = 1;
10        int result = 0;
11
12        // 1. Discard leading whitespaces
13        while (index < n && s.charAt(index) == ' ') {
14            index++;
15        }
16
17        // If the string is empty or only had spaces
18        if (index == n) {
19            return 0;
20        }
21
22        // 2. Check for sign
23        if (s.charAt(index) == '+' || s.charAt(index) == '-') {
24            sign = (s.charAt(index) == '-') ? -1 : 1;
25            index++;
26        }
27
28        // 3. Convert digits and handle overflow
29        while (index < n) {
30            char currChar = s.charAt(index);
31            
32            // Stop if it's a non-digit character
33            if (currChar < '0' || currChar > '9') {
34                break;
35            }
36
37            int digit = currChar - '0';
38
39            // 4. Check overflow/underflow bounds before updating result
40            if (result > Integer.MAX_VALUE / 10 || 
41               (result == Integer.MAX_VALUE / 10 && digit > Integer.MAX_VALUE % 10)) {
42                return (sign == 1) ? Integer.MAX_VALUE : Integer.MIN_VALUE;
43            }
44
45            result = result * 10 + digit;
46            index++;
47        }
48
49        return result * sign;
50    }
51}