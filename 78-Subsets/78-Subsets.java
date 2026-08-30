// Last updated: 8/30/2026, 5:01:29 PM
1import java.util.HashMap;
2import java.util.Map;
3
4class Solution {
5    private Map<String, Boolean> memo = new HashMap<>();
6
7    public boolean isScramble(String s1, String s2) {
8        if (s1.equals(s2)) {
9            return true;
10        }
11
12        String key = s1 + "#" + s2;
13        if (memo.containsKey(key)) {
14            return memo.get(key);
15        }
16
17        int n = s1.length();
18
19        // Pruning: Compare character frequencies
20        int[] count = new int[26];
21        for (int i = 0; i < n; i++) {
22            count[s1.charAt(i) - 'a']++;
23            count[s2.charAt(i) - 'a']--;
24        }
25
26        for (int i = 0; i < 26; i++) {
27            if (count[i] != 0) {
28                memo.put(key, false);
29                return false;
30            }
31        }
32
33        // Try every possible split point
34        for (int i = 1; i < n; i++) {
35            // Case 1: No swap (s1[0..i] matches s2[0..i] and s1[i..n] matches s2[i..n])
36            if (isScramble(s1.substring(0, i), s2.substring(0, i)) &&
37                isScramble(s1.substring(i), s2.substring(i))) {
38                memo.put(key, true);
39                return true;
40            }
41
42            // Case 2: Swapped (s1[0..i] matches s2[n-i..n] and s1[i..n] matches s2[0..n-i])
43            if (isScramble(s1.substring(0, i), s2.substring(n - i)) &&
44                isScramble(s1.substring(i), s2.substring(0, n - i))) {
45                memo.put(key, true);
46                return true;
47            }
48        }
49
50        memo.put(key, false);
51        return false;
52    }
53}