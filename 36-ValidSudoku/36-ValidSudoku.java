// Last updated: 7/18/2026, 5:06:43 PM
1class Solution {
2    static {
3        for (int index = 0; index < 100; index++)
4            isValidSudoku(new char[9][9]);
5    }
6    public static boolean isValidSudoku(char[][] board) {
7        int[] rowMask = new int[9];
8        int[] columnMask = new int[9];
9        int[] boxMask = new int[9];
10
11        for (int row = 0; row < 9; row++) {
12            for (int column = 0; column < 9; column++) {
13                if (board[row][column] == '.') continue;
14                int bit = 1 << (board[row][column] - '1');
15                int box = (row / 3) * 3 + column / 3;
16
17                if ((rowMask[row] & bit) != 0 || (columnMask[column] & bit) != 0 || (boxMask[box] & bit) != 0) return false;
18                
19                rowMask[row] |= bit;
20                columnMask[column] |= bit;
21                boxMask[box] |= bit;
22            }
23        }
24
25        return true;
26    }
27}