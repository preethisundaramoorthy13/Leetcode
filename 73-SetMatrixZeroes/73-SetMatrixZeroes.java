// Last updated: 8/30/2026, 12:54:12 PM
1class Solution {
2    public void setZeroes(int[][] matrix) {
3        int rows = matrix.length;
4        int cols = matrix[0].length;
5
6        boolean firstRowZero = false;
7        boolean firstColZero = false;
8
9        // Step 1: Check if the first row or first column contains any zeroes
10        for (int r = 0; r < rows; r++) {
11            if (matrix[r][0] == 0) {
12                firstColZero = true;
13                break;
14            }
15        }
16        for (int c = 0; c < cols; c++) {
17            if (matrix[0][c] == 0) {
18                firstRowZero = true;
19                break;
20            }
21        }
22
23        // Step 2: Use the first row and column as flags for the rest of the matrix
24        for (int r = 1; r < rows; r++) {
25            for (int c = 1; c < cols; c++) {
26                if (matrix[r][c] == 0) {
27                    matrix[r][0] = 0;
28                    matrix[0][c] = 0;
29                }
30            }
31        }
32
33        // Step 3: Zero out cells based on the flags stored in the first row/col
34        for (int r = 1; r < rows; r++) {
35            for (int c = 1; c < cols; c++) {
36                if (matrix[r][0] == 0 || matrix[0][c] == 0) {
37                    matrix[r][c] = 0;
38                }
39            }
40        }
41
42        // Step 4: Zero out the first column if necessary
43        if (firstColZero) {
44            for (int r = 0; r < rows; r++) {
45                matrix[r][0] = 0;
46            }
47        }
48
49        // Step 5: Zero out the first row if necessary
50        if (firstRowZero) {
51            for (int c = 0; c < cols; c++) {
52                matrix[0][c] = 0;
53            }
54        }
55    }
56}