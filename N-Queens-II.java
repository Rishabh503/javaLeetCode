import java.util.*;

class Solution {
    public int totalNQueens(int n) {
        boolean[][] board = new boolean[n][n];
        return countSolutions(board, n, 0);
    }

    public static boolean isSafe(boolean[][] board, int row, int col) {
        // left diagonal
        int r = row, c = col;
        while (r >= 0 && c >= 0) {
            if (board[r][c]) return false;
            r--; c--;
        }

        // right diagonal
        r = row; c = col;
        while (r >= 0 && c < board.length) {
            if (board[r][c]) return false;
            r--; c++;
        }

        // straight up
        r = row;
        while (r >= 0) {
            if (board[r][col]) return false;
            r--;
        }

        return true;
    }

    public static int countSolutions(boolean[][] board, int tq, int row) {
        if (tq == 0) {
            return 1;
        }

        int count = 0;
        for (int col = 0; col < board.length; col++) {
            if (isSafe(board, row, col)) {
                board[row][col] = true;
                count += countSolutions(board, tq - 1, row + 1);
                board[row][col] = false;
            }
        }

        return count;
    }
}
