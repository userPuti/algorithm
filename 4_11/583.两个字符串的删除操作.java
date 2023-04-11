import java.util.Arrays;

/*
 * @lc app=leetcode.cn id=583 lang=java
 *
 * [583] 两个字符串的删除操作
 */

// @lc code=start
class Solution {
    int[][] memo;

    public int minDistance(String word1, String word2) {
        memo = new int[word1.length()][word2.length()];

        for (int[] row : memo) {
            Arrays.fill(row, -1);
        }

        return dp(word1, 0, word2, 0);
    }

    private int dp(String s1, int i, String s2, int j) {
        if (i == s1.length()) {
            return s2.length() - j;
        }

        if (j == s2.length()) {
            return s1.length() - i;
        }

        if (memo[i][j] != -1) {
            return memo[i][j];
        }

        if (s1.charAt(i) == s2.charAt(j)) {
            memo[i][j] = dp(s1, i + 1, s2, j + 1);
        } else {
            memo[i][j] = Math.min(1 + dp(s1, i + 1, s2, j), 1 + dp(s1, i, s2, j + 1));
        }

        return memo[i][j];
    }
}
// @lc code=end
