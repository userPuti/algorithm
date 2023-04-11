import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;

/*
 * @lc app=leetcode.cn id=140 lang=java
 *
 * [140] 单词拆分 II
 */

// @lc code=start
class Solution {
    HashSet<String> wordDict;

    List<String>[] memo;

    public List<String> wordBreak(String s, List<String> wordDict) {
        this.wordDict = new HashSet<>(wordDict);
        memo = new List[s.length()];
        return dp(s, 0);
    }

    private List<String> dp(String s, int index) {
        List<String> res = new LinkedList<>();
        if (index == s.length()) {
            res.add("");
            return res;
        }

        if (memo[index] != null) {
            return memo[index];
        }

        for (int len = 1; index + len <= s.length(); len++) {
            String prefix = s.substring(index, index + len);
            if (wordDict.contains(prefix)) {
                List<String> subProblem = dp(s, index + len);
                for(String sp : subProblem){
                    if (sp.isEmpty()) {
                        res.add(prefix);
                    } else {
                        res.add(prefix + " " + sp);
                    }
                }
            }
        }

        memo[index] = res;
        return res;
    }
}
// @lc code=end
