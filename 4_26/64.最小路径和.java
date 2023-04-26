import java.util.Arrays;

/*
 * @lc app=leetcode.cn id=64 lang=java
 *
 * [64] 最小路径和
 */

// @lc code=start
class Solution {
    int[][] grid;
    int[][] memo;

    public int minPathSum(int[][] grid) {
        this.grid = grid;
        int m = grid.length;
        int n = grid[0].length;
        memo = new int[m][n];
        
        for (int[] row : memo) {
            Arrays.fill(row, -1);
        }

        return dp(m - 1, n - 1);
    }

    private int dp(int i, int j) {
        if (i < 0 || j < 0) {
            return Integer.MAX_VALUE;
        }

        if (i == 0 && j == 0) {
            return grid[0][0];
        }

        if (memo[i][j] != -1) {
            return memo[i][j];
        }

        return memo[i][j] = Math.min(dp(i - 1, j), dp(i, j - 1)) + grid[i][j];
    }
}
// @lc code=end
