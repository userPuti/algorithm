import java.util.Arrays;

/*
 * @lc app=leetcode.cn id=516 lang=java
 *
 * [516] 最长回文子序列
 * 
 * 
 */

// @lc code=start
class Solution {
    int[][] memo;

    public int longestPalindromeSubseq(String s) {
        memo = new int[s.length()][s.length()];

        for (int[] row : memo) {
            Arrays.fill(row, -1);
        }

        return dp(s, 0, s.length() - 1);
    }

    /**
     * dp表示从i到j之间最长的回文子序列的长度
     * @param s 字符串s
     * @param i 下标i
     * @param j 下标j
     * @return dp表示从i到j之间最长的回文子序列的长度
     */
    private int dp(String s, int i, int j) {
        if (i > j) {
            return 0;
        }

        if (i == j) {
            return 1;
        }

        if (memo[i][j] != -1) {
            return memo[i][j];
        }

        if (s.charAt(i) == s.charAt(j)) {
            memo[i][j] =  dp(s, i + 1, j - 1) + 2;
        } else {
            memo[i][j] = Math.max(dp(s, i + 1, j), dp(s, i, j - 1));
        }

        return memo[i][j];
    }
}
// @lc code=end
