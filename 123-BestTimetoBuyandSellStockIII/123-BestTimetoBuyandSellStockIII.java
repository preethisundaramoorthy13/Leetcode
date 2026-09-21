// Last updated: 9/21/2026, 2:53:35 PM
1import java.util.HashSet;
2import java.util.List;
3import java.util.Set;
4
5class Solution {
6    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
7        Set<String> dict = new HashSet<>(wordList);
8        if (!dict.contains(endWord)) {
9            return 0;
10        }
11
12        Set<String> beginSet = new HashSet<>();
13        Set<String> endSet = new HashSet<>();
14
15        beginSet.add(beginWord);
16        endSet.add(endWord);
17
18        int len = 1;
19
20        while (!beginSet.isEmpty() && !endSet.isEmpty()) {
21            if (beginSet.size() > endSet.size()) {
22                Set<String> temp = beginSet;
23                beginSet = endSet;
24                endSet = temp;
25            }
26
27            Set<String> nextSet = new HashSet<>();
28            for (String word : beginSet) {
29                char[] chs = word.toCharArray();
30                for (int i = 0; i < chs.length; i++) {
31                    char old = chs[i];
32                    for (char c = 'a'; c <= 'z'; c++) {
33                        if (c == old) {
34                            continue;
35                        }
36                        chs[i] = c;
37                        String target = String.valueOf(chs);
38
39                        if (endSet.contains(target)) {
40                            return len + 1;
41                        }
42
43                        if (dict.contains(target)) {
44                            nextSet.add(target);
45                            dict.remove(target);
46                        }
47                    }
48                    chs[i] = old;
49                }
50            }
51
52            beginSet = nextSet;
53            len++;
54        }
55
56        return 0;
57    }
58}