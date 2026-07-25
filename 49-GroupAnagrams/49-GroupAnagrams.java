// Last updated: 7/25/2026, 2:08:45 PM
1import java.util.*;
2
3class Solution {
4    public List<Integer> spiralOrder(int[][] matrix) {
5        List<Integer> result = new ArrayList<>();
6        if (matrix == null || matrix.length == 0) return result;
7
8        int top = 0;
9        int bottom = matrix.length - 1;
10        int left = 0;
11        int right = matrix[0].length - 1;
12
13        while (top <= bottom && left <= right) {
14            for (int col = left; col <= right; col++) {
15                result.add(matrix[top][col]);
16            }
17            top++;
18
19            for (int row = top; row <= bottom; row++) {
20                result.add(matrix[row][right]);
21            }
22            right--;
23
24            if (top <= bottom) {
25                for (int col = right; col >= left; col--) {
26                    result.add(matrix[bottom][col]);
27                }
28                bottom--;
29            }
30
31            if (left <= right) {
32                for (int row = bottom; row >= top; row--) {
33                    result.add(matrix[row][left]);
34                }
35                left++;
36            }
37        }
38
39        return result;
40    }
41}