import java.util.Arrays;

/*
 * @lc app=leetcode.cn id=115 lang=java
 *
 * [115] 不同的子序列
 */

// @lc code=start
class Solution {
    int[][] memo;

    public int numDistinct(String s, String t) {
        int m = s.length();
        int n = t.length();

        memo = new int[m][n];
        for (int[] row : memo) {
            Arrays.fill(row, -1);
        }

        return dp(s, 0, t, 0);
    }

    private int dp(String s, int i, String t, int j) {
        if (j == t.length()) {
            return 1;
        }

        if (s.length() - i < t.length() - j) {
            return 0;
        }

        if (memo[i][j] != -1) {
            return memo[i][j];
        }

        int res = 0;
        if (s.charAt(i) == t.charAt(j)) {
            res += dp(s, i + 1, t, j + 1) + dp(s, i + 1, t, j);
        } else {
            res += dp(s, i + 1, t, j);
        }
        
        memo[i][j] = res;
        return res;
    }
}
// @lc code=end
