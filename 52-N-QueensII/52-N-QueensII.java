// Last updated: 7/18/2026, 9:10:38 PM
1class Solution {
2    private int count = 0;
3
4    public int totalNQueens(int n) {
5        boolean[] cols = new boolean[n];
6        boolean[] diag1 = new boolean[2 * n];
7        boolean[] diag2 = new boolean[2 * n];
8        backtrack(0, n, cols, diag1, diag2);
9        return count;
10    }
11
12    private void backtrack(int row, int n, boolean[] cols, boolean[] diag1, boolean[] diag2) {
13        if (row == n) {
14            count++;
15            return;
16        }
17
18        for (int col = 0; col < n; col++) {
19            int d1 = row - col + n;
20            int d2 = row + col;
21            
22            if (cols[col] || diag1[d1] || diag2[d2]) {
23                continue;
24            }
25
26            cols[col] = true;
27            diag1[d1] = true;
28            diag2[d2] = true;
29
30            backtrack(row + 1, n, cols, diag1, diag2);
31
32            cols[col] = false;
33            diag1[d1] = false;
34            diag2[d2] = false;
35        }
36    }
37}