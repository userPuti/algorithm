/*
 * @lc app=leetcode.cn id=52 lang=java
 *
 * [52] N 皇后 II
 */

// @lc code=start
class Solution {

    public int totalNQueens(int n) {
        int[][] grid = new int[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                grid[i][j] = 0;
            }
        }

        return backtrack(grid, 0);

    }

    private int backtrack(int[][] grid, int row) {
        int count = 0;

        if (row == grid.length) {
            return 1;
        }

        for (int col = 0; col < grid.length; col++) {
            if (isvalid(grid, row, col)) {
                grid[row][col] = 1;
                count += backtrack(grid, row + 1);
                grid[row][col] = 0;
            }
        }
        return count;
    }

    private boolean isvalid(int[][] grid, int x, int y) {
        int n = grid.length;

        int row = x - 1;
        int col = y;

        while (row >= 0) {
            if (grid[row][col] == 1) {
                return false;
            }
            row--;
        }

        row = x - 1;
        col = y - 1;
        while (row >= 0 && col >= 0) {
            if (grid[row][col] == 1) {
                return false;
            }
            row--;
            col--;
        }

        row = x - 1;
        col = y + 1;
        while (row >= 0 && col < n) {
            if (grid[row][col] == 1) {
                return false;
            }
            row--;
            col++;
        }

        return true;
    }
}
// @lc code=end
