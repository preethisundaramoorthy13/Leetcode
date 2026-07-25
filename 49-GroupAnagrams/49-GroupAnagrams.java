// Last updated: 7/25/2026, 1:57:52 PM
1import java.util.*;
2
3class Solution {
4    public List<List<String>> groupAnagrams(String[] strs) {
5        if (strs == null || strs.length == 0) {
6            return new ArrayList<>();
7        }
8
9        Map<String, List<String>> map = new HashMap<>();
10
11        for (String s : strs) {
12            char[] charArray = s.toCharArray();
13            Arrays.sort(charArray);
14            String key = String.valueOf(charArray);
15
16            if (!map.containsKey(key)) {
17                map.put(key, new ArrayList<>());
18            }
19            map.get(key).add(s);
20        }
21
22        return new ArrayList<>(map.values());
23    }
24}