// Last updated: 7/31/2026, 9:34:51 AM
1class Solution {
2    public String addStrings(String num1, String num2) {
3        
4      StringBuilder result = new StringBuilder();
5
6        int i = num1.length() - 1;
7        int j = num2.length() - 1;
8
9        int carry = 0;
10
11        while(i >= 0 || j >= 0 || carry != 0){
12            int digit1 = (i>=0) ? num1.charAt(i) - '0':0;
13            int digit2 = (j>=0) ? num2.charAt(j) - '0':0;
14
15            int sum = digit1 + digit2 + carry;
16
17            carry = sum / 10;
18
19            result.append(sum%10);
20            i--;
21            j--;
22
23        }
24        return result.reverse().toString();
25    }
26}