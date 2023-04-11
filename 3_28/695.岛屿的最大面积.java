/*
 * @lc app=leetcode.cn id=695 lang=java
 *
 * [695] 岛屿的最大面积
 */

// @lc code=start
class Solution {
    public int maxAreaOfIsland(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;

        int res = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 1) {
                    res = Math.max(res, dfs(grid, i, j));
                }
            }
        }
        return res;
    }

    private int dfs(int[][] grid, int x, int y) {
        int m = grid.length;
        int n = grid[0].length;

        int[][] dirs = { { 1, 0 }, { -1, 0 }, { 0, 1 }, { 0, -1 } };

        if (x < 0 || y < 0 || x >= m || y >= n) {
            return 0;
        }

        if (grid[x][y] == 0) {
            return 0;
        }

        grid[x][y] = 0;

        int res = 1;

        for (int[] dir : dirs) {
            res += dfs(grid, x + dir[0], y + dir[1]);
        }

        return res;
    }
}
// @lc code=end
