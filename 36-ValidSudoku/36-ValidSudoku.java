// Last updated: 7/18/2026, 4:06:26 PM
1import java.util.HashSet;
2import java.util.Set;
3
4class Solution {
5    public boolean isValidSudoku(char[][] board) {
6        Set<String> seen = new HashSet<>();
7        
8        for (int i = 0; i < 9; i++) {
9            for (int j = 0; j < 9; j++) {
10                char currentVal = board[i][j];
11                
12                // Only validate filled cells
13                if (currentVal != '.') {
14                    // Unique keys for row, column, and block tracking
15                    String rowKey = currentVal + " in row " + i;
16                    String colKey = currentVal + " in col " + j;
17                    String blockKey = currentVal + " in block " + (i / 3) + "-" + (j / 3);
18                    
19                    // If any key already exists in the set, the board is invalid
20                    if (!seen.add(rowKey) || !seen.add(colKey) || !seen.add(blockKey)) {
21                        return false;
22                    }
23                }
24            }
25        }
26        
27        return true;
28    }
29}