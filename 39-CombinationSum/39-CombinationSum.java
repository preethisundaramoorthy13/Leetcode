// Last updated: 7/18/2026, 8:02:19 AM
1class Solution {
2    public String multiply(String num1, String num2) {
3        if (num1.equals("0") || num2.equals("0")) {
4            return "0";
5        }
6        
7        int m = num1.length(), n = num2.length();
8        int[] pos = new int[m + n];
9        
10        for (int i = m - 1; i >= 0; i--) {
11            for (int j = n - 1; j >= 0; j--) {
12                int mul = (num1.charAt(i) - '0') * (num2.charAt(j) - '0');
13                int p1 = i + j, p2 = i + j + 1;
14                int sum = mul + pos[p2];
15                
16                pos[p1] += sum / 10;
17                pos[p2] = sum % 10;
18            }
19        }
20        
21        StringBuilder sb = new StringBuilder();
22        for (int p : pos) {
23            if (!(sb.length() == 0 && p == 0)) {
24                sb.append(p);
25            }
26        }
27        
28        return sb.toString();
29    }
30}