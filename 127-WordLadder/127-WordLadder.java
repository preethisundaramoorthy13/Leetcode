// Last updated: 9/21/2026, 3:06:47 PM
1class Solution {
2    public void solve(char[][] board) {
3        if (board == null || board.length == 0) {
4            return;
5        }
6
7        int m = board.length;
8        int n = board[0].length;
9
10        for (int i = 0; i < m; i++) {
11            if (board[i][0] == 'O') {
12                dfs(board, i, 0);
13            }
14            if (board[i][n - 1] == 'O') {
15                dfs(board, i, n - 1);
16            }
17        }
18
19        for (int j = 0; j < n; j++) {
20            if (board[0][j] == 'O') {
21                dfs(board, 0, j);
22            }
23            if (board[m - 1][j] == 'O') {
24                dfs(board, m - 1, j);
25            }
26        }
27
28        for (int i = 0; i < m; i++) {
29            for (int j = 0; j < n; j++) {
30                if (board[i][j] == 'O') {
31                    board[i][j] = 'X';
32                } else if (board[i][j] == '#') {
33                    board[i][j] = 'O';
34                }
35            }
36        }
37    }
38
39    private void dfs(char[][] board, int r, int c) {
40        if (r < 0 || r >= board.length || c < 0 || c >= board[0].length || board[r][c] != 'O') {
41            return;
42        }
43
44        board[r][c] = '#';
45
46        dfs(board, r + 1, c);
47        dfs(board, r - 1, c);
48        dfs(board, r, c + 1);
49        dfs(board, r, c - 1);
50    }
51}