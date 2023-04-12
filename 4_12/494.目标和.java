import java.util.Arrays;

/*
 * @lc app=leetcode.cn id=494 lang=java
 *
 * [494] 目标和
 */

// @lc code=start
class Solution {
    public int findTargetSumWays(int[] nums, int target) {
        return dfs(nums, 0, 0, target);
    }
    
    private int dfs(int[] nums, int index, int sum, int target) {
        if (index == nums.length) {
            return sum == target ? 1 : 0;
        }
        int ways = 0;
        ways += dfs(nums, index+1, sum + nums[index], target); // 添加加号
        ways += dfs(nums, index+1, sum - nums[index], target); // 添加减号
        return ways;
    }
}
// @lc code=end

