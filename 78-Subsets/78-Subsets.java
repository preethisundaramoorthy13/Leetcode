// Last updated: 8/30/2026, 12:58:45 PM
1class Solution {
2    public boolean exist(char[][] board, String word) {
3        int rows = board.length;
4        int cols = board[0].length;
5
6        for (int r = 0; r < rows; r++) {
7            for (int c = 0; c < cols; c++) {
8                if (board[r][c] == word.charAt(0) && dfs(board, word, r, c, 0)) {
9                    return true;
10                }
11            }
12        }
13        return false;
14    }
15
16    private boolean dfs(char[][] board, String word, int r, int c, int index) {
17        if (index == word.length()) {
18            return true;
19        }
20
21        if (r < 0 || r >= board.length || c < 0 || c >= board[0].length || board[r][c] != word.charAt(index)) {
22            return false;
23        }
24
25        char temp = board[r][c];
26        board[r][c] = '#'; // Mark cell as visited
27
28        boolean found = dfs(board, word, r + 1, c, index + 1) ||
29                        dfs(board, word, r - 1, c, index + 1) ||
30                        dfs(board, word, r, c + 1, index + 1) ||
31                        dfs(board, word, r, c - 1, index + 1);
32
33        board[r][c] = temp; // Backtrack
34
35        return found;
36    }
37}