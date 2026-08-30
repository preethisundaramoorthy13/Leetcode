// Last updated: 8/30/2026, 1:01:55 PM
1class Solution {
2    public boolean exist(char[][] board, String word) {
3        int m = board.length;
4        int n = board[0].length;
5        char[] w = word.toCharArray();
6        int len = w.length;
7
8        if (len > m * n) {
9            return false;
10        }
11
12        int[] counts = new int[128];
13        for (int i = 0; i < m; i++) {
14            for (int j = 0; j < n; j++) {
15                counts[board[i][j]]++;
16            }
17        }
18
19        int[] wordCounts = new int[128];
20        for (char c : w) {
21            if (++wordCounts[c] > counts[c]) {
22                return false;
23            }
24        }
25
26        if (counts[w[0]] > counts[w[len - 1]]) {
27            for (int i = 0; i < len / 2; i++) {
28                char temp = w[i];
29                w[i] = w[len - 1 - i];
30                w[len - 1 - i] = temp;
31            }
32        }
33
34        for (int i = 0; i < m; i++) {
35            for (int j = 0; j < n; j++) {
36                if (board[i][j] == w[0] && dfs(board, w, i, j, 0)) {
37                    return true;
38                }
39            }
40        }
41        
42        return false;
43    }
44
45    private boolean dfs(char[][] board, char[] w, int i, int j, int index) {
46        if (index == w.length) {
47            return true;
48        }
49        
50        if (i < 0 || i >= board.length || j < 0 || j >= board[0].length || board[i][j] != w[index]) {
51            return false;
52        }
53
54        char temp = board[i][j];
55        board[i][j] = '#';
56
57        boolean found = dfs(board, w, i + 1, j, index + 1)
58                     || dfs(board, w, i - 1, j, index + 1)
59                     || dfs(board, w, i, j + 1, index + 1)
60                     || dfs(board, w, i, j - 1, index + 1);
61
62        board[i][j] = temp;
63        return found;
64    }
65}