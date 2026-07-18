// Last updated: 7/18/2026, 8:57:19 PM
1class Solution {
2    public void rotate(int[][] matrix) {
3        int n = matrix.length;
4        
5        for (int i = 0; i < n; i++) {
6            for (int j = i + 1; j < n; j++) {
7                int temp = matrix[i][j];
8                matrix[i][j] = matrix[j][i];
9                matrix[j][i] = temp;
10            }
11        }
12        
13        for (int i = 0; i < n; i++) {
14            int left = 0, right = n - 1;
15            while (left < right) {
16                int temp = matrix[i][left];
17                matrix[i][left] = matrix[i][right];
18                matrix[i][right] = temp;
19                left++;
20                right--;
21            }
22        }
23    }
24}