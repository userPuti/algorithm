import java.util.LinkedList;
import java.util.List;

/*
 * @lc app=leetcode.cn id=139 lang=java
 *
 * [139] 单词拆分
 * 回溯的方法超时
 */

// @lc code=start
class Solution {
    LinkedList<String> track = new LinkedList<>();

    public boolean wordBreak(String s, List<String> wordDict) {
        return backtrack(s, 0, wordDict);
    }

    private boolean backtrack(String s, int index, List<String> wordDict) {
        if (index == s.length()) {
            return true;
        }

        boolean found = false;
        for (String word : wordDict) {
            if (index + word.length() <= s.length() && s.substring(index, index + word.length()).equals(word)) {
                track.add(word);
                found = backtrack(s, index + word.length(), wordDict);
                track.removeLast();
            }
        }
        
        return found;
    }
}
// @lc code=end

