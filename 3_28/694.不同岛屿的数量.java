import java.util.HashSet;

class Solution {
    public int numDistinctIslands(int[][] grid) {
        HashSet<String> res = new HashSet<>();

        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == 1) {
                    StringBuilder sb = new StringBuilder();
                    dfs(grid, i, j, sb, 0);
                    res.add(sb.toString());
                }
            }
        }

        return res.size();
    }

    private void dfs(int[][] grid, int x, int y, StringBuilder sb, int dir) {
        int m = grid.length;
        int n = grid[0].length;

        if (x < 0 || y < 0 || x >= m || y >= n) {
            return;
        }

        if (grid[x][y] == 0) {
            return;
        }

        grid[x][y] = 0;

        int[][] dirs = { { 1, 0, 1 }, { -1, 0, 2 }, { 0, 1, 3 }, { 0, -1, 4 } };

        sb.append(dir).append(',');
        for (int[] d : dirs) {
            dfs(grid, x + d[0], y + d[1], sb, dir + d[2]);
        }
        sb.append(-dir).append('.');
    }
}