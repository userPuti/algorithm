import java.util.Arrays;
import java.util.List;

/*
 * @lc app=leetcode.cn id=139 lang=java
 *
 * [139] 单词拆分
 */

// @lc code=start
class Solution {
    int[] memo;
    public boolean wordBreak(String s, List<String> wordDict) {
        memo = new int[s.length()];
        Arrays.fill(memo, -1);
        return dp(s, 0, wordDict);
    }


    private boolean dp(String s, int index, List<String> wordDict) {
        if (index == s.length()) {
            return true;
        }

        if (memo[index] != -1) {
            return memo[index] == 1 ? true : false;
        }

        for (int len = 1; len <= s.length(); len++) {
            if (index + len <= s.length() && wordDict.contains(s.substring(index, index + len))) {
                boolean subProblem = dp(s, index + len, wordDict);
                if (subProblem) {
                    memo[index] = 1;
                    return true;
                }
            }
        }
        memo[index] = 0;
        return false;
    }
}
// @lc code=end

