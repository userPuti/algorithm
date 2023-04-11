import java.util.Arrays;

/*
 * @lc app=leetcode.cn id=1143 lang=java
 *
 * [1143] 最长公共子序列
 */

// @lc code=start
class Solution {
    int memo[][];

    public int longestCommonSubsequence(String text1, String text2) {
        int m = text1.length();
        int n = text2.length();

        memo = new int[m][n];
        for (int[] row : memo) {
            Arrays.fill(row, -1);
        }

        return dp(text1, 0, text2, 0);
    }

    private int dp(String s1, int i, String s2, int j) {
        if (i == s1.length() || j == s2.length()) {
            return 0;
        }

        if (memo[i][j] != -1) {
            return memo[i][j];
        }

        if (s1.charAt(i) == s2.charAt(j)) {
            memo[i][j] =  1 + dp(s1, i + 1, s2, j + 1);
        } else {
            memo[i][j] = max(dp(s1, i + 1, s2, j),
                    dp(s1, i, s2, j + 1),
                    dp(s1, i + 1, s2, j + 1));
        }
        return memo[i][j];
    }

    private int max(int a, int b, int c) {
        return Math.max(a, Math.max(b, c));
    }
}
// @lc code=end
