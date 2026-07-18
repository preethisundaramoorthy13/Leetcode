// Last updated: 7/18/2026, 5:07:52 PM
1class Solution {
2    public void solveSudoku(char[][] board) {
3        solve(board);
4    }
5
6    private boolean solve(char[][] board) {
7        for (int i = 0; i < 9; i++) {
8            for (int j = 0; j < 9; j++) {
9                if (board[i][j] == '.') {
10                    for (char c = '1'; c <= '9'; c++) {
11                        if (isValid(board, i, j, c)) {
12                            board[i][j] = c;
13
14                            if (solve(board)) {
15                                return true;
16                            } else {
17                                board[i][j] = '.';
18                            }
19                        }
20                    }
21                    return false;
22                }
23            }
24        }
25        return true;
26    }
27
28    private boolean isValid(char[][] board, int row, int col, char c) {
29        for (int i = 0; i < 9; i++) {
30            if (board[i][col] == c) return false;
31            if (board[row][i] == c) return false;
32            if (board[3 * (row / 3) + i / 3][3 * (col / 3) + i % 3] == c) return false;
33        }
34        return true;
35    }
36}