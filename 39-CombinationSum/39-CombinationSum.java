// Last updated: 7/18/2026, 8:05:35 AM
1class Solution {
2    public boolean isMatch(String s, String p) {
3        int sLen = s.length(), pLen = p.length();
4        int sIdx = 0, pIdx = 0;
5        int starIdx = -1, sTmpIdx = -1;
6
7        while (sIdx < sLen) {
8            if (pIdx < pLen && (p.charAt(pIdx) == '?' || p.charAt(pIdx) == s.charAt(sIdx))) {
9                sIdx++;
10                pIdx++;
11            } else if (pIdx < pLen && p.charAt(pIdx) == '*') {
12                starIdx = pIdx;
13                sTmpIdx = sIdx;
14                pIdx++;
15            } else if (starIdx != -1) {
16                pIdx = starIdx + 1;
17                sTmpIdx++;
18                sIdx = sTmpIdx;
19            } else {
20                return false;
21            }
22        }
23
24        while (pIdx < pLen && p.charAt(pIdx) == '*') {
25            pIdx++;
26        }
27
28        return pIdx == pLen;
29    }
30}