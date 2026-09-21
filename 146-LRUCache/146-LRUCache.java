// Last updated: 9/21/2026, 5:51:52 PM
1class Solution {
2    public String reverseWords(String s) {
3        char[] a = s.toCharArray();
4        int n = a.length;
5        char[] res = new char[n + 1];
6        int resIdx = 0;
7        int i = n - 1;
8
9        while (i >= 0) {
10            while (i >= 0 && a[i] == ' ') {
11                i--;
12            }
13            if (i < 0) {
14                break;
15            }
16            int j = i;
17            while (i >= 0 && a[i] != ' ') {
18                i--;
19            }
20            if (resIdx > 0) {
21                res[resIdx++] = ' ';
22            }
23            for (int k = i + 1; k <= j; k++) {
24                res[resIdx++] = a[k];
25            }
26        }
27
28        return new String(res, 0, resIdx);
29    }
30}