import java.util.Arrays;

/*
 * @lc app=leetcode.cn id=1312 lang=java
 *
 * [1312] 让字符串成为回文串的最少插入次数
 */

// @lc code=start
class Solution {
    int[][] memo;

    public int minInsertions(String s) {
        memo = new int[s.length()][s.length()];

        for (int[] row : memo) {
            Arrays.fill(row, -1);
        }

        return dp(s, 0, s.length() - 1);
    }

    private int dp(String s, int i, int j) {
        if (i >= j) {
            return 0;
        }
        
        if (memo[i][j] != -1) {
            return memo[i][j];
        }

        if (s.charAt(i) == s.charAt(j)) {
            memo[i][j] =  dp(s, i + 1, j - 1);
        } else {
            memo[i][j] = Math.min(1 + dp(s, i + 1, j), 1 + dp(s, i, j - 1));
        }
        
        return memo[i][j];
    }
}
// @lc code=end

