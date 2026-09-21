// Last updated: 9/21/2026, 5:26:50 PM
1import java.util.ArrayList;
2import java.util.List;
3
4class Solution {
5    public List<String> wordBreak(String s, List<String> wordDict) {
6        TrieNode root = buildTrie(wordDict);
7        List<String> result = new ArrayList<>();
8        dfs(s, 0, root, new StringBuilder(), result);
9        return result;
10    }
11
12    private void dfs(String s, int index, TrieNode root, StringBuilder current, List<String> result) {
13        if (index == s.length()) {
14            result.add(current.substring(0, current.length() - 1));
15            return;
16        }
17
18        TrieNode curr = root;
19        int len = current.length();
20
21        for (int i = index; i < s.length(); i++) {
22            int charIndex = s.charAt(i) - 'a';
23            if (curr.children[charIndex] == null) {
24                break;
25            }
26            curr = curr.children[charIndex];
27            if (curr.isWord) {
28                current.append(s, index, i + 1).append(" ");
29                dfs(s, i + 1, root, current, result);
30                current.setLength(len);
31            }
32        }
33    }
34
35    private TrieNode buildTrie(List<String> wordDict) {
36        TrieNode root = new TrieNode();
37        for (String word : wordDict) {
38            TrieNode curr = root;
39            for (char c : word.toCharArray()) {
40                int index = c - 'a';
41                if (curr.children[index] == null) {
42                    curr.children[index] = new TrieNode();
43                }
44                curr = curr.children[index];
45            }
46            curr.isWord = true;
47        }
48        return root;
49    }
50
51    private static class TrieNode {
52        TrieNode[] children = new TrieNode[26];
53        boolean isWord;
54    }
55}