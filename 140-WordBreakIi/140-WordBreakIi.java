// Last updated: 9/21/2026, 5:38:47 PM
import java.util.ArrayList;
import java.util.List;

class Solution {
    public List<String> wordBreak(String s, List<String> wordDict) {
        TrieNode root = buildTrie(wordDict);
        List<String> result = new ArrayList<>();
        dfs(s, 0, root, new StringBuilder(), result);
        return result;
    }

    private void dfs(String s, int index, TrieNode root, StringBuilder current, List<String> result) {
        if (index == s.length()) {
            result.add(current.substring(0, current.length() - 1));
            return;
        }

        TrieNode curr = root;
        int len = current.length();

        for (int i = index; i < s.length(); i++) {
            int charIndex = s.charAt(i) - 'a';
            if (curr.children[charIndex] == null) {
                break;
            }
            curr = curr.children[charIndex];
            if (curr.isWord) {
                current.append(s, index, i + 1).append(" ");
                dfs(s, i + 1, root, current, result);
                current.setLength(len);
            }
        }
    }

    private TrieNode buildTrie(List<String> wordDict) {
        TrieNode root = new TrieNode();
        for (String word : wordDict) {
            TrieNode curr = root;
            for (char c : word.toCharArray()) {
                int index = c - 'a';
                if (curr.children[index] == null) {
                    curr.children[index] = new TrieNode();
                }
                curr = curr.children[index];
            }
            curr.isWord = true;
        }
        return root;
    }

    private static class TrieNode {
        TrieNode[] children = new TrieNode[26];
        boolean isWord;
    }
}