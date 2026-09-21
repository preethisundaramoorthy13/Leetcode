// Last updated: 9/21/2026, 5:58:01 PM
1class Solution {
2    public int compareVersion(String version1, String version2) {
3        int n1 = version1.length();
4        int n2 = version2.length();
5        int i = 0;
6        int j = 0;
7
8        while (i < n1 || j < n2) {
9            int num1 = 0;
10            while (i < n1 && version1.charAt(i) != '.') {
11                num1 = num1 * 10 + (version1.charAt(i) - '0');
12                i++;
13            }
14
15            int num2 = 0;
16            while (j < n2 && version2.charAt(j) != '.') {
17                num2 = num2 * 10 + (version2.charAt(j) - '0');
18                j++;
19            }
20
21            if (num1 < num2) {
22                return -1;
23            }
24            if (num1 > num2) {
25                return 1;
26            }
27
28            i++;
29            j++;
30        }
31
32        return 0;
33    }
34}