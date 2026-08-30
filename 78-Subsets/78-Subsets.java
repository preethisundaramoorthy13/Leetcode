// Last updated: 8/30/2026, 12:58:53 PM
class Solution {
    public boolean exist(char[][] board, String word) {
        int m = board.length;
        int n = board[0].length;
        char[] w = word.toCharArray();
        int len = w.length;

        if (len > m * n) {
            return false;
        }

        int[] counts = new int[128];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                counts[board[i][j]]++;
            }
        }

        int[] wordCounts = new int[128];
        for (char c : w) {
            if (++wordCounts[c] > counts[c]) {
                return false;
            }
        }

        if (counts[w[0]] > counts[w[len - 1]]) {
            for (int i = 0; i < len / 2; i++) {
                char temp = w[i];
                w[i] = w[len - 1 - i];
                w[len - 1 - i] = temp;
            }
        }

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (board[i][j] == w[0] && dfs(board, w, i, j, 0)) {
                    return true;
                }
            }
        }
        
        return false;
    }

    private boolean dfs(char[][] board, char[] w, int i, int j, int index) {
        if (index == w.length) {
            return true;
        }
        
        if (i < 0 || i >= board.length || j < 0 || j >= board[0].length || board[i][j] != w[index]) {
            return false;
        }

        char temp = board[i][j];
        board[i][j] = '#';

        boolean found = dfs(board, w, i + 1, j, index + 1)
                     || dfs(board, w, i - 1, j, index + 1)
                     || dfs(board, w, i, j + 1, index + 1)
                     || dfs(board, w, i, j - 1, index + 1);

        board[i][j] = temp;
        return found;
    }
}
