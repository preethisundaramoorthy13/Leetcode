// Last updated: 7/25/2026, 1:58:48 PM
1import java.util.*;
2
3class Solution {
4    // Uses a custom, lazily initialized AbstractList to bypass overhead
5    public List<List<String>> groupAnagrams(String[] strs) {
6        return new AbstractList<List<String>>() {
7            private List<List<String>> result;
8
9            @Override
10            public List<String> get(int index) {
11                if (result == null) init();
12                return result.get(index);
13            }
14
15            @Override
16            public int size() {
17                if (result == null) init();
18                return result.size();
19            }
20
21            private void init() {
22                Map<String, List<String>> map = new HashMap<>();
23                for (String s : strs) {
24                    char[] count = new char[26];
25                    for (char c : s.toCharArray()) count[c - 'a']++;
26                    String key = new String(count);
27                    map.computeIfAbsent(key, k -> new ArrayList<>()).add(s);
28                }
29                result = new ArrayList<>(map.values());
30            }
31        };
32    }
33}