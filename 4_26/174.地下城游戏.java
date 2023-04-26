import java.util.Arrays;

/*
 * @lc app=leetcode.cn id=174 lang=java
 *
 * [174] 地下城游戏
 */

// @lc code=start
class Solution {
    int[][] memo;
    int[][] dungeon;
    public int calculateMinimumHP(int[][] dungeon) {
        this.dungeon = dungeon;

        int m = dungeon.length;
        int n = dungeon[0].length;

        memo = new int[m][n];

        for (int[] row : memo) {
            Arrays.fill(row, -1);
        }

        return dp(0, 0);
    }

    private int dp(int i, int j) {
        int m = dungeon.length;
        int n = dungeon[0].length;

        if (i == m - 1 && j == n - 1) {
            return dungeon[i][j] >= 0 ? 1 : -dungeon[i][j] + 1;
        }

        if (i == m || j == n) {
            return Integer.MAX_VALUE;
        }

        if (memo[i][j] != -1) {
            return memo[i][j];
        }

        int res = Math.min(dp(i + 1, j), dp(i, j + 1)) - dungeon[i][j];

        memo[i][j] = res > 0 ? res : 1;

        return memo[i][j];
    }
}
// @lc code=end

