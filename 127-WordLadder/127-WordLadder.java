// Last updated: 9/21/2026, 3:07:06 PM
class Solution {
    private void qRegion(char[][] board, int y, int x){
        board[y][x] = 'Q';
        if (x > 0 && board[y][x-1] == 'O') qRegion(board, y, x-1);
        if (x < board[0].length-1 && board[y][x+1] == 'O') qRegion(board, y, x+1);
        if (y > 0 && board[y-1][x] == 'O') qRegion(board, y-1, x);
        if (y < board.length-1 && board[y+1][x] == 'O') qRegion(board, y+1, x);
    }

    private void replaceOnBoard(char[][] board, char oldC, char newC){
        for (int y = 0; y < board.length; y++){
            for (int x = 0; x < board[0].length; x++){
                if (board[y][x] == oldC) board[y][x] = newC;
            }
        }
    }

    public void solve(char[][] board) {
        int m = board.length;
        int n = board[0].length;
        for (int i = 0; i < n; i++){ // top and bottom
            if (board[0][i] == 'O') qRegion(board, 0, i);
            if (board[m-1][i] == 'O') qRegion(board, m-1, i);
        }
        for (int i = 1; i < m-1; i++){ // left and right
            if (board[i][0] == 'O') qRegion(board, i, 0);
            if (board[i][n-1] == 'O') qRegion(board, i, n-1);
        }
        replaceOnBoard(board, 'O', 'X');
        replaceOnBoard(board, 'Q', 'O');
    }
}