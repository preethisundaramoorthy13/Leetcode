// Last updated: 9/22/2026, 9:34:53 AM
1import java.util.ArrayList;
2import java.util.HashSet;
3import java.util.List;
4import java.util.Set;
5
6class Solution {
7    public List<String> findRepeatedDnaSequences(String s) {
8        if (s == null || s.length() <= 10) {
9            return new ArrayList<>();
10        }
11        
12        Set<String> seen = new HashSet<>();
13        Set<String> repeated = new HashSet<>();
14        
15        for (int i = 0; i <= s.length() - 10; i++) {
16            String sequence = s.substring(i, i + 10);
17            if (!seen.add(sequence)) {
18                repeated.add(sequence);
19            }
20        }
21        
22        return new ArrayList<>(repeated);
23    }
24}