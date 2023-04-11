/*
 * @lc app=leetcode.cn id=53 lang=java
 *
 * [53] 最大子数组和
 */

// @lc code=start
class Solution {
    public int maxSubArray(int[] nums) {
        int left = 0, right = 0;

        int windowSum = 0;
        int maxSum = Integer.MIN_VALUE;
        while (right < nums.length) {
            windowSum += nums[right];
            right++;

            maxSum = maxSum > windowSum ? maxSum : windowSum;

            while (windowSum < 0) {
                windowSum -= nums[left];
                left++;
            }
        }
        return maxSum;
    }
}
// @lc code=end

