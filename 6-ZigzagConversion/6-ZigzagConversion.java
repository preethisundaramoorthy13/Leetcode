// Last updated: 7/17/2026, 9:10:03 PM
1class Solution {
2    public String convert(String s, int numRows) {
3        if(numRows== 1 || numRows >= s.length()) {
4            return s;
5        }
6        StringBuilder sb = new StringBuilder();
7        int n = s.length();
8        int cycle = 2 * numRows - 2;
9        for (int i = 0; i < numRows; i++) {
10            int j = i;
11            while (j < n) {
12                sb.append(s.charAt(j));
13                if (i != 0 && i != numRows - 1) {
14                    int midIndex = j + cycle - 2 * i;
15                    if (midIndex < n) {
16                        sb.append(s.charAt(midIndex));
17                    }
18                }
19                j += cycle;
20            }
21        }
22        return sb.toString();
23    }
24}