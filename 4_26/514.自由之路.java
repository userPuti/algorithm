import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;

/*
 * @lc app=leetcode.cn id=514 lang=java
 *
 * [514] 自由之路
 */

// @lc code=start
class Solution {
    int[][] memo;
    HashMap<Character, List<Integer>> map = new HashMap<>();

    public int findRotateSteps(String ring, String key) {
        int m = ring.length();
        int n = key.length();

        memo = new int[m][n];

        for (int[] row : memo) {
            Arrays.fill(row, -1);
        }

        for (int i = 0; i < m; i++) {
            char c = ring.charAt(i);

            if (!map.containsKey(c)) {
                map.put(c, new LinkedList<>());
            }

            map.get(c).add(i);
        }

        return dp(ring, 0, key, 0);

    }

    private int dp(String ring, int i, String key, int j) {
        int m = ring.length();
        int n = key.length();

        if (j == n) {
            return 0;
        }

        if (memo[i][j] != -1) {
            return memo[i][j];
        }

        int res = Integer.MAX_VALUE;

        for (int k : map.get(key.charAt(j))) {
            // 拨打的次数
            int delta = Math.abs(k - i);
            // 顺时针或逆时针旋转
            delta = Math.min(delta, m - delta);
            // 求解子问题
            int subProblem = dp(ring, k, key, j + 1);
            // 寻求一个整体的最优解
            res = Math.min(res, 1 + delta + subProblem);
        }

        return memo[i][j] = res;
    }
}
// @lc code=end
