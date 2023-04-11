import java.util.LinkedList;
import java.util.List;

/*
 * @lc app=leetcode.cn id=140 lang=java
 *
 * [140] 单词拆分 II
 */

// @lc code=start
class Solution {

    List<String> res = new LinkedList<>();
    LinkedList<String> track = new LinkedList<>();
    
    List<String> wordDict;
    public List<String> wordBreak(String s, List<String> wordDict) {
        this.wordDict = wordDict;
        backtrack(s, 0);
        return res;
    }

    private void backtrack(String s, int index) {
        if (index == s.length()) {
            res.add(String.join(" ", track));
            return;
        }

        for (String word : wordDict) {
            if (index + word.length() <= s.length() && s.substring(index, index + word.length()).equals(word)) {
                track.add(word);
                backtrack(s, index + word.length());
                track.removeLast();
            }
        }
    }
}
// @lc code=end

