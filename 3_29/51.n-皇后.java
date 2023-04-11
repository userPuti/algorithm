import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/*
 * @lc app=leetcode.cn id=51 lang=java
 *
 * [51] N 皇后
 */

// @lc code=start
class Solution {
    List<List<String>> res = new LinkedList<>();

    public List<List<String>> solveNQueens(int n) {
        List<String> board = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            StringBuilder sb = new StringBuilder();
            for (int j = 0; j < n; j++) {
                sb.append('.');
            }
            board.add(sb.toString());
        }
        backtrack(board, 0);
        return res;
    }

    private void backtrack(List<String> board, int row) {
        if (row == board.size()) {
            res.add(new ArrayList<>(board));
            return;
        }

        int n = board.get(row).length();
        for (int col = 0; col < n; col++) {
            if (isValid(board, row, col)) {
                StringBuilder sb = new StringBuilder(board.get(row));
                sb.setCharAt(col, 'Q');
                board.set(row, sb.toString());
                backtrack(board, row + 1);
                sb.setCharAt(col, '.');
                board.set(row, sb.toString());
            }
        }
    }

    private static boolean isValid(List<String> board, int x, int y) {
        int row = x - 1;
        int col = y;

        while (row >= 0) {
            if (board.get(row).charAt(col) == 'Q') {
                return false;
            }
            row--;
        }

        row = x - 1;
        col = y - 1;
        while (row >= 0 && col >= 0) {
            if (board.get(row).charAt(col) == 'Q') {
                return false;
            }
            row--;
            col--;
        }

        row = x - 1;
        col = y + 1;
        int n = board.size();
        while (row >= 0 && col < n) {
            if (board.get(row).charAt(col) == 'Q') {
                return false;
            }
            row--;
            col++;
        }

        return true;
    }
}
// @lc code=end
