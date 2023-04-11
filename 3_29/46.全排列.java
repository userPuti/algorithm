import java.util.LinkedList;
import java.util.List;

/*
 * @lc app=leetcode.cn id=46 lang=java
 *
 * [46] 全排列
 */

// @lc code=start
class Solution {
    List<List<Integer>> res = new LinkedList<>();

    public List<List<Integer>> permute(int[] nums) {
        int len = nums.length;

        boolean[] used = new boolean[len];
        LinkedList<Integer> track = new LinkedList<>();
        backtrack(nums, track, used);
        return res;
    }

    private void backtrack(int[] nums, LinkedList<Integer> track, boolean[] used) {
        if (track.size() == nums.length) {
            res.add(new LinkedList<>(track));
            return;
        }

        for (int i = 0; i < nums.length; i++) {
            if (!used[i]) {
                track.add(nums[i]);
                used[i] = true;

                backtrack(nums, track, used);

                used[i] = false;
                track.removeLast();
            }
        }
    }
}
// @lc code=end
