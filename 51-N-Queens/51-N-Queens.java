// Last updated: 7/18/2026, 8:58:55 PM
1import java.util.ArrayList;
2import java.util.List;
3
4class Solution {
5    public List<List<String>> solveNQueens(int n) {
6        List<List<String>> result = new ArrayList<>();
7        char[][] board = new char[n][n];
8        for (int i = 0; i < n; i++) {
9            for (int j = 0; j < n; j++) {
10                board[i][j] = '.';
11            }
12        }
13        boolean[] cols = new boolean[n];
14        boolean[] diag1 = new boolean[2 * n];
15        boolean[] diag2 = new boolean[2 * n];
16        backtrack(0, n, board, cols, diag1, diag2, result);
17        return result;
18    }
19
20    private void backtrack(int row, int n, char[][] board, boolean[] cols, boolean[] diag1, boolean[] diag2, List<List<String>> result) {
21        if (row == n) {
22            result.add(construct(board));
23            return;
24        }
25
26        for (int col = 0; col < n; col++) {
27            int d1 = row - col + n;
28            int d2 = row + col;
29            if (cols[col] || diag1[d1] || diag2[d2]) {
30                continue;
31            }
32
33            board[row][col] = 'Q';
34            cols[col] = true;
35            diag1[d1] = true;
36            diag2[d2] = true;
37
38            backtrack(row + 1, n, board, cols, diag1, diag2, result);
39
40            board[row][col] = '.';
41            cols[col] = false;
42            diag1[d1] = false;
43            diag2[d2] = false;
44        }
45    }
46
47    private List<String> construct(char[][] board) {
48        List<String> path = new ArrayList<>();
49        for (int i = 0; i < board.length; i++) {
50            path.add(new String(board[i]));
51        }
52        return path;
53    }
54}